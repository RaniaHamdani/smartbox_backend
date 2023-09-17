package com.qodexia.smartbox.services.api;

import com.qodexia.smartbox.models.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface IUserService extends UserDetailsService {
    UserDto createRecruiter(UserDto user);

    Set<UserDto> getManagerOfEntreprise(Long entId);

    Set<UserDto> getRecruiterOfEntreprise(Long entId);
}
