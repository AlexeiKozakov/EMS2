package com.ems.dto;

import com.ems.domain.Participant;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


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


  //  public EventAddDto(String test, String some, int price, String date, int i) {
   // }
}
