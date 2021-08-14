package dao;

import models.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonDaoImp implements PersonDao {
    private static int PEOPLE_COUNT;
    private final List<Person> personList;
    private static PersonDaoImp personDaoImp;

    private PersonDaoImp() {
    }

    public static PersonDaoImp getPersonDaoImp() {
        return (personDaoImp == null) ? new PersonDaoImp() : personDaoImp;
    }

    {
        personList = new ArrayList<>();
        Collections.addAll(personList,
                new Person(++PEOPLE_COUNT, "Dmitry", 30, "morozavros@lol.ru"),
                new Person(++PEOPLE_COUNT, "Vasily", 59, "amk.61@lol.ru"),
                new Person(++PEOPLE_COUNT, "Elena", 49, "aef@lol.ru"),
                new Person(++PEOPLE_COUNT, "Kotya", 8, "kot@lol.ru"));
    }

    @Override
    public List<Person> index() {
        return personList;
    }

    @Override
    public Person show(int id) {
        return personList
                .stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        personList.add(person);
    }

    @Override
    public void update(int id, Person person) {
        Person updPerson = show(id);
        updPerson.setName(person.getName());
    }

    @Override
    public void delete(int id) {
        personList.removeIf(person -> person.getId() == id);
    }
}
