package com.qodexia.smartbox.mapper;

import com.qodexia.smartbox.domains.Entreprise;
import com.qodexia.smartbox.models.EntrepriseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {UserMapper.class})
public interface EntrepriseMapper {

    EntrepriseDto entrepriseToEntrepriseDto(Entreprise entreprise);

    Set<EntrepriseDto> entrepriseSetToEntrepriseDtoSet(Set<Entreprise> entreprise);

    Entreprise entrepriseDtoToEntreprise(EntrepriseDto entreprise);

    Set<Entreprise> entrepriseDtoSetToEntrepriseSet(Set<EntrepriseDto> entreprise);

}
