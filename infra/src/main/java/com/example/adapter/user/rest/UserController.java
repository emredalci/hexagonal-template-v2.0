package com.example.adapter.user.rest;

import com.example.adapter.user.rest.dto.CreateUserRequest;
import com.example.adapter.user.rest.dto.CreateUserResponse;
import com.example.adapter.user.rest.dto.RetrieveUserResponse;
import com.example.common.usecase.UseCaseHandler;
import com.example.user.model.CreateUser;
import com.example.user.model.RetrieveUser;
import com.example.user.usecase.CreateUserUseCase;
import com.example.user.usecase.RetrieveUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UseCaseHandler<CreateUser, CreateUserUseCase> createUserHandler;
    private final UseCaseHandler<RetrieveUser, RetrieveUserUseCase> retrieveUserHandler;

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> create(@RequestBody @Valid CreateUserRequest createUserRequest) {
        CreateUser createUser = createUserHandler.handler(createUserRequest.toUseCase());
        return ResponseEntity.ok().body(CreateUserResponse.fromModel(createUser));
    }

    @GetMapping("/{mail}")
    public ResponseEntity<RetrieveUserResponse> retrieve(@PathVariable String mail) {
        RetrieveUser retrieveUser = retrieveUserHandler.handler(toRetrieveUserUseCase(mail));
        return ResponseEntity.ok().body(RetrieveUserResponse.fromModel(retrieveUser));
    }

    private RetrieveUserUseCase toRetrieveUserUseCase(String mail) {
        return new RetrieveUserUseCase(mail);
    }
}
