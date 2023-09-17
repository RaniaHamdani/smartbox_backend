package com.qodexia.smartbox.repositories;

import com.qodexia.smartbox.domains.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {


}
