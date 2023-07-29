package com.ems.dto;

import com.ems.domain.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventUpdateDto {
    private int id;
    private String name;
    private String eventType;
    private int price;
    private String date;
    private int participantLimit;
    private List<Participant> participants = new ArrayList<>();
}

