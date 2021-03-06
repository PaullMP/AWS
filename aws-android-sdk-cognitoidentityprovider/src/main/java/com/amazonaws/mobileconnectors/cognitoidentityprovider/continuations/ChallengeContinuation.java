/*
 *  Copyright 2013-2016 Amazon.com,
 *  Inc. or its affiliates. All Rights Reserved.
 *
 *  Licensed under the Amazon Software License (the "License").
 *  You may not use this file except in compliance with the
 *  License. A copy of the License is located at
 *
 *      http://aws.amazon.com/asl/
 *
 *  or in the "license" file accompanying this file. This file is
 *  distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, express or implied. See the License
 *  for the specific language governing permissions and
 *  limitations under the License.
 */

package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a Continuation for a generic auth-challenge. This Continuation is used for all developer
 * driven challenges.
 */
public class ChallengeContinuation implements CognitoIdentityProviderContinuation<Map<String, String>> {

    // Boolean constants used to indicate where this continuation will run.
    final public static boolean RUN_IN_BACKGROUND = true;
    final public static boolean RUN_IN_CURRENT = false;

    private final RespondToAuthChallengeResult challengeResult;
    private final Context context;
    private final String clientId;
    private final CognitoUser user;
    private final AuthenticationHandler callback;
    private Map<String, String> challengeResponses;
    private boolean runInBackground;

    public ChallengeContinuation(CognitoUser user,
                                 Context context,
                                 String clientId,
                                 RespondToAuthChallengeResult challengeResult,
                                 boolean runInBackground,
                                 AuthenticationHandler callback) {
        this.challengeResult = challengeResult;
        this.context = context;
        this.clientId = clientId;
        this.user = user;
        this.callback = callback;
        this.runInBackground = runInBackground;
        challengeResponses = new HashMap<String, String>();
    }

    /**
     * Returns the challenges parameters for a generic challenge (developer defined) challenge.
     * The keys in this map are usually determined by the developer. They should contain all the
     * information and resources required by the app, to determine the type of challenge and to
     * present the challenge to the user. This opens up the authentication process to the developers
     * to bring their custom steps to authenticate to Cognito User Pools.
     *
     * @return A {@link Map<String, String>} containing parameters for this auth challenge process.
     */
    public Map<String, String> getParameters() {
        return challengeResult.getChallengeParameters();
    }

    /**
     * Add responses to the authentication challenge. The responses are added as key-value pairs. The
     * keys are usually unique to the challenge and are often determined by the developers who have
     * set this challenge.  <b>Note:</b> Overrides an earlier value set for an attribute
     * which was already added to this object.
     *
     * @param responseKey
     * @param responseValue
     */
    public void setChallengeResponse(String responseKey, String responseValue) {
        challengeResponses.put(responseKey, responseValue);
    }

    /**
     * Continues the authentication process by responding to the generic challenge posed by the system.
     * This invokes the method to respond to the generic authentication challenge in the current or on
     * a background thread depending up on how the authentication process with initiated.
     * This method gets a {@link Runnable} which is is always executed in the applications thread.
     * The mechanism to identify the current thread and to run the returned {@link Runnable} in the apps
     * thread is implemented in this method.
     */
    public void continueTask() {
        final RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        respondToAuthChallengeRequest.setChallengeName(challengeResult.getChallengeName());
        respondToAuthChallengeRequest.setSession(challengeResult.getSession());
        respondToAuthChallengeRequest.setClientId(null);
        if (runInBackground) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Handler handler = new Handler(context.getMainLooper());
                    Runnable nextStep;
                    try {
                        nextStep = user.respondToChallenge(respondToAuthChallengeRequest, callback, RUN_IN_BACKGROUND);
                    } catch (final Exception e) {
                        nextStep = new Runnable() {
                            @Override
                            public void run() {
                                callback.onFailure(e);
                            }
                        };
                    }
                    handler.post(nextStep);
                }
            }).start();
        } else {
            Runnable nextStep;
            try {
                nextStep = user.respondToChallenge(respondToAuthChallengeRequest, callback, RUN_IN_CURRENT);
            } catch (final Exception e) {
                nextStep = new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(e);
                    }
                };
            }
            nextStep.run();
        }
    }
}
