package com.sber.task.mapper;

import com.sber.task.dto.CounterDto;
import com.sber.task.model.Counter;
import org.mapstruct.Mapper;

@Mapper
public interface CounterMapper {

    Counter fromDto(CounterDto counterDto);

    CounterDto toDto(Counter counter);
}
