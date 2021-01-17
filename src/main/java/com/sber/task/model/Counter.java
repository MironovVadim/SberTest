package com.sber.task.model;

import lombok.Data;

@Data
public class Counter {
    private String name;
    private int count = 0;

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        count++;
    }
}
