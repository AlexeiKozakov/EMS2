package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data

@AllArgsConstructor
public class EventFullResponseDto {

    private int id;
    private String name;
    private String eventType;
    private int price;
    private String date;
    private int participantLimit;


}
