package com.qualle.trip.web.client.api;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
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
    private List<MemberAllowance> memberAllowances;
    private List<Ticket> tickets;
    private String role;

    public void addMemberAllowance(MemberAllowance ma){
        if(memberAllowances == null){
            memberAllowances = new ArrayList<>();
        }
        memberAllowances.add(ma);
    }
}
