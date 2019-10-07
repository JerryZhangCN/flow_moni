/**
 * Copyright © 2016-2019 The Thingsboard Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flow.service.security.auth.jwt;


import com.flow.domain.user.User;
import com.flow.service.security.auth.RefreshAuthenticationToken;
import com.flow.service.security.model.SecurityUser;
import com.flow.service.security.model.UserPrincipal;
import com.flow.service.security.model.token.JwtTokenFactory;
import com.flow.service.security.model.token.RawAccessJwtToken;
import com.flow.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class RefreshTokenAuthenticationProvider implements AuthenticationProvider {

    private final JwtTokenFactory tokenFactory;
    private final UserService userService;

    @Autowired
    public RefreshTokenAuthenticationProvider(final UserService userService, final JwtTokenFactory tokenFactory) {
        this.userService = userService;
        this.tokenFactory = tokenFactory;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();
        SecurityUser unsafeUser = tokenFactory.parseRefreshToken(rawAccessToken);
        UserPrincipal principal = unsafeUser.getUserPrincipal();
        SecurityUser securityUser = authenticateByUserId(unsafeUser.getUserId());
        return new RefreshAuthenticationToken(securityUser);
    }

    private SecurityUser authenticateByUserId(String userId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by refresh token");
        }
        if (user.getAuthority() == null)
            throw new InsufficientAuthenticationException("User has no authority assigned");

        UserPrincipal userPrincipal = new UserPrincipal(UserPrincipal.Type.USER_NAME, user.getEmail());

        SecurityUser securityUser = new SecurityUser(user, true, userPrincipal);

        return securityUser;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (RefreshAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
