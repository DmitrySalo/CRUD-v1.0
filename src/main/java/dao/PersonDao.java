package dao;

import models.Person;

import java.util.List;

public interface PersonDao {

    List<Person> index();

    Person show(int id);

}
