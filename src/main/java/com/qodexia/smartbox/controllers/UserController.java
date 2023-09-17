package com.qodexia.smartbox.controllers;

import com.qodexia.smartbox.models.UserDto;
import com.qodexia.smartbox.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/recruiters")
    public ResponseEntity<UserDto> createRecruiter(@RequestBody @Valid UserDto userDto) {
        UserDto createdUserDto = userService.createRecruiter(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDto);
    }

    @GetMapping("/entreprises/{entId}/managers")
    public ResponseEntity<Set<UserDto>> getManagersOfEntreprise(@PathVariable Long entId) {
        Set<UserDto> managers = userService.getManagerOfEntreprise(entId);
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/entreprises/{entId}/recruiters")
    public ResponseEntity<Set<UserDto>> getRecruitersOfEntreprise(@PathVariable Long entId) {
        Set<UserDto> recruiters = userService.getRecruiterOfEntreprise(entId);
        return ResponseEntity.ok(recruiters);
    }
}
