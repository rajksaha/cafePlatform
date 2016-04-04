package com.cafe.web.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class BfpbUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Value("${login.fail.count}")
    private Integer failAttemptMaxCount;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*User user = null;
        try {
            user = userService.getUserByUserName(username);
        } catch (BfpbException e) {
            throw new BadCredentialsException("System error");
        }

        if (user == null || user.getUserId() == null || user.getUserId().equals(0)) {
            throw new BadCredentialsException("Invalid username entered");
        }

        if (user.getStatus() == null || user.getStatus().equals(0)) {
            throw new BadCredentialsException("Your account is deactivated. Please contact with administrator");
        }

        if (BooleanUtils.toBoolean(user.getIsBlocked())) {
            throw new BadCredentialsException("Your account has been blocked. Please contact with administrator");
        }

        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

        try {
            List<UserRole> rolesPermissions = userService.getPermissionByUserId(user.getUserId());

            if (rolesPermissions != null && rolesPermissions.size() > 0) {
                for (UserRole role : rolesPermissions) {
                    grantedAuths.add(new SimpleGrantedAuthority(role.getPermissionName()));
                }
            } else {
                throw new BadCredentialsException("No Permission is assigned to this user");
            }

        } catch (BfpbException e) {
            throw new BadCredentialsException("Error while loading user permission");
        }

        FamsUserDetails famsUD = new FamsUserDetails(user.getUsername(), user.getPassword(), grantedAuths);
        famsUD.setUserId(user.getUserId());
        famsUD.setProfile(user.getProfile());*/

        return null;
    }

}
