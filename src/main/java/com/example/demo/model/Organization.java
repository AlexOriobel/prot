package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organization {
    @Id
    @GeneratedValue(generator = "document-uuid2")
    @GenericGenerator(name = "document-uuid2", strategy = "uuid2")
    private String id;

    @Column
    private String name;

    @Column
    private List<String> phone;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List <Address> address;
}
