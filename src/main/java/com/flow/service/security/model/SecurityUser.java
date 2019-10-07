/**
 * Copyright © 2016-2019 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flow.service.security.model;

import com.flow.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jerry
 * @date 2019-10-07 20:10
 */
public class SecurityUser extends User {

    private static final long serialVersionUID = -797397440703066079L;

    private Collection<GrantedAuthority> authorities;
    private boolean enabled;
    private UserPrincipal userPrincipal;

    public SecurityUser() {
        super();
    }

    public SecurityUser(String userId) {
        super(userId);
    }



    public SecurityUser(User user, boolean enabled, UserPrincipal userPrincipal) {
        this.enabled = enabled;
        this.userPrincipal = userPrincipal;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = Stream.of(SecurityUser.this.getAuthority())
                    .map(authority -> new SimpleGrantedAuthority(authority.name()))
                    .collect(Collectors.toList());
        }
        return authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public UserPrincipal getUserPrincipal() {
        return userPrincipal;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUserPrincipal(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

}
