package com.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ParticipantDto {

    private int Id;
    @NotBlank
    private String name;
    @Size(min = 10,max = 13)

    private String phone;
    @Email
    private String mail;
}
