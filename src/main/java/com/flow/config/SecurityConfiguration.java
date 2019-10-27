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
package com.flow.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flow.service.exception.ErrorResponseHandler;
import com.flow.service.security.auth.jwt.*;
import com.flow.service.security.auth.jwt.extractor.TokenExtractor;
import com.flow.service.security.auth.rest.RestAuthenticationProvider;
import com.flow.service.security.auth.rest.RestLoginProcessingFilter;
import com.flow.service.security.auth.rest.RestPublicLoginProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.*;

@Configuration
@EnableWebSecurity()
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final String JWT_TOKEN_HEADER_PARAM = "X-Authorization";
    public static final String JWT_TOKEN_QUERY_PARAM = "token";


    public static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/auth/login";
    public static final String PUBLIC_LOGIN_ENTRY_POINT = "/api/auth/login/public";
    public static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/token";
    protected static final String[] NON_TOKEN_BASED_AUTH_ENTRY_POINTS = new String[]{"/index.html", "/static/**", "/api/noauth/**", "/webjars/**"};
    //public static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
    public static final String WS_TOKEN_BASED_AUTH_ENTRY_POINT = "/api/ws/**";
    public static final String ENERGY = "/api/**";
    public static final String ALARM = "/api/moni_station/**";
    public static final String DATAMAINTENANCE = "/api/user/**";
    public static final String API_PLUGINS_RPC = "/api/plugins/rpc/**";
//    public static final String RELATIONALL="/api/relations/all";
//    public static final String VIRTUAL="/api/virtual/**";

    @Autowired
    private ErrorResponseHandler restAccessDeniedHandler;
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    private RestAuthenticationProvider restAuthenticationProvider;
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;
    @Autowired
    private RefreshTokenAuthenticationProvider refreshTokenAuthenticationProvider;

    @Autowired
    private MyWebfILTER myWebfILTER;

    @Autowired
    @Qualifier("jwtHeaderTokenExtractor")
    private TokenExtractor jwtHeaderTokenExtractor;

    @Autowired
    @Qualifier("jwtQueryTokenExtractor")
    private TokenExtractor jwtQueryTokenExtractor;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    protected RestLoginProcessingFilter buildRestLoginProcessingFilter() throws Exception {
        RestLoginProcessingFilter filter = new RestLoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler, failureHandler, objectMapper);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    protected RestPublicLoginProcessingFilter buildRestPublicLoginProcessingFilter() throws Exception {
        RestPublicLoginProcessingFilter filter = new RestPublicLoginProcessingFilter(PUBLIC_LOGIN_ENTRY_POINT, successHandler, failureHandler, objectMapper);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    protected JwtTokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter() throws Exception {
        List<String> pathsToSkip = new ArrayList(Arrays.asList(NON_TOKEN_BASED_AUTH_ENTRY_POINTS));
        pathsToSkip.addAll(Arrays.asList(WS_TOKEN_BASED_AUTH_ENTRY_POINT, TOKEN_REFRESH_ENTRY_POINT, FORM_BASED_LOGIN_ENTRY_POINT,
                PUBLIC_LOGIN_ENTRY_POINT,  ENERGY, DATAMAINTENANCE, ALARM, API_PLUGINS_RPC));
        SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, "api/auth/**");
        JwtTokenAuthenticationProcessingFilter filter
                = new JwtTokenAuthenticationProcessingFilter(failureHandler, jwtHeaderTokenExtractor, matcher);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    protected RefreshTokenProcessingFilter buildRefreshTokenProcessingFilter() throws Exception {
        RefreshTokenProcessingFilter filter = new RefreshTokenProcessingFilter(TOKEN_REFRESH_ENTRY_POINT, successHandler, failureHandler, objectMapper);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    protected JwtTokenAuthenticationProcessingFilter buildWsJwtTokenAuthenticationProcessingFilter() throws Exception {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(WS_TOKEN_BASED_AUTH_ENTRY_POINT);
        JwtTokenAuthenticationProcessingFilter filter
                = new JwtTokenAuthenticationProcessingFilter(failureHandler, jwtQueryTokenExtractor, matcher);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 身份验证管理生成器，添加认证provider
     * @RequestParam auth
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(restAuthenticationProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);
        auth.authenticationProvider(refreshTokenAuthenticationProvider);
    }


    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * web请求安全处理
     * @RequestParam web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    /**
     * http请求安全处理
     * @RequestParam http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl() //添加缓存控制
                .and()
                .frameOptions().disable()//禁用frameOptions
                .and()
                .cors() //添加跨域访问支持
                .and()
                .csrf().disable() //禁用CSRF
                .exceptionHandling() //网站异常？
                .and()
                .sessionManagement() // 定制我们自己的 session 策略
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 调整为让 Spring Security 不创建和使用 session
                .and()
                .authorizeRequests() //满足下列api列表的请求可以访问
                .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll()// Login end-point
                .antMatchers(ENERGY).permitAll()
                .and()
 //               .authorizeRequests()//满足下列api列表的必须要登录后才能访问
//                .antMatchers(ENERGY).authenticated() // Protected WebSocket API End-points
// .and()
                .exceptionHandling().accessDeniedHandler(restAccessDeniedHandler)//添加自定义访问异常处理
                .and()
                .addFilterBefore(myWebfILTER,UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildRestLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildRestPublicLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildRefreshTokenProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildWsJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }


//    @Bean
//    @ConditionalOnMissingBean(CorsFilter.class)
//    public CorsFilter corsFilter() {
//        Map<String, CorsConfiguration> mappings = new HashMap<>();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        List<String> methods = new ArrayList<>();
//        methods.add("POST");
//        methods.add("GET");
//        methods.add("OPTIONS");
//        methods.add("DELETE");
//        corsConfiguration.setAllowedMethods(methods);
//        List<String> headers = new ArrayList<>();
//        headers.add("access-control-allow-headers");
//        headers.add("access-control-allow-methods");
//        headers.add("access-control-allow-origin");
//        headers.add("access-control-max-age");
//        headers.add("X-Frame-Options");
//        corsConfiguration.setAllowedOrigins(Collections.singletonList(CorsConfiguration.ALL));
//        corsConfiguration.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));
//        corsConfiguration.setMaxAge(Long.parseLong("3600"));
//        corsConfiguration.setExposedHeaders(headers);
//        mappings.put("api/**", corsConfiguration);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.setCorsConfigurations(mappings);
//        CorsFilter corsFilter = new CorsFilter(source);
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(corsFilter);
//        filterRegistrationBean.setOrder(0);
//        return new CorsFilter(source);
//    }
}
