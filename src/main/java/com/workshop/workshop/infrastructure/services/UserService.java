package com.workshop.workshop.infrastructure.services;

import com.workshop.workshop.api.dto.request.UserRequest;
import com.workshop.workshop.api.dto.response.UserAllResponse;
import com.workshop.workshop.domain.entities.User;
import com.workshop.workshop.domain.repositories.UserRepository;
import com.workshop.workshop.infrastructure.abstract_services.IUserService;
import com.workshop.workshop.infrastructure.helpers.mappers.UserMapper;
import com.workshop.workshop.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserAllResponse create(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserAllResponse update(Long id, UserRequest userRequest) {
        User existingUser = getUserById(id);
        userMapper.updateFromUserRequest(userRequest, existingUser);
        User updateUser = userRepository.save(existingUser);
        return userMapper.toUserResponse(updateUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserAllResponse> getAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(userMapper::toUserResponse);
    }

    @Override
    public Optional<UserAllResponse> getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new IdNotFoundException("USER", id);
        return user.map(userMapper::toUserResponse);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("USER", id));
    }
}
