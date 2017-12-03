package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {
    
    private final SpitterRepository spitterRepository;
    
    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        super();
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter) {
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

}
