package com.qualle.trip.web.client.api;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    private Long id;
    private String serial;
    private Long number;
    private Long personalNumber;
}
