package io.hspx.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"", "/", "/index", "/index.html"})
@Controller
public class IndexController {
    public String getIndex() {
        return "index";
    }
}
