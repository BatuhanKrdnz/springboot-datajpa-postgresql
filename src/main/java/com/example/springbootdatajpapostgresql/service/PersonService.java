package com.example.springbootdatajpapostgresql.service;

import com.example.springbootdatajpapostgresql.dto.PersonDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface PersonService {
    PersonDto save(PersonDto personDto);

    void delete(Long id);

    List<PersonDto> getAll();

    Page<PersonDto> getAll(Pageable pageable);

}
