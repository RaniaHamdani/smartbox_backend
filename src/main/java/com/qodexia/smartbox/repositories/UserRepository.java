package com.qodexia.smartbox.repositories;

import com.qodexia.smartbox.domains.User;
import com.qodexia.smartbox.models.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
* @author RadhCHbinou created on 11/avr./2022 12:03
**/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  @Query(nativeQuery = true,value = "select u.* from users as u left join role_user as ru on u.id = ru.user_id left join " +
          "entreprise as e on e.id = u.entreprise_id where e.id = :entId and upper(ru.name) like concat('%',:rolename,'%')")
  Set<User> getUsersOfEntrepriseByRoleName(@Param("entId") Long entId,@Param("rolename") String roleName);
}
