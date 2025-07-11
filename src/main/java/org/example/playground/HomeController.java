package org.example.playground;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

@Controller
public class HomeController {
    @RequestMapping("")
    public String index() {
        return "index.html";
    }


    public String getViewName() {
        return "index";
    }
}
