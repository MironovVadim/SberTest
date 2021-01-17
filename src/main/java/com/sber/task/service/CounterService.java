package com.sber.task.service;

import com.sber.task.dto.CounterDto;

import java.util.Set;

public interface CounterService {
    CounterDto create(String name);

    CounterDto incrementByName(String counterId);

    int getCountByName(String counterId);

    void deleteByName(String counterId);

    int getCountersSum();

    Set<String> getUniqueNames();
}
