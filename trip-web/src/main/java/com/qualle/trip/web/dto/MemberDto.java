package com.qualle.trip.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private long employeeId;
    private long tripId;
    private long countryId;
    private int days;
    private long expenses;
    private String role;
}
