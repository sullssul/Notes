package ru.sulem.spring.dao;

import ru.sulem.spring.models.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getUserById(int id);
    //int userCount();


}
