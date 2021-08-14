package service;

import dao.PersonDaoImp;
import models.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImp implements PersonService {

    private final PersonDaoImp personDaoImp = PersonDaoImp.getPersonDaoImp();

    @Override
    public List<Person> index() {
        return personDaoImp.index();
    }

    @Override
    public Person show(int id) {
        return personDaoImp.show(id);
    }

    @Override
    public void save(Person person) {
        personDaoImp.save(person);
    }
}
