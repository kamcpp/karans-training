package karans.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping(method = RequestMethod.GET)
    public Object get() {
        return new RedirectView("/login");
    }
}
