package com.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(unique = true)
    private String name;
    @Column(unique = true,length = 13)
    private String phoneNumber;
    @Column(length = 25)
    private String password;
    @OneToMany
    private List<User> users = new ArrayList<>();

}
