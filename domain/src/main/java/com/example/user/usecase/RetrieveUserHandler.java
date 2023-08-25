package com.example.user.usecase;

import com.example.common.DomainComponent;
import com.example.common.usecase.UseCaseHandler;
import com.example.user.model.RetrieveUser;
import com.example.user.port.UserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@DomainComponent
public class RetrieveUserHandler implements UseCaseHandler<RetrieveUser, RetrieveUserUseCase> {

    private final UserPort userPort;

    @Override
    public RetrieveUser handler(RetrieveUserUseCase useCase) {
        return userPort.get(useCase);
    }
}
