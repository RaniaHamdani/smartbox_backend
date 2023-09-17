package com.qodexia.smartbox.mapper;

import com.qodexia.smartbox.domains.Adresse;
import com.qodexia.smartbox.models.AdresseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdresseMapper {

    Adresse addressDtoToAdress(AdresseDTO AdresseDTO);

    @Mapping(target = "userId", source = "Adresse.user.id")
    AdresseDTO addressToAddressDto(Adresse Adresse);

    List<Adresse> addressDtoListToAddressList(List<AdresseDTO> AdresseDTOS);

    List<AdresseDTO> addressListToAddressDtoList(List<Adresse> Adresses);

}
