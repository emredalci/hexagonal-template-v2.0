package com.example.user.usecase;

import com.example.common.DomainComponent;
import com.example.common.usecase.UseCaseHandler;
import com.example.user.model.CreateUser;
import com.example.user.port.UserPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class CreateUserHandler implements UseCaseHandler<CreateUser, CreateUserUseCase> {

    private final UserPort userPort;

    @Override
    public CreateUser handler(CreateUserUseCase useCase) {
        return userPort.save(useCase);
    }
}
