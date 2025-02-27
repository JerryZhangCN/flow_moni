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
package com.flow.controller;

import com.flow.service.security.ValidationCallback;
import com.google.common.util.concurrent.FutureCallback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author jerry
 * @date 2019-10-07 20:10
 */
public class HttpValidationCallback extends ValidationCallback<DeferredResult<ResponseEntity>> {

    public HttpValidationCallback(DeferredResult<ResponseEntity> response, FutureCallback<DeferredResult<ResponseEntity>> action) {
       super(response, action);
    }

}
