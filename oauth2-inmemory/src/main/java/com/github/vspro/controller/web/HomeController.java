package com.github.vspro.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created  on 2018/6/9.
 */

@Controller
public class HomeController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}
