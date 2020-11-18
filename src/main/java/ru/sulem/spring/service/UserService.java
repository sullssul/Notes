package ru.sulem.spring.service;

import ru.sulem.spring.models.User;

import java.util.List;

public interface UserService {

        List<User> allUsers();
        void addUser(User user);
        void deleteUser(User user);
        void editUser(User user);
        User getUserById(int id);


}
