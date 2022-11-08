package com.qualle.trip.web.client.api;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;
    private User user;
    private Trip trip;
    private Set<MemberAllowance> memberAllowances;
    private Set<Ticket> tickets;
    private String role;
}
