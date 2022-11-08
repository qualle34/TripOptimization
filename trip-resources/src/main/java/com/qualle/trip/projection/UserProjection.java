package com.qualle.trip.projection;

import com.qualle.trip.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user", types = { User.class })
public interface UserProjection {


}
