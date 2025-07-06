package com.johar.mybatis.mybatistest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/12/13 23:49
 * @Since: 1.0.0
 */
@RequestMapping("/mvc")
@Controller
public class HelloController {



    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("title", "World");
        return "/hello/hello";
    }

    @GetMapping("/index")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView("hello/hello");
        // 添加 title 属性到 Model
        modelAndView.addObject("title", "Freemarker");
        return modelAndView;
    }
}