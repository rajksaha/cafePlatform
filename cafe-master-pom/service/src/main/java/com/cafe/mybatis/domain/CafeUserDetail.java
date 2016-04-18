package com.cafe.mybatis.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by raj on 3/20/2016.
 */
public class CafeUserDetail extends User {


    private UserData loggedInUserdata;

    public CafeUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserData getLoggedInUserdata() {
        return loggedInUserdata;
    }

    public void setLoggedInUserdata(UserData loggedInUserdata) {
        this.loggedInUserdata = loggedInUserdata;
    }
}
