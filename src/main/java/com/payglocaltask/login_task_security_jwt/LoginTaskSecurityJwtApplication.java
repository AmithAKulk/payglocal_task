package com.payglocaltask.login_task_security_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
//public class LoginTaskSecurityJwtApplication {
//
//	public static void main(String[] args) {
//
//		SpringApplication.run(LoginTaskSecurityJwtApplication.class, args);
//	}
//
//}
public class LoginTaskSecurityJwtApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LoginTaskSecurityJwtApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        // Print loaded properties
        Environment env = context.getEnvironment();
        System.out.println("Loaded Properties: " + Arrays.toString(env.getActiveProfiles()));
    }
}