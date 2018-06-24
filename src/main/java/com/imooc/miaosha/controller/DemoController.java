package com.imooc.miaosha.controller;

import com.imooc.miaosha.Result.CodeMsg;
import com.imooc.miaosha.Result.Result;
import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class DemoController {
    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello,imooc");
    }

    @RequestMapping("/helloerror")
    @ResponseBody
    public Result<String> helloerror() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }
    
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","gxl");
        
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getByid(1);

        return Result.success(user);
    }
    
}
