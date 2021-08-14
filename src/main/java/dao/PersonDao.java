package dao;

import models.Person;

import java.util.List;

public interface PersonDao {

    List<Person> index();

    Person show(int id);

    void save(Person person);

    void update(int id, Person person);

    void delete(int id);
}