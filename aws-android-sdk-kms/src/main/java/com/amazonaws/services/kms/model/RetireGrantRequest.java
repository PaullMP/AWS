/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.kms.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * Retires a grant. You can retire a grant when you're done using it to clean
 * up. You should revoke a grant when you intend to actively deny operations
 * that depend on it. The following are permitted to call this API:
 * </p>
 * <ul>
 * <li>
 * <p>
 * The account that created the grant
 * </p>
 * </li>
 * <li>
 * <p>
 * The <code>RetiringPrincipal</code>, if present
 * </p>
 * </li>
 * <li>
 * <p>
 * The <code>GranteePrincipal</code>, if <code>RetireGrant</code> is a grantee
 * operation
 * </p>
 * </li>
 * </ul>
 * <p>
 * The grant to retire must be identified by its grant token or by a combination
 * of the key ARN and the grant ID. A grant token is a unique variable-length
 * base64-encoded string. A grant ID is a 64 character unique identifier of a
 * grant. Both are returned by the <code>CreateGrant</code> function.
 * </p>
 */
public class RetireGrantRequest extends AmazonWebServiceRequest implements Serializable {
    /**
     * <p>
     * Token that identifies the grant to be retired.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 8192<br/>
     */
    private String grantToken;

    /**
     * <p>
     * A unique identifier for the customer master key associated with the
     * grant. This value can be a globally unique identifier or a fully
     * specified ARN of the key.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ARN Example -
     * arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234
     * -1234-123456789012
     * </p>
     * </li>
     * <li>
     * <p>
     * Globally Unique Key ID Example - 12345678-1234-1234-1234-123456789012
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 256<br/>
     */
    private String keyId;

    /**
     * <p>
     * Unique identifier of the grant to be retired. The grant ID is returned by
     * the <code>CreateGrant</code> function.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Grant ID Example -
     * 0123456789012345678901234567890123456789012345678901234567890123
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     */
    private String grantId;

    /**
     * <p>
     * Token that identifies the grant to be retired.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 8192<br/>
     *
     * @return <p>
     *         Token that identifies the grant to be retired.
     *         </p>
     */
    public String getGrantToken() {
        return grantToken;
    }

    /**
     * <p>
     * Token that identifies the grant to be retired.
     * </p>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 8192<br/>
     *
     * @param grantToken <p>
     *            Token that identifies the grant to be retired.
     *            </p>
     */
    public void setGrantToken(String grantToken) {
        this.grantToken = grantToken;
    }

    /**
     * <p>
     * Token that identifies the grant to be retired.
     * </p>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 8192<br/>
     *
     * @param grantToken <p>
     *            Token that identifies the grant to be retired.
     *            </p>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RetireGrantRequest withGrantToken(String grantToken) {
        this.grantToken = grantToken;
        return this;
    }

    /**
     * <p>
     * A unique identifier for the customer master key associated with the
     * grant. This value can be a globally unique identifier or a fully
     * specified ARN of the key.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ARN Example -
     * arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234
     * -1234-123456789012
     * </p>
     * </li>
     * <li>
     * <p>
     * Globally Unique Key ID Example - 12345678-1234-1234-1234-123456789012
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 256<br/>
     *
     * @return <p>
     *         A unique identifier for the customer master key associated with
     *         the grant. This value can be a globally unique identifier or a
     *         fully specified ARN of the key.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Key ARN Example -
     *         arn:aws:kms:us-east-1:123456789012:key/12345678-
     *         1234-1234-1234-123456789012
     *         </p>
     *         </li>
     *         <li>
     *         <p>
     *         Globally Unique Key ID Example -
     *         12345678-1234-1234-1234-123456789012
     *         </p>
     *         </li>
     *         </ul>
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * <p>
     * A unique identifier for the customer master key associated with the
     * grant. This value can be a globally unique identifier or a fully
     * specified ARN of the key.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ARN Example -
     * arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234
     * -1234-123456789012
     * </p>
     * </li>
     * <li>
     * <p>
     * Globally Unique Key ID Example - 12345678-1234-1234-1234-123456789012
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 256<br/>
     *
     * @param keyId <p>
     *            A unique identifier for the customer master key associated
     *            with the grant. This value can be a globally unique identifier
     *            or a fully specified ARN of the key.
     *            </p>
     *            <ul>
     *            <li>
     *            <p>
     *            Key ARN Example -
     *            arn:aws:kms:us-east-1:123456789012:key/12345678
     *            -1234-1234-1234-123456789012
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            Globally Unique Key ID Example -
     *            12345678-1234-1234-1234-123456789012
     *            </p>
     *            </li>
     *            </ul>
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    /**
     * <p>
     * A unique identifier for the customer master key associated with the
     * grant. This value can be a globally unique identifier or a fully
     * specified ARN of the key.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Key ARN Example -
     * arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234
     * -1234-123456789012
     * </p>
     * </li>
     * <li>
     * <p>
     * Globally Unique Key ID Example - 12345678-1234-1234-1234-123456789012
     * </p>
     * </li>
     * </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 256<br/>
     *
     * @param keyId <p>
     *            A unique identifier for the customer master key associated
     *            with the grant. This value can be a globally unique identifier
     *            or a fully specified ARN of the key.
     *            </p>
     *            <ul>
     *            <li>
     *            <p>
     *            Key ARN Example -
     *            arn:aws:kms:us-east-1:123456789012:key/12345678
     *            -1234-1234-1234-123456789012
     *            </p>
     *            </li>
     *            <li>
     *            <p>
     *            Globally Unique Key ID Example -
     *            12345678-1234-1234-1234-123456789012
     *            </p>
     *            </li>
     *            </ul>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RetireGrantRequest withKeyId(String keyId) {
        this.keyId = keyId;
        return this;
    }

    /**
     * <p>
     * Unique identifier of the grant to be retired. The grant ID is returned by
     * the <code>CreateGrant</code> function.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Grant ID Example -
     * 0123456789012345678901234567890123456789012345678901234567890123
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     *
     * @return <p>
     *         Unique identifier of the grant to be retired. The grant ID is
     *         returned by the <code>CreateGrant</code> function.
     *         </p>
     *         <ul>
     *         <li>
     *         <p>
     *         Grant ID Example -
     *         0123456789012345678901234567890123456789012345678901234567890123
     *         </p>
     *         </li>
     *         </ul>
     */
    public String getGrantId() {
        return grantId;
    }

    /**
     * <p>
     * Unique identifier of the grant to be retired. The grant ID is returned by
     * the <code>CreateGrant</code> function.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Grant ID Example -
     * 0123456789012345678901234567890123456789012345678901234567890123
     * </p>
     * </li>
     * </ul>
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     *
     * @param grantId <p>
     *            Unique identifier of the grant to be retired. The grant ID is
     *            returned by the <code>CreateGrant</code> function.
     *            </p>
     *            <ul>
     *            <li>
     *            <p>
     *            Grant ID Example -
     *            0123456789012345678901234567890123456789012345678901234567890123
     *            </p>
     *            </li>
     *            </ul>
     */
    public void setGrantId(String grantId) {
        this.grantId = grantId;
    }

    /**
     * <p>
     * Unique identifier of the grant to be retired. The grant ID is returned by
     * the <code>CreateGrant</code> function.
     * </p>
     * <ul>
     * <li>
     * <p>
     * Grant ID Example -
     * 0123456789012345678901234567890123456789012345678901234567890123
     * </p>
     * </li>
     * </ul>
     * <p>
     * Returns a reference to this object so that method calls can be chained
     * together.
     * <p>
     * <b>Constraints:</b><br/>
     * <b>Length: </b>1 - 128<br/>
     *
     * @param grantId <p>
     *            Unique identifier of the grant to be retired. The grant ID is
     *            returned by the <code>CreateGrant</code> function.
     *            </p>
     *            <ul>
     *            <li>
     *            <p>
     *            Grant ID Example -
     *            0123456789012345678901234567890123456789012345678901234567890123
     *            </p>
     *            </li>
     *            </ul>
     * @return A reference to this updated object so that method calls can be
     *         chained together.
     */
    public RetireGrantRequest withGrantId(String grantId) {
        this.grantId = grantId;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGrantToken() != null)
            sb.append("GrantToken: " + getGrantToken() + ",");
        if (getKeyId() != null)
            sb.append("KeyId: " + getKeyId() + ",");
        if (getGrantId() != null)
            sb.append("GrantId: " + getGrantId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getGrantToken() == null) ? 0 : getGrantToken().hashCode());
        hashCode = prime * hashCode + ((getKeyId() == null) ? 0 : getKeyId().hashCode());
        hashCode = prime * hashCode + ((getGrantId() == null) ? 0 : getGrantId().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof RetireGrantRequest == false)
            return false;
        RetireGrantRequest other = (RetireGrantRequest) obj;

        if (other.getGrantToken() == null ^ this.getGrantToken() == null)
            return false;
        if (other.getGrantToken() != null
                && other.getGrantToken().equals(this.getGrantToken()) == false)
            return false;
        if (other.getKeyId() == null ^ this.getKeyId() == null)
            return false;
        if (other.getKeyId() != null && other.getKeyId().equals(this.getKeyId()) == false)
            return false;
        if (other.getGrantId() == null ^ this.getGrantId() == null)
            return false;
        if (other.getGrantId() != null && other.getGrantId().equals(this.getGrantId()) == false)
            return false;
        return true;
    }
}
