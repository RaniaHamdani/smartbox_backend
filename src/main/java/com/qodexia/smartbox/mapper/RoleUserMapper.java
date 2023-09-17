package com.qodexia.smartbox.mapper;

import com.qodexia.smartbox.domains.RoleUser;
import com.qodexia.smartbox.models.RoleUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleUserMapper {

    RoleUserDto roleDtoToRole(RoleUser role);

    RoleUser roleToRoleDto(RoleUserDto dto);

    List<RoleUserDto> roleuserListToRoleuserDtoList(List<RoleUser> roles);

    List<RoleUser> roleuserDtoToRoleUserList(List<RoleUserDto> roles);

}
