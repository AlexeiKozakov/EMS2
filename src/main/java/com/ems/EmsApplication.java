package com.ems;

import com.ems.domain.Event;
import com.ems.repository.EventRepo;
import com.ems.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;

@SpringBootApplication
public class EmsApplication implements CommandLineRunner {
    @Resource
    EventRepo eventRepo;

    public static void main(String[] args) {
        SpringApplication.run(EmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

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
}
