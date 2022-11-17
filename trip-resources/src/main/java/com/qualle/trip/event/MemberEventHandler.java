package com.qualle.trip.event;

import com.qualle.trip.entity.Member;
import com.qualle.trip.entity.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RepositoryEventHandler
public class MemberEventHandler {

    @HandleBeforeCreate
    public void handlePersonSave(Member member) {
        member.getTrip().setMembers(List.of(member));
        member.getUser().setMembers(List.of(member));
        member.getMemberAllowances().forEach(ma -> ma.setMember(member));
    }
}