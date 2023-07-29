package com.ems.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventAddDto {
    private String name;
    private String eventType;
    private int price;
    private String date;
    private int participantLimit;
}
