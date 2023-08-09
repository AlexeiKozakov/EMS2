package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ParticipantAddDto {

    private String name;
    @Min(value = 10)
    @Size(min = 10,max = 13)
    private String phone;
    @Email(message = "Invalid email format")
    private String mail;
    private int eventId;
}
