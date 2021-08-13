package service;

import models.Person;

import java.util.List;

public interface PersonService {

    List<Person> index();

    Person show(int id);
}
