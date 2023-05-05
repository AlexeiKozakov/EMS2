package com.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(length = 15)
    private String name;
}
