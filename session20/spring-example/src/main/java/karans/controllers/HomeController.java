package karans.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Enumeration;


@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model, Principal principal, HttpServletRequest request) {
        User u = (User)((Authentication)principal).getPrincipal();
        HttpSession session = request.getSession();
        System.out.println(SecurityContextHolder.getContext().getClass());
        Enumeration<String> attribs = session.getAttributeNames();
        String attrib = attribs.nextElement();
        System.out.println("---->");
        while(attribs.hasMoreElements()) {
            System.out.println(attrib + " -> " + session.getAttribute(attrib));
            attrib = attribs.nextElement();
        }
        System.out.println("<-----");
        model.addAttribute("u", u);
        return "home";
    }
}
