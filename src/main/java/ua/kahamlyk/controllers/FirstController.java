package ua.kahamlyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model){
        double result;

        switch (action){
            case "multiplication":
                result = a*b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double)b;
                break;
            default:
                result = 0;
        }

        model.addAttribute("result", result);
        return "first/calculator";
    }


    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model){
        model.addAttribute("massage", "Hello, " + name + " " + surname);
      //  HttpServletRequest request
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");

   //     System.out.println("Hello, " + name + " " + surname);


        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodBye(){
        return "first/goodbye";
    }
}
