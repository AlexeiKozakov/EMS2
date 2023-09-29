package com.ems;

import com.ems.domain.Event;
import com.ems.domain.Participant;
import com.ems.repository.EventRepo;
import com.ems.repository.ParticipantRepo;
import com.ems.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class EmsApplication implements CommandLineRunner {
    @Resource
    EventRepo eventRepo;
    @Resource
    ParticipantRepo participantRepo;

    public static void main(String[] args) {
        SpringApplication.run(EmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      generateEventsAndParticipants();
    }
    public void generateEventsAndParticipants() {
        List<Event> events = new ArrayList<>();

        // Generate 20 Event objects
        IntStream.range(0, 20).forEach(i -> {
            Event event = new Event();
            event.setName("Event " + i);
            event.setEventType("Type " + i);
            event.setPrice(100 + i);
            event.setDate(LocalDate.now().plusDays(i));
            event.setParticipantLimit(20); // Set the participant limit

            // Generate and add 20 Participant objects to each event
            List<Participant> participants = new ArrayList<>();
            IntStream.range(0, 20).forEach(j -> {
                Participant participant = new Participant();
                participant.setName("Participant " + j);
                participant.setPhone("123456789" + j);
                participant.setMail("participant" + j + "@example.com");
                participant.setCreated(LocalDateTime.now());
                participant.setUpdated(LocalDateTime.now());
                participantRepo.save(participant);

                participants.add(participant);

            });

            event.setParticipants(participants);
            events.add(event);
        });


        events.forEach(eventRepo::save);

    }
}

    //    @Override
//    public void run(String... args) throws Exception {
//
//        Event wedding = new Event(1, "wedding", "officialEvent", 5000, LocalDate.now(),10);
//        eventRepo.save(wedding);
//
//        Event birthday = new Event(2,"birthday","officialType",1000,LocalDate.now(),15);
//        eventRepo.save(birthday);
//
//    }

