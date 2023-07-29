package com.ems.services;

import com.ems.domain.Participant;
import com.ems.dto.ParticipantAddDto;
import com.ems.dto.ParticipantDto;
import com.ems.repository.ParticipantRepo;
import com.ems.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ParticipantServiceImpl implements ParticipantService {

     private final Mapper mapper;
     private final ParticipantRepo participantRepo;
    @Override
    public ParticipantDto addParticipant(ParticipantAddDto participantAddDto) {
        Participant participant = mapper.convertToEntity(participantAddDto);
        Participant savedParticipant = participantRepo.save(participant);
        return mapper.convertToParticipantResponseDto(savedParticipant);
    }
}
