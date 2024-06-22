package guru.springframework.yudi.spring6webappyudi.controller;

import guru.springframework.yudi.spring6webappyudi.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(path = "/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
