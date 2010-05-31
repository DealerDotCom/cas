/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.adaptors.trusted.authentication.handler.support;

import org.jasig.cas.adaptors.trusted.authentication.principal.PrincipalBearingCredentials;
import org.jasig.cas.server.authentication.AbstractNamedAuthenticationHandler;
import org.jasig.cas.server.authentication.Credential;

import java.security.GeneralSecurityException;

/**
 * AuthenticationHandler which authenticates Principal-bearing credentials.
 * Authentication must have occured at the time the Principal-bearing
 * credentials were created, so we perform no further authentication. Thus
 * merely by being presented a PrincipalBearingCredentials, this handler returns
 * true.
 * 
 * @author Andrew Petro
 * @version $Revision$ $Date$
 * @since 3.0.5
 */
public final class PrincipalBearingCredentialsAuthenticationHandler extends AbstractNamedAuthenticationHandler {

    public final boolean authenticate(final Credential credentials) throws GeneralSecurityException {
        if (log.isDebugEnabled()) {
            log.debug("Trusting credentials for: " + credentials);
        }
        return true;
    }

    public boolean supports(final Credential credentials) {
        return credentials.getClass().equals(PrincipalBearingCredentials.class);
    }
}