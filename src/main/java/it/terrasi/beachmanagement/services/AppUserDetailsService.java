package it.terrasi.beachmanagement.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.terrasi.beachmanagement.entities.Role;
import it.terrasi.beachmanagement.entities.User;
import it.terrasi.beachmanagement.models.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired 
    UserService userService;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        
        if(user == null) throw new UsernameNotFoundException("user not found");

        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> roles = new HashSet<>();

        for(Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return grantedAuthorities;
    }   


    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        AppUser appUser = new AppUser(user.getUsername(), user.getPassword(), 
                    user.isActive(), true, true, true, authorities);

        appUser.setFirstName(user.getFirstName());
        appUser.setLastName(user.getLastName());
        return appUser;
    }
}