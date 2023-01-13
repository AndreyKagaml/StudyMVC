package ua.kahamlyk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kahamlyk.DAO.PeopleDAO;

@Controller
@RequestMapping("/test-batch-update")
public class BatchController {

    private final PeopleDAO peopleDAO;

    @Autowired
    public BatchController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping()
    public String index(){
        return "batch/index";
    }

    @GetMapping("/without")
    public String withoutBatch(){
        peopleDAO.updateWithoutBatch();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String withBatch(){
        peopleDAO.updateWithBatch();
        return "redirect:/people";
    }

}
