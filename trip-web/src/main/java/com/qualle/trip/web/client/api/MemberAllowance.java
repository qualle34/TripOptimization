package com.qualle.trip.web.client.api;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberAllowance implements Serializable {

    private Allowance allowance;
    private Member member;
    private int days;
}
