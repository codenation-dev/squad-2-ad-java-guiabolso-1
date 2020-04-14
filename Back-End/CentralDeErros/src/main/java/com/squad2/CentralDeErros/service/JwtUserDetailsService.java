package com.squad2.CentralDeErros.service;

import com.squad2.CentralDeErros.entity.Role;
import com.squad2.CentralDeErros.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        final boolean ACCOUNT_NON_EXPIRED = true;
        final boolean CREDENTIALS_NON_EXPIRED = true;
        final boolean ACCOUNT_NON_LOCKED = true;

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getActive(), ACCOUNT_NON_EXPIRED, CREDENTIALS_NON_EXPIRED, ACCOUNT_NON_LOCKED, authorities);
    }
}
