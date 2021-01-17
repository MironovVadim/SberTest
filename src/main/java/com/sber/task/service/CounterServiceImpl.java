package com.sber.task.service;

import com.sber.task.dto.CounterDto;
import com.sber.task.mapper.CounterMapper;
import com.sber.task.model.Counter;
import com.sber.task.store.CounterStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {

    private final CounterStore counterStore;
    private final CounterMapper counterMapper;

    @Override
    public CounterDto create(String name) {
        Counter counter = counterStore.create(name);
        return counterMapper.toDto(counter);
    }

    @Override
    public CounterDto incrementByName(String name) {
        Counter counter = counterStore.getByName(name).orElseThrow();
        counter.increment();
        return counterMapper.toDto(counter);
    }

    @Override
    public int getCountByName(String name) {
        return counterStore.getByName(name)
                .map(Counter::getCount)
                .orElseThrow();
    }

    @Override
    public void deleteByName(String name) {
        counterStore.deleteByName(name);
    }

    @Override
    public int getCountersSum() {
        return counterStore.getAllCounters()
                .stream()
                .map(Counter::getCount)
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public Set<String> getUniqueNames() {
        return counterStore.getAllCounters()
                .stream()
                .map(Counter::getName)
                .collect(Collectors.toSet());
    }
}
