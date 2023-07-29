package com.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder

public class Event {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 @Column(nullable = false)
 private String name;
 @Column(nullable = false)
 private String eventType;
 @Column(nullable = false)
 private int price;
 @Column(nullable = false)
 private LocalDate date;
 @Column(nullable = false)
 private int participantLimit;
 @OneToMany
 private List<Participant> participants = new ArrayList<>();


}

//TODO 1 - Update Event DTO,add List<participant> to Event Dto.
//TODO 2 - Update mapper,add participant list to mapper.
