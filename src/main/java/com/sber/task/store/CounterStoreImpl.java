package com.sber.task.store;

import com.sber.task.model.Counter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CounterStoreImpl implements CounterStore {

    private final Map<String, Counter> counterMap = new HashMap<>();

    @Override
    public Counter create(String name) {
        if (counterMap.containsKey(name)) {
            throw new IllegalArgumentException("Counter with name " + name + " is existed");
        } else {
            Counter counter = new Counter(name);
            counterMap.put(name, counter);
            return counter;
        }
    }

    @Override
    public Optional<Counter> getByName(String counterName) {
        return Optional.ofNullable(counterMap.get(counterName));
    }

    @Override
    public void deleteByName(String counterName) {
        counterMap.remove(counterName);
    }

    @Override
    public Collection<Counter> getAllCounters() {
        return counterMap.values();
    }
}
