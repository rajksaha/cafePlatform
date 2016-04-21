package com.cafe.web.security;

import com.cafe.common.exception.CafeException;
import com.cafe.mybatis.domain.CafeUserDetail;
import com.cafe.mybatis.domain.UserData;
import com.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class CafeUserDetailsService implements UserDetailsService {


    @Value("${login.fail.count}")
    private Integer failAttemptMaxCount;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData user = null;
        try {
            user = userService.getUserByUserName(username);
        } catch (CafeException e) {
            throw new BadCredentialsException("System error");
        }

        if (user == null || user.getUserID() == null || user.getUserID().equals(0)) {
            throw new BadCredentialsException("Invalid username entered");
        }

        /*if (user.getStatus() == null || user.getStatus().equals(0)) {
            throw new BadCredentialsException("Your account is deactivated. Please contact with administrator");
        }*/

        /*if (BooleanUtils.toBoolean(user.getIsBlocked())) {
            throw new BadCredentialsException("Your account has been blocked. Please contact with administrator");
        }*/

        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

        grantedAuths.add(new SimpleGrantedAuthority(user.getLevel().toString()));


        CafeUserDetail cafeUserDetail = new CafeUserDetail(user.getUsername(), user.getPassword(), grantedAuths);

        cafeUserDetail.setLoggedInUserdata(user);

        return cafeUserDetail;
    }

}
