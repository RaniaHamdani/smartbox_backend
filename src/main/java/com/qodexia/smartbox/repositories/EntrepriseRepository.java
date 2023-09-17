package com.qodexia.smartbox.repositories;

import com.qodexia.smartbox.domains.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    @Query(nativeQuery = true, value = "select e.* from entreprise e left join users u on u.entreprise_id = e.id where u.id = :userId")
    Optional<Entreprise> findOneByUserId(@Param("userId") Long id);
}
