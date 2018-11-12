package com.messageprocessor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @implNote : Handles all the views for the application
 */
@Controller
@RequestMapping("/")
public class ViewController {

    /**
     * Context view handler
     * @return - Index view name
     */
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }


}
