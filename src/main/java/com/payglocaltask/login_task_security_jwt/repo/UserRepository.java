package com.payglocaltask.login_task_security_jwt.repo;

import com.payglocaltask.login_task_security_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email); // Add this line
}
