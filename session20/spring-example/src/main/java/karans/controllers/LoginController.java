package karans.controllers;

import karans.facade.Facade;
import karans.forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private Facade facade;
    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "login-form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object post(Model model, @Valid LoginForm loginForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("loginForm", loginForm);
            return "login-form";
        }

        try {
            Authentication result = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (Exception e) {
            e.printStackTrace();
                return "login-form";
        }

        return new RedirectView("/home");
    }
}
