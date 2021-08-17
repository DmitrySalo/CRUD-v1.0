package app.dao;

import app.models.Role;
import app.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<String, User> userMap = Collections.singletonMap("test",
            new User(1, "test", "test", Collections.singleton(new Role(1, "ROLE_USER"))));

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
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(showById(id));
    }

    @Override
    public User getUserByName(String name) {
        if (!userMap.containsKey(name)) {
            return null;
        }

        return userMap.get(name);
    }
}