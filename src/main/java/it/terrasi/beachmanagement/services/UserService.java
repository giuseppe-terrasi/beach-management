package it.terrasi.beachmanagement.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.terrasi.beachmanagement.entities.Role;
import it.terrasi.beachmanagement.entities.User;
import it.terrasi.beachmanagement.repository.RoleRepository;
import it.terrasi.beachmanagement.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        Role role = roleRepository.findByRole("USER");

        Set<Role> userRoles = new HashSet<>();

        userRoles.add(role);
        user.setRoles(userRoles);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        return userRepository.save(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }    
    
}