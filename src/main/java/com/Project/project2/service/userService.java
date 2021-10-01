package com.Project.project2.service;

import com.Project.project2.model.User;
import com.Project.project2.web.dto.userRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface userService extends UserDetailsService {

    User save(userRegistrationDto registrationDto);
    boolean verify(String email);

}
