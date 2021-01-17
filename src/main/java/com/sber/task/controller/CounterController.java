package com.sber.task.controller;

import com.sber.task.dto.CounterDto;
import com.sber.task.service.CounterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/counters")
@RequiredArgsConstructor
public class CounterController {

    private final CounterService counterService;

    @ApiOperation(value = "Create counter by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Counter created"),
            @ApiResponse(code = 500, message = "Counter with name '{counter-name}' is existed")})
    @PostMapping("/name/{counter-name}")
    public CounterDto create(@ApiParam(value = "Counter name", required = true) @PathVariable("counter-name") String name) {
        return counterService.create(name);
    }

    @ApiOperation(value = "Increment counter by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Counter incremented"),
            @ApiResponse(code = 500, message = "No value present")})
    @PutMapping("/name/{counter-name}/increment")
    public CounterDto increment(@ApiParam(value = "Counter name", required = true) @PathVariable("counter-name") String name) {
        return counterService.incrementByName(name);
    }

    @ApiOperation(value = "Get count by counter name", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Count returned"),
            @ApiResponse(code = 500, message = "No value present")})
    @GetMapping("/name/{counter-name}")
    public int getCountByName(@ApiParam(value = "Counter name", required = true) @PathVariable("counter-name") String name) {
        return counterService.getCountByName(name);
    }

    @ApiOperation(value = "Delete counter by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Counter deleted")})
    @DeleteMapping("/name/{counter-name}")
    public void delete(@ApiParam(value = "Counter name", required = true) @PathVariable("counter-name") String name) {
        counterService.deleteByName(name);
    }

    @ApiOperation(value = "Get counter sum", response = Integer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Counter sum returned")})
    @GetMapping("/sum")
    public Integer getCountersSum() {
        return counterService.getCountersSum();
    }

    @ApiOperation(value = "Get counter names")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Counter names returned")})
    @GetMapping("/unique-names")
    public Set<String> getUniqueNames() {
        return counterService.getUniqueNames();
    }
}
