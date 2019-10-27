package com.flow.domain.user;

import com.flow.domain.security.Authority;
import lombok.Data;

/**
 * @author jerry
 * @date 2019-10-07 20:03
 */
@Data
public class User {

    private String userId;
    private String userName;
    //private String email;
    private String phone;
    private String nikeName;
    private Authority authority;
    private String password;

    public User(){}

    public User(String userId){
        this.userId=userId;
    }
}
