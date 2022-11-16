package com.qualle.trip.event;

import com.qualle.trip.entity.Allowance;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RepositoryEventHandler
public class AllowanceEventHandler {

    @HandleBeforeCreate
    public void handlePersonSave(Allowance allowance) {
        if (allowance.getCountry() != null) {
            allowance.getCountry().setAllowances(List.of(allowance));
        }
        if (allowance.getMemberAllowances() != null) {
            allowance.getMemberAllowances().forEach(ma -> ma.setAllowance(allowance));
        }
    }
}