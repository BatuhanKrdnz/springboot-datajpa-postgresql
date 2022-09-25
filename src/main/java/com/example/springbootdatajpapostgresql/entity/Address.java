package com.example.springbootdatajpapostgresql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_address")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "address", length = 100)
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "activity")
    private boolean activity;

    @ManyToOne
    @JoinColumn(name = "person_address_id")
    private Person person;
    public enum AddressType{
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }

}
