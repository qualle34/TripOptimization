package com.qualle.trip.resurce;

import com.qualle.trip.entity.Credentials;
import com.qualle.trip.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface UserResource extends PagingAndSortingRepository<User, Long> {

    @RestResource(path = "findUserByLogin")
    @Query("SELECT u FROM User u JOIN FETCH u.credentials c WHERE c.login LIKE :login")
    User findUserByLogin(String login);

}
