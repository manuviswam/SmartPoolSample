package com.tw.controller;

import com.tw.db.UserDAO;
import com.tw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserDAO dao;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUser(HttpServletResponse response,@ModelAttribute("name") String name) throws IOException{

        List<User> users = dao.getUserByName(name);
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("users",users);
        return modelAndView;

    }
}
