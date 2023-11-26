package com.payglocaltask.login_task_security_jwt.services;

import com.payglocaltask.login_task_security_jwt.model.CustomUserDetails;
import com.payglocaltask.login_task_security_jwt.model.User;
import com.payglocaltask.login_task_security_jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final User user = this.userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        } else {
            return new CustomUserDetails(user);
        }
    }
}