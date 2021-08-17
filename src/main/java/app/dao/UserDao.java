package app.dao;

import app.models.User;

import java.util.List;

public interface UserDao {

    List<User> showAll();

    User showById(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteById(int id);

    User getUserByName(String name);
}