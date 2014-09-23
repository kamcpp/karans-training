package karans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

@Controller
@RequestMapping("/hellow")
public class HelloWorldController {

    @RequestMapping(method= RequestMethod.GET)
    public String action() {
        return "hello-page";
    }

    @RequestMapping(value = "/do", method = RequestMethod.GET)
    public ModelAndView anotherAction(String name) {
        ModelAndView model = new ModelAndView("hello-page-2");
        model.addObject("myName", name);
        return model;
    }
}
