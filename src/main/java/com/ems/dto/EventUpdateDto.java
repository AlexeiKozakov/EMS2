package com.ems.dto;
import com.ems.domain.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
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

    List<Participant> participants = new ArrayList<>();

    public List<Participant> getParticipant() {
        return participants;
    }
}

