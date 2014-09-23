package karans.controllers;

import karans.dummy.HelloEchoer;
import karans.facade.Facade;
import karans.facade.User;
import karans.forms.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private Facade facade;

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "signup-form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object processSignup(Model model, @Valid SignupForm signupForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("signupForm", signupForm);
            return "signup-form";
        }
        User user = new User();
        user.setName(signupForm.getName());
        user.setPassword(signupForm.getPassword());
        user.setUsername(signupForm.getUsername());
        facade.addUser(user);
        return new RedirectView("/login");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
