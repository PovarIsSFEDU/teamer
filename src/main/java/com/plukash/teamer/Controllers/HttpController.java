package com.plukash.teamer.Controllers;


import com.plukash.teamer.DAO.UserDAO;
import com.plukash.teamer.Entities.User;
import com.plukash.teamer.Utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class HttpController {
    @Autowired
    UserDAO userDAO;

    @GetMapping(value = "/")
    public String MainPage(Model model) {
        return "main";
    }


}
