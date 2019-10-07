package com.flow.domain;

import lombok.Data;

/**
 * @author jerry
 * @date 2019-10-07 17:15
 */
@Data
public class BaseResponse {
    private int resultCode;
    private Object data;

    public BaseResponse() {
    }

    public BaseResponse(int resultCode, Object data) {
        this.resultCode = resultCode;
        this.data = data;
    }
}
