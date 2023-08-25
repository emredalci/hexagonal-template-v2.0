package com.example.common.usecase;

public interface VoidUseCaseHandler <T extends UseCase>{

    void handler(T useCase);
}
