package com.example.springbootdatajpapostgresql.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PersonDto {
    private long id;

    @NotNull
    private String name;
    private String surname;
    private List<String> addresses;
}
