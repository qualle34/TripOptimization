package com.qualle.trip.web.client.api;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Allowance {

    private Long id;
    private double value;
    private Country country;
    private List<MemberAllowance> memberAllowances;

}
