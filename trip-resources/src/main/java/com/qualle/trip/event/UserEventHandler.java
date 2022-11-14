package com.qualle.trip.event;

import com.qualle.trip.entity.User;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class UserEventHandler {

    @HandleBeforeCreate
    public void handlePersonSave(User user) {
        user.getCredentials().setUser(user);
    }
}