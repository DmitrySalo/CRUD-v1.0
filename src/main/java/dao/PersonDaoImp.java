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
                new Person(++PEOPLE_COUNT, "Dmitry"),
                new Person(++PEOPLE_COUNT, "Vasily"),
                new Person(++PEOPLE_COUNT, "Elena"),
                new Person(++PEOPLE_COUNT, "Kotya"));
    }

    @Override
    public List<Person> index() {
        return personList;
    }

    @Override
    public Person show(int id) {
        return (personList.get(id - 1) != null) ? personList.get(id - 1) : null;
    }
}
