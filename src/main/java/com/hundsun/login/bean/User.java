package com.hundsun.login.bean;

/**
 * 用户信息
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private String ldapAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLdapAccount() {
        return ldapAccount;
    }

    public void setLdapAccount(String ldapAccount) {
        this.ldapAccount = ldapAccount;
    }
}
