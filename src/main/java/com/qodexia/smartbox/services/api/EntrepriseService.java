package com.qodexia.smartbox.services.api;


import com.qodexia.smartbox.domains.Entreprise;
import com.qodexia.smartbox.models.EntrepriseDto;

public interface EntrepriseService {

    EntrepriseDto createEntreprise(EntrepriseDto entrepriseDto);
    EntrepriseDto updateEntreprise(EntrepriseDto entrepriseDto);
    EntrepriseDto getEntrepriseById(Long id);
    EntrepriseDto getEntrepriseByUserId(Long id);
    void deleteEntrepriseById(Long id);

}
