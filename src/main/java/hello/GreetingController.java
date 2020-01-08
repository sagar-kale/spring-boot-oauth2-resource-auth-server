package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping(value = "/greeting")
    public String greeting(User user, Model model) {
        model.addAttribute("user", user);
        return "greeting";
    }

}
