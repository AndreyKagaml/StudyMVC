package ua.kahamlyk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kahamlyk.DAO.PeopleDAO;
import ua.kahamlyk.models.Person;

import java.sql.SQLException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PeopleDAO peopleDAO;

    @Autowired
    public AdminController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping()
    public String chooseAdmin(Model model, @ModelAttribute("person") Person person) throws SQLException {
        model.addAttribute("people", peopleDAO.index());
        return "adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId());
        return "redirect:/people";
    }

}
