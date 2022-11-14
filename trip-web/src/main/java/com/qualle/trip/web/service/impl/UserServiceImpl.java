package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.DepartmentClient;
import com.qualle.trip.web.client.UserClient;
import com.qualle.trip.web.client.api.Credentials;
import com.qualle.trip.web.client.api.Department;
import com.qualle.trip.web.client.api.Role;
import com.qualle.trip.web.client.api.User;
import com.qualle.trip.web.dto.RegistrationDto;
import com.qualle.trip.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;
    private final DepartmentClient departmentClient;
    private final PasswordEncoder encoder;

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userClient.getUsers(0, 30, "").getContent());
    }

    @Override
    public User getUser(Long id) {
        User user =  userClient.getUser(id).getContent();

        Department department = departmentClient.getDepartmentByUserId(user.getId()).getContent();

        user.setDepartment(department);

        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        return userClient.getUserByLogin(login).getContent();
    }

    @Override
    public void create(RegistrationDto registration) {

        User user = User.builder()
                .name(registration.getName())
                .surname(registration.getSurname())
                .patronymic(registration.getPatronymic())
                .birthday(registration.getBirthday())
                .gender(registration.getGender())
                .credentials(Credentials.builder()
                        .login(registration.getLogin())
                        .password(encoder.encode(registration.getPassword()))
                        .build())
                .role(Role.builder()
                        .id(2L)
                        .value("USER")
                        .build())
                .build();

        userClient.saveUser(user);
    }
}
