package com.workshop.workshop.api.controllers;

import com.workshop.workshop.api.dto.request.UserRequest;
import com.workshop.workshop.api.dto.response.UserAllResponse;
import com.workshop.workshop.infrastructure.abstract_services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserAllResponse> saveUser(@Validated @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.create(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAllResponse> updateUser(
            @PathVariable Long id,
            @Validated @RequestBody UserRequest userRequest
    ) {
        return ResponseEntity.ok(userService.update(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserAllResponse>> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<UserAllResponse>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(userService.getAll(pageable));
    }
}
