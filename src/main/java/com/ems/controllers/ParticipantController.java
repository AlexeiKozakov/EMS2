package com.ems.controllers;

import com.ems.domain.Participant;
import com.ems.dto.ParticipantAddDto;
import com.ems.services.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;


}
