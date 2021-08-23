package app.dao;

import app.models.Role;
import app.models.User;
import app.security.SecurityConfig;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAll() {
        return entityManager
                .createQuery("select distinct user from User user join fetch user.roles roles", User.class)
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
    public List<Role> showRoles() {
        return entityManager
                .createQuery("SELECT role FROM Role role", Role.class)
                .getResultList();
    }

    @Override
    public void createUser(User user) {
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(SecurityConfig.passwordEncoder().encode(user.getPassword()));
        entityManager.merge(user);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(showById(id));
    }


}