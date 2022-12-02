package com.qualle.trip.web.service.impl;

import com.qualle.trip.web.client.DepartmentClient;
import com.qualle.trip.web.client.UserClient;
import com.qualle.trip.web.client.api.*;
import com.qualle.trip.web.dto.RegistrationDto;
import com.qualle.trip.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;
    private final DepartmentClient departmentClient;
    private final PasswordEncoder encoder;

    @Override
    public List<User> getUsers(int page, int size) {
        return new ArrayList<>(userClient.getUsers(page, size, "").getContent());
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userClient.getUsers(0, 20, "").getContent());
    }

    @Override
    public User getUser(Long id) {
        return userClient.getUser(id).getContent();
    }

    @Override
    public User getUserWithDepartment(Long id) {
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
    public User getUserByMemberId(Long memberId) {
        return userClient.getUserByMemberId(memberId).getContent();
    }

    @Override
    public void create(RegistrationDto registration) {

        User user = User.builder()
                .name(registration.getName())
                .surname(registration.getSurname())
                .patronymic(registration.getPatronymic())
                .birthday(LocalDate.parse(registration.getBirthday()))
                .gender(Gender.builder().id(registration.getGender().equals("M") ? 1 : 2).build()) // todo
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

    @Override
    public void update(RegistrationDto dto) {

        SimpleUser user = SimpleUser.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .patronymic(dto.getPatronymic())
                .birthday(LocalDate.parse(dto.getBirthday()))
                .gender(Gender.builder().id(dto.getGender().equals("M") ? 1L : 2L).build())
                .build();

        userClient.updateUser(dto.getId(), user);
    }

    @Override
    public void update(User user) {
        userClient.updateUser(user.getId(), user);
    }
}
