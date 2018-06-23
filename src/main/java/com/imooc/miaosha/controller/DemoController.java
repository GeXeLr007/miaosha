package com.imooc.miaosha.controller;

import com.imooc.miaosha.Result.CodeMsg;
import com.imooc.miaosha.Result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class DemoController {

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

}
