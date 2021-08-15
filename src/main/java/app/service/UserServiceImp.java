package app.service;

import app.dao.UserDao;
import app.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> showAll() {
        return userDao.showAll();
    }

    @Override
    public User showById(int id) {
        return userDao.showById(id);
    }

    @Override
    public void createPerson(User user) {
        userDao.createUser(user);
    }

    @Override
    public void updatePerson(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }
}