package app.dao;

import app.models.User;
import app.security.SecurityConfig;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAll() {
        return entityManager
                .createQuery("select user from User user", User.class)
                .getResultList();
    }

    @Override
    public User showById(int id) {
        return Optional.ofNullable(entityManager.find(User.class, id)).orElse(null);
    }

    @Override
    public User getUserByName(String login) {
        return showAll()
                .stream()
                .filter(user -> user.getUsername().equals(login))
                .findAny()
                .orElse(null);
    }

    @Override
    public void createUser(User user) {
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("saved user: " + user.getName());
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        entityManager.merge(user);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(showById(id));
    }
}