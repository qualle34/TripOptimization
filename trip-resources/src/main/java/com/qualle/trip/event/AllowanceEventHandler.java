package com.qualle.trip.event;

import com.qualle.trip.entity.Allowance;
import com.qualle.trip.entity.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RepositoryEventHandler
public class AllowanceEventHandler {

    @HandleBeforeCreate
    public void handlePersonSave(Allowance allowance) {
        allowance.getCountry().setAllowances(List.of(allowance));
        allowance.getMemberAllowances().forEach(ma -> ma.setAllowance(allowance));
    }
}