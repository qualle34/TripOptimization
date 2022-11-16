package com.qualle.trip.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private Long id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private String birthday;
    private String gender;
    private String email;
    private String phone;
    private String password;
}
