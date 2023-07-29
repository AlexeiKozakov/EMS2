package com.ems.dto;

import lombok.Getter;
import lombok.Setter;







import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
@Getter

@NoArgsConstructor
public class UserSignUpDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 13)
    private String phoneNumber;
    @NotBlank
    @Size(min = 5)
    private String password;
    private Set<UserRoleDto> roles;


}
