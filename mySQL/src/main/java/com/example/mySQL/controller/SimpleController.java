package com.example.mySQL.controller;


import com.example.mySQL.domain.Person;
import com.example.mySQL.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author lyner
 */
@Controller
public class SimpleController {

    @Autowired
    private PersonService personService;

    @GetMapping("/website")
    public String website(Model model, @ModelAttribute Person person) {
        model.addAttribute("persons", personService.getAllPersons());
        model.addAttribute("person", new Person());
        return "view";
    }

    @PostMapping
    public String createPerson(@ModelAttribute Person person, Model model) {
        personService.createPerson(person);
        model.addAttribute("persons", personService.getAllPersons());
        return "result";
    }

    @PostMapping("/userread")
    public String readPerson(@ModelAttribute Person person, Model model){
        model.addAttribute("persons", personService.getPersonById(person.getId()));
        return "result";
    }

    @PostMapping("/userupdate")
    public String updatePerson(@ModelAttribute Person person, Model model){
        personService.updatePerson(person.getId(), person);
        model.addAttribute("persons", personService.getAllPersons());
        return "result";
    }

    @PostMapping("/userdelete")
    public String deletePerson(@ModelAttribute Person person, Model model){
        personService.deletePerson(person.getId());
        model.addAttribute("persons", personService.getAllPersons());
        return "result";
    }

}
