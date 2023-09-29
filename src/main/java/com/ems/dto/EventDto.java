package com.ems.dto;

import com.ems.domain.Participant;
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

    public double calculateEventTime() {
        double totalPerformingTime = participants.stream()
                .mapToDouble(ParticipantDto::getPerformingTime)
                .sum();

        return totalPerformingTime * 1.2;
    }

}
