package com.ems.utils;

import com.ems.domain.Event;
import com.ems.domain.Participant;
import com.ems.domain.User;
import com.ems.dto.*;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class Mapper {

    public User convertToEntity(UserSignUpDto dto) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .build();
    }
    public List<Participant> convertToEntityList(List<ParticipantAddDto> dtoList) {
        return dtoList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }



    public Event convertToEntity(EventAddDto dto) {


        return Event.builder()
                .name(dto.getName())
                .eventType(dto.getEventType())
                .price(dto.getPrice())
                .date(LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .participantLimit(dto.getParticipantLimit())
                .participants(new ArrayList<>())
                .build();

    }

    public EventAddDto convertToEventAddDto(Event entity) {

        return EventAddDto.builder()
                .name(entity.getName())
                .eventType(entity.getEventType())
                .price(entity.getPrice())
                .date(entity.getDate().toString())

                .build();

    }
//    public List<ParticipantDto> convertToParticipantDtoList(List<Participant> participants) {
//        return participants.stream()
//                .map(this::convertToEventResponseDto)
//                .collect(Collectors.toList());
//    }

    public EventDto convertToEventResponseDto(Event entity) {
        return EventDto.builder()
                .name(entity.getName())
                .eventType(entity.getEventType())
                .price(entity.getPrice())
                .date(entity.getDate().toString())
                .id(entity.getId())
                .participantLimit(entity.getParticipantLimit())
                .participants(
                        entity.getParticipants()
                        .stream()
                        .map(p->convertToParticipantResponseDto(p))
                        .collect(Collectors.toList()))
                .build();
    }

    public List<EventDto> convertToListEventResponseDto(List<Event> events) {
        return events.stream().map((e) -> convertToEventResponseDto(e)).collect(Collectors.toList());
    }

    public Event convertfromEventUpdateDtoToEntity(EventUpdateDto dto) {
        List<Participant> participants = dto.getParticipants();
        return Event.builder()
                .id(dto.getId())
                .name(dto.getName())
                .eventType(dto.getEventType())
                .price(dto.getPrice())
                .date(LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .participants(participants)
                .participantLimit(dto.getParticipantLimit())
                .build();
    }
    public ParticipantDto convertToParticipantResponseDto(Participant entity) {
        return ParticipantDto.builder()
                .Id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .mail(entity.getMail())
                .build();
    }
    public Participant convertToEntity(ParticipantAddDto dto) {


        return Participant.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .mail(dto.getMail())

                .build();

    }
    public ParticipantAddDto convertToParticipantResponseAddDto(Participant entity) {


        return ParticipantAddDto.builder()
                .eventId(entity.getId())
                .mail(entity.getMail())
                .name(entity.getName())
                .phone(entity.getPhone())
                .build();
    }

}