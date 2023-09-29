package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Duration;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ParticipantAddDto {
    @NotBlank(message = "Invalid name")

    private String name;
    @Min(value = 10)
    @Size(min = 10,max = 13,message = "fucking phone number")
    private String phone;
    @Email(message = "Invalid email format")
    private String mail;
    private int eventId;
     private double performingTime;
}
