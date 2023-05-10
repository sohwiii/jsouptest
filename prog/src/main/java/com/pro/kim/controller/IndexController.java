package com.pro.kim.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
 
    @RequestMapping("/")
    public ModelAndView Index(ModelAndView mav) {
        
        // /WEB-INF/jsp/index.jsp
        mav.setViewName("index");//view page name
        return mav;
    }
}
