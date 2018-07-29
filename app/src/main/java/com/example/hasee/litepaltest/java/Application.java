package com.example.hasee.litepaltest.java;

import org.litepal.crud.LitePalSupport;

import java.util.UUID;

/**
 * Created by hasee on 2018/7/27.
 */

public class Application extends LitePalSupport {

    private String name;
    private String account;
    private String password;

    public Application(){
        super();
        name = UUID.randomUUID().toString();

    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
