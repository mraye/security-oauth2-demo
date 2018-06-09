package com.github.vspro.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/6/9.
 */


@Controller
@RequestMapping(value = "rest/api")
public class RestController {


    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> ping(){
        Map<String, Object> map = new HashMap<>();
        map.put("key","Hello Oauth2");
        return map;
    }




}
