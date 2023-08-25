package com.example.common.usecase;

public interface UseCaseHandler <E,T extends UseCase>{

    E handler(T useCase);
}
