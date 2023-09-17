package com.qodexia.smartbox.services.implementation;

import com.qodexia.smartbox.configurations.security.JwtTokenUtil;
import com.qodexia.smartbox.domains.User;
import com.qodexia.smartbox.exceptions.BadRequestException;
import com.qodexia.smartbox.mapper.UserMapper;
import com.qodexia.smartbox.models.JwtRequest;
import com.qodexia.smartbox.models.UserDto;
import com.qodexia.smartbox.repositories.UserRepository;
import com.qodexia.smartbox.services.api.IAuthenticationService;
import com.qodexia.smartbox.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RadhCHbinou created on 21/mai/2022 11:35
 **/
@Service
@Transactional
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUserService userDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private UserMapper userMapper;


    @Override
    public Map<String, Object> authenticateUser(JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        Map<String, Object> resp = new HashMap<>();
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        resp.put("jwttoken", token);
        return resp;
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto user) throws Exception {
        Optional<User> opt = userRepository.findByUsername(user.getUsername());
        if (opt.isPresent()) {
            throw new BadRequestException("User already exists");
        }
        if (user.getPassword().isEmpty()) {
            throw new BadRequestException("Vous devez choisir un mot de passe");
        }
        User userToSave = userMapper.userDTOToUser(user);
        userToSave.setPassword(bcryptEncoder.encode(user.getPassword()));
        userToSave.setRoles(userToSave.getRoles().stream().peek(roleUser -> roleUser.setUser(userToSave)).collect(Collectors.toSet()));
        if (user.getAdresse() != null) {
            userToSave.getAdresse().setUser(userToSave);
        }
        return userMapper.userToUserDTO(userRepository.save(userToSave));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
