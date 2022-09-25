package com.example.springbootdatajpapostgresql.service.impl;

import com.example.springbootdatajpapostgresql.dto.PersonDto;
import com.example.springbootdatajpapostgresql.entity.Address;
import com.example.springbootdatajpapostgresql.entity.Person;
import com.example.springbootdatajpapostgresql.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.PersonRepository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    /*
    @Component
    @Service
    @RestController
    @Repository
    @Controller
    */

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb = this.personRepository.save(person);

        List<Address> addressList = new ArrayList<>();

        personDto.getAddresses().forEach((item) -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActivity(true);
            address.setPerson(personDb);
            addressList.add(address);

        });

        addressRepository.saveAll(addressList);
        personDto.setId(personDto.getId());
        return personDto;
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> people = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        people.forEach(it-> {
            PersonDto personDto = new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setSurname(it.getSurname());
            personDto.setAddresses(it.getAddresses()
                    .stream().map(Address::getAddress).collect(Collectors.toList()));
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}

