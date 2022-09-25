package com.example.springbootdatajpapostgresql.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Person {

    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname", length = 100)
    private String surname;

    @OneToMany
    @JoinColumn(name = "person_address_id")
    private List<Address> addresses;

}
