package com.qodexia.smartbox.repositories;

import com.qodexia.smartbox.domains.RoleUser;
import com.qodexia.smartbox.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
* @author RadhCHbinou created on 11/avr./2022 12:03
**/
@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
}
