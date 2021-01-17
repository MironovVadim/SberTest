package com.sber.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Counter Dto")
public class CounterDto {
    @ApiModelProperty(value = "Counter name")
    private String name;
    @ApiModelProperty(value = "Count")
    private int count;
}
