package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private int id;
    private String name;
    private String eventType;
    private int price;
    private String date;
    private int participantLimit;
    List<ParticipantDto> participants = new ArrayList<>();

}
