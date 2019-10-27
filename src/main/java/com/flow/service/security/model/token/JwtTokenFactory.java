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
package com.flow.service.security.model.token;


import com.flow.config.JwtSettings;
import com.flow.domain.security.Authority;
import com.flow.service.security.model.SecurityUser;
import com.flow.service.security.model.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtTokenFactory {

    private static final String SCOPES = "scopes";
    private static final String USER_ID = "userId";
    private static final String USER_NAME = "userName";
    private static final String ENABLED = "enabled";
    private static final String IS_PUBLIC = "isPublic";
    private static final String PHONE = "phone";
    private static final String TOKEN_ISSUER = "monitor";
    private static final String TOKEN_SIGNING_KEY = "monitorDefaultSigningKey";
    private static final long TOKEN_EXPIRATION_TIME =90000000;
    private static final long REFRESH_TOKEN_EXPIRATION_TIME =3600;

    //private final JwtSettings settings;

    @Autowired
    public JwtTokenFactory(JwtSettings settings) {
//        this.settings = settings;
    }

    /**
     * Factory method for issuing new JWT Tokens.
     */
    public AccessJwtToken createAccessJwtToken(SecurityUser securityUser) {
        if (StringUtils.isBlank(securityUser.getUserName()))
            throw new IllegalArgumentException("Cannot create JWT Token without username/email");

//        if (securityUser.getAuthority() == null)
//            throw new IllegalArgumentException("User doesn't have any privileges");

        UserPrincipal principal = securityUser.getUserPrincipal();
        String subject = principal.getValue();
        Claims claims = Jwts.claims().setSubject(subject);
        //claims.put(SCOPES, securityUser.getAuthorities().stream().map(s -> s.getAuthority()).collect(Collectors.toList()));
        claims.put(USER_ID, securityUser.getUserId());
        claims.put(USER_NAME, securityUser.getUserName());
        claims.put(ENABLED, securityUser.isEnabled());
        claims.put(IS_PUBLIC, principal.getType() == UserPrincipal.Type.PUBLIC_ID);
        try {
            claims.put(PHONE, securityUser.getPhone());
        } catch (Exception e) {
            claims.put(PHONE,"");
        }

        ZonedDateTime currentTime = ZonedDateTime.now();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(TOKEN_ISSUER)
                .setIssuedAt(Date.from(currentTime.toInstant()))
                .setExpiration(Date.from(currentTime.plusSeconds(TOKEN_EXPIRATION_TIME).toInstant()))
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGNING_KEY)
                .compact();

        return new AccessJwtToken(token, claims);
    }

    public SecurityUser parseAccessJwtToken(RawAccessJwtToken rawAccessToken) {
        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(TOKEN_SIGNING_KEY);
        Claims claims = jwsClaims.getBody();
        String subject = claims.getSubject();
        List<String> scopes = claims.get(SCOPES, List.class);
//        if (scopes == null || scopes.isEmpty()) {
//            throw new IllegalArgumentException("JWT Token doesn't have any scopes");
//        }

        SecurityUser securityUser = new SecurityUser(claims.get(USER_ID, String.class));
//        securityUser.setEmail(subject);
//        securityUser.setAuthority(Authority.parse(scopes.get(0)));
        securityUser.setUserName(claims.get(USER_NAME, String.class));
        securityUser.setEnabled(claims.get(ENABLED, Boolean.class));
        boolean isPublic = claims.get(IS_PUBLIC, Boolean.class);
        UserPrincipal principal = new UserPrincipal(isPublic ? UserPrincipal.Type.PUBLIC_ID : UserPrincipal.Type.USER_NAME, subject);
        securityUser.setUserPrincipal(principal);
        return securityUser;
    }

    public JwtToken createRefreshToken(SecurityUser securityUser) {
        if (StringUtils.isBlank(securityUser.getUserName())) {
            throw new IllegalArgumentException("Cannot create JWT Token without username/email");
        }

        ZonedDateTime currentTime = ZonedDateTime.now();

        UserPrincipal principal = securityUser.getUserPrincipal();
        Claims claims = Jwts.claims().setSubject(principal.getValue());
        claims.put(SCOPES, Collections.singletonList(Authority.REFRESH_TOKEN.name()));
        claims.put(USER_ID, securityUser.getUserId());
        claims.put(IS_PUBLIC, principal.getType() == UserPrincipal.Type.PUBLIC_ID);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(TOKEN_ISSUER)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(currentTime.toInstant()))
                .setExpiration(Date.from(currentTime.plusSeconds(REFRESH_TOKEN_EXPIRATION_TIME).toInstant()))
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGNING_KEY)
                .compact();

        return new AccessJwtToken(token, claims);
    }

    public SecurityUser parseRefreshToken(RawAccessJwtToken rawAccessToken) {
        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(TOKEN_SIGNING_KEY);
        Claims claims = jwsClaims.getBody();
        String subject = claims.getSubject();
        List<String> scopes = claims.get(SCOPES, List.class);
        if (scopes == null || scopes.isEmpty()) {
            throw new IllegalArgumentException("Refresh Token doesn't have any scopes");
        }
        if (!scopes.get(0).equals(Authority.REFRESH_TOKEN.name())) {
            throw new IllegalArgumentException("Invalid Refresh Token scope");
        }
        UserPrincipal principal = new UserPrincipal(UserPrincipal.Type.USER_NAME, subject);
        SecurityUser securityUser = new SecurityUser(claims.get(USER_ID, String.class));
        securityUser.setUserPrincipal(principal);
        return securityUser;
    }

}
