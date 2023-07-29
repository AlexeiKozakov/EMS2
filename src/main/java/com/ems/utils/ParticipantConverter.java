package com.ems.utils;

import com.ems.domain.Participant;
import com.ems.dto.ParticipantAddDto;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantConverter {
    public static List<ParticipantAddDto> convertToParticipantAddDtoList(List<Participant> participants) {
        return participants.stream()
                .map(ParticipantConverter::convertToParticipantAddDto)
                .collect(Collectors.toList());
    }

    public static ParticipantAddDto convertToParticipantAddDto(Participant participant) {
        return ParticipantAddDto.builder()
                .name(participant.getName())
                .mail(participant.getMail())
                .phone(participant.getPhone())
                // Set other properties as needed
                .build();

}
}
