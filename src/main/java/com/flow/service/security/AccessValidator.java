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
package com.flow.service.security;


import com.flow.controller.HttpValidationCallback;
import com.flow.domain.exception.MoniException;
import com.flow.domain.user.User;
import com.flow.service.exception.ToErrorResponseEntity;
import com.flow.service.security.model.SecurityUser;
import com.flow.service.security.permission.Operation;
import com.flow.service.user.UserService;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author jerry
 * @date 2019-10-07 20:10
 */
@Component
public class AccessValidator {

    public static final String CUSTOMER_USER_IS_NOT_ALLOWED_TO_PERFORM_THIS_OPERATION = "Customer user is not allowed to perform this operation!";
    public static final String SYSTEM_ADMINISTRATOR_IS_NOT_ALLOWED_TO_PERFORM_THIS_OPERATION = "System administrator is not allowed to perform this operation!";
    public static final String DEVICE_WITH_REQUESTED_ID_NOT_FOUND = "Device with requested id wasn't found!";
    public static final String ENTITY_VIEW_WITH_REQUESTED_ID_NOT_FOUND = "Entity-view with requested id wasn't found!";


    @Autowired
    protected UserService userService;



    private ExecutorService executor;

    @PostConstruct
    public void initExecutor() {
        executor = Executors.newSingleThreadExecutor();
    }

    @PreDestroy
    public void shutdownExecutor() {
        if (executor != null) {
            executor.shutdownNow();
        }
    }

    public DeferredResult<ResponseEntity> validateEntityAndCallback(SecurityUser currentUser,
                                                                    ThreeConsumer<DeferredResult<ResponseEntity>, String> onSuccess) throws MoniException {
        return validateEntityAndCallback(currentUser, Operation.ALL, currentUser.getUserId(), onSuccess, (result, t) -> handleError(t, result, HttpStatus.INTERNAL_SERVER_ERROR));

    }

    public DeferredResult<ResponseEntity> validateEntityAndCallback(SecurityUser currentUser, Operation operation, String entityIdStr,
                                                                    ThreeConsumer<DeferredResult<ResponseEntity>, String> onSuccess) throws MoniException {
        return validateEntityAndCallback(currentUser, operation, entityIdStr, onSuccess, (result, t) -> handleError(t, result, HttpStatus.INTERNAL_SERVER_ERROR));
    }


    public DeferredResult<ResponseEntity> validateEntityAndCallback(SecurityUser currentUser, Operation operation, String userId,
                                                                    ThreeConsumer<DeferredResult<ResponseEntity>, String> onSuccess,
                                                                    BiConsumer<DeferredResult<ResponseEntity>, Throwable> onFailure) throws MoniException {

        final DeferredResult<ResponseEntity> response = new DeferredResult<>();

        validate(currentUser, new HttpValidationCallback(response,
                new FutureCallback<DeferredResult<ResponseEntity>>() {
                    @Override
                    public void onSuccess(@Nullable DeferredResult<ResponseEntity> result) {
                        onSuccess.accept(response, currentUser.getUserId());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        onFailure.accept(response, t);
                    }
                }));

        return response;
    }

    public void validate(SecurityUser currentUser, FutureCallback<ValidationResult> callback) {
        validateCustomer(currentUser, callback);


    }


    private void validateCustomer(final SecurityUser currentUser, FutureCallback<ValidationResult> callback) {

        ListenableFuture<User> customerFuture = userService.findCustomerByIdAsync(currentUser.getUserId());
        Futures.addCallback(customerFuture, getCallback(callback, customer -> {
            if (customer == null) {
                return ValidationResult.entityNotFound("Customer with requested id wasn't found!");
            } else {
//                    try {
//                        accessControlService.checkPermission(currentUser, Resource.CUSTOMER, operation, entityId, customer);
//                    } catch (MoniException e) {
//                        return ValidationResult.accessDenied(e.getMessage());
//                    }
                return ValidationResult.ok(customer);
            }
        }), executor);

    }

    private <T, V> FutureCallback<T> getCallback(FutureCallback<ValidationResult> callback, Function<T, ValidationResult<V>> transformer) {
        return new FutureCallback<T>() {
            @Override
            public void onSuccess(@Nullable T result) {
                callback.onSuccess(transformer.apply(result));
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t);
            }
        };
    }

    public static void handleError(Throwable e, final DeferredResult<ResponseEntity> response, HttpStatus defaultErrorStatus) {
        ResponseEntity responseEntity;
        if (e != null && e instanceof ToErrorResponseEntity) {
            responseEntity = ((ToErrorResponseEntity) e).toErrorResponseEntity();
        } else if (e != null && e instanceof IllegalArgumentException) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } else {
            responseEntity = new ResponseEntity<>(defaultErrorStatus);
        }
        response.setResult(responseEntity);
    }

    public interface ThreeConsumer<A, B> {
        void accept(A a, B b);
    }
}
