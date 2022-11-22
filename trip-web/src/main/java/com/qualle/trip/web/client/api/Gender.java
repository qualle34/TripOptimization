package com.qualle.trip.web.client.api;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gender {

    private long id;
    private String value;
    private String fullValue;
}
