package com.workshop.workshop.infrastructure.helpers.mappers;

import com.workshop.workshop.api.dto.request.UserRequest;
import com.workshop.workshop.api.dto.response.UserAllResponse;
import com.workshop.workshop.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest userRequest);

    UserAllResponse toUserResponse(User user);

    @Mapping(target = "id", ignore = true)

    void updateFromUserRequest(UserRequest userRequest, @MappingTarget User user);
}
