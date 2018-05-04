package com.example.demo.service;

import com.example.demo.vo.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2018/5/4.
 */
@Component
public class CustomUserDeatilsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if("user".equals(s)){
            return new SecurityUser("user","password1","user-role");
        }else if("admin".equals(s)){
            return new SecurityUser("admin","password2","admin-role");
        }
        return null;
    }
}
