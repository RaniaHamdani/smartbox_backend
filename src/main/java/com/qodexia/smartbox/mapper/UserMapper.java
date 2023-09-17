package com.qodexia.smartbox.mapper;

import com.qodexia.smartbox.domains.User;
import com.qodexia.smartbox.models.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {RoleUserMapper.class, AdresseMapper.class})
public interface UserMapper {

    UserDto userToUserDTO(User user);

    User userDTOToUser(UserDto dto);

    List<UserDto> userListTouserDtoList(List<User> users);

    List<User> userDtoToUserList(List<UserDto> userDTOS);

    Set<UserDto> userListTouserDtoList(Set<User> users);

    Set<User> userDtoToUserList(Set<UserDto> userDTOS);

}
