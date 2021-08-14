package controllers;

import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.PersonService;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonService service;

    @Autowired
    public PeopleController(PersonService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", service.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", service.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        service.save(person);
        return "redirect:/people";
    }

}
