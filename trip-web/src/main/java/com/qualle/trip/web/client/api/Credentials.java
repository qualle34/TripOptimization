package com.qualle.trip.web.client.api;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {

    private long id;
    private String login;
    private String password;
    private User user;
}
