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
package com.flow.service.security.auth.rest;

import com.flow.domain.user.User;
import com.flow.service.security.model.SecurityUser;
import com.flow.service.security.model.UserPrincipal;
import com.flow.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

    private final BCryptPasswordEncoder encoder;
    private final UserService userService;

    @Autowired
    public RestAuthenticationProvider(final UserService userService, final BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserPrincipal)) {
            throw new BadCredentialsException("Authentication Failed. Bad user principal.");
        }
        UserPrincipal userPrincipal = (UserPrincipal) principal;
        String username = userPrincipal.getValue();
        String password = (String) authentication.getCredentials();
        return authenticateByUsernameAndPassword(userPrincipal, username, password);

    }

    private Authentication authenticateByUsernameAndPassword(UserPrincipal userPrincipal, String username, String password) {
        User user = userService.findById(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

//        UserCredentials userCredentials = userService.findUserCredentialsByUserId(user.getId());
//        if (userCredentials == null) {
//            throw new UsernameNotFoundException("User credentials not found");
//        }
//
//        if (!userCredentials.isEnabled()) {
//            throw new DisabledException("User is not active");
//        }

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }

        if (user.getAuthority() == null)
            throw new InsufficientAuthenticationException("User has no authority assigned");

        SecurityUser securityUser = new SecurityUser(user, true, userPrincipal);

        return new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
