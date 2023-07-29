package com.ems.controllers;

import com.ems.dto.UserSignUpDto;
import lombok.Generated;
import lombok.Value;
import org.hibernate.boot.jaxb.spi.Binding;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping(value = "/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("signup");
        modelAndView.addObject("UserSignUpDto", new UserSignUpDto());
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewAdmin(@Valid @ModelAttribute("UserSignUpDto") UserSignUpDto userSignUpDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("signup");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            try {
            } catch (Exception exception) {
                bindingResult.rejectValue("email", "error.adminSignUpFormCommand", exception.getMessage());
                return modelAndView;
            }
        }
        return new ModelAndView("login");
    }
}
