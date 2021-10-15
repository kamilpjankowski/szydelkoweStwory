package pl.szydelkowestwory.szydelkoweStwory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Config {

    @GetMapping("/index")
    public String index()
    {
        return "index";
    }
}
