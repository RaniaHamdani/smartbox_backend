package com.qodexia.smartbox.controllers;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.qodexia.smartbox.models.JwtRequest;
import com.qodexia.smartbox.models.UserDto;
import com.qodexia.smartbox.services.api.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;


@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private IAuthenticationService iAuthenticationService;
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity authenticate(@RequestBody JwtRequest authenticationRequest) throws Exception {
        return ResponseEntity.ok(iAuthenticationService.authenticateUser(authenticationRequest));
    }
    @PostMapping("/save")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto user) throws Exception {
            return ResponseEntity.ok(iAuthenticationService.createUser(user));
    }
}
