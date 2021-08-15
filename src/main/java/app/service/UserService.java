package app.service;

import app.models.User;

import java.util.List;

public interface UserService {

    List<User> showAll();

    User showById(int id);

    void createPerson(User user);

    void updatePerson(User user);

    void deleteById(int id);
}