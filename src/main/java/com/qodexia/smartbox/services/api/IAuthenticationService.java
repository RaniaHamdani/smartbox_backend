package com.qodexia.smartbox.services.api;

import com.qodexia.smartbox.domains.User;
import com.qodexia.smartbox.models.JwtRequest;
import com.qodexia.smartbox.models.JwtResponse;
import com.google.zxing.common.BitMatrix;
import com.qodexia.smartbox.models.UserDto;

import java.security.Principal;
import java.util.Map;

/**
 * @author RadhCHbinou created on 21/mai/2022 11:35
 **/
public interface IAuthenticationService {
  Map<String ,Object> authenticateUser(JwtRequest authenticationRequest) throws Exception;

  UserDto createUser(UserDto user) throws Exception;


}
