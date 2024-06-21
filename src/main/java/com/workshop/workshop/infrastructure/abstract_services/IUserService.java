package com.workshop.workshop.infrastructure.abstract_services;

import com.workshop.workshop.api.dto.request.UserRequest;
import com.workshop.workshop.api.dto.response.UserAllResponse;
import com.workshop.workshop.domain.entities.User;

public interface IUserService extends CRUDService<UserRequest, UserAllResponse, Long> {
    User getUserById(Long id);
}
