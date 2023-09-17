package com.qodexia.smartbox.services.implementation;

import com.qodexia.smartbox.domains.Entreprise;
import com.qodexia.smartbox.domains.User;
import com.qodexia.smartbox.enums.Roles;
import com.qodexia.smartbox.exceptions.BadRequestException;
import com.qodexia.smartbox.exceptions.RessourceNotFoundException;
import com.qodexia.smartbox.mapper.UserMapper;
import com.qodexia.smartbox.models.UserDto;
import com.qodexia.smartbox.repositories.EntrepriseRepository;
import com.qodexia.smartbox.repositories.UserRepository;
import com.qodexia.smartbox.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author RadhCHbinou created on 11/juin./2023 11:51
 **/
@Service
@Transactional
public class JwtUserDetailsService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RessourceNotFoundException("l'utilisateur n'existe pas"));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getAuthority(user)
        );
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getNom())));
        return authorities;
    }

    @Override
    @Transactional
    public UserDto createRecruiter(UserDto user) {
        Optional<User> opt = userRepository.findByUsername(user.getUsername());
        if (opt.isPresent()) {
            throw new BadRequestException("User already exists");
        }
        if (user.getPassword().isEmpty()) {
            throw new BadRequestException("Vous devez choisir un mot de passe");
        }
        if (user.getRoles().stream().filter(roleUserDto -> !roleUserDto.getNom().equals(Roles.ROLE_RECRUTEUR.name())).collect(Collectors.toSet()).size() > 0) {
            throw new BadRequestException("seulement un recruteur peut être crée a partir de cette interface");
        }
        User userToSave = userMapper.userDTOToUser(user);
        userToSave.setPassword(bcryptEncoder.encode(user.getPassword()));
        userToSave.setRoles(userToSave.getRoles().stream().peek(roleUser -> roleUser.setUser(userToSave)).collect(Collectors.toSet()));
        if (user.getAdresse() != null) {
            userToSave.getAdresse().setUser(userToSave);
        }
        if (user.getRoles().stream().anyMatch(roleUserDto -> roleUserDto.getNom().equals(Roles.ROLE_RECRUTEUR.name())) && (user.getEntrepriseDto() == null || user.getEntrepriseDto().getId() == null)) {
            throw new BadRequestException("il faut affecté le recruteur a une entreprise");
        } else if (user.getEntrepriseDto() != null && user.getEntrepriseDto().getId() != null) {
            Entreprise entreprise = entrepriseRepository.findById(user.getEntrepriseDto().getId()).orElseThrow(() -> new RessourceNotFoundException("Entreprise n'éxiste pas"));
            userToSave.setEntreprise(entreprise);
        }
        return userMapper.userToUserDTO(userRepository.save(userToSave));
    }

    @Override
    public Set<UserDto> getManagerOfEntreprise(Long entId) {
        return userMapper.userListTouserDtoList(userRepository.getUsersOfEntrepriseByRoleName(entId, Roles.ROLE_MANAGER.name()));
    }

    @Override
    public Set<UserDto> getRecruiterOfEntreprise(Long entId) {
        return userMapper.userListTouserDtoList(userRepository.getUsersOfEntrepriseByRoleName(entId, Roles.ROLE_MANAGER.name()));
    }
}
