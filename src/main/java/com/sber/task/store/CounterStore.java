package com.sber.task.store;

import com.sber.task.model.Counter;

import java.util.Collection;
import java.util.Optional;

public interface CounterStore {

    Counter create(String name);

    Optional<Counter> getByName(String counterId);

    void deleteByName(String counterId);

    Collection<Counter> getAllCounters();
}
