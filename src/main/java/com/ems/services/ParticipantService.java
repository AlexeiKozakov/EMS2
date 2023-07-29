package com.ems.services;

import com.ems.dto.ParticipantAddDto;
import com.ems.dto.ParticipantDto;

public interface ParticipantService {

    public ParticipantDto addParticipant(ParticipantAddDto participantAddDto);
}
