package com.imooc.miaosha.controller;

import com.imooc.miaosha.Result.CodeMsg;
import com.imooc.miaosha.Result.Result;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.util.ValidatorUtil;
import com.imooc.miaosha.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    private static Logger logger= LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    RedisService redisService;
    @Autowired
    MiaoshaUserService userService;
    
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }
    
    @RequestMapping("/do_login")
    @ResponseBody
    public Result doLogin(LoginVo loginVo){
        logger.info(loginVo.toString());
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        if (StringUtils.isEmpty(mobile)){
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if (StringUtils.isEmpty(password)){
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if (!ValidatorUtil.isMobile(mobile)){
            return Result.error(CodeMsg.MOBILE_ERROR);
        }
        CodeMsg codeMsg = userService.login(loginVo);
        if (codeMsg.getCode()==0){
            return Result.success(true);
        }else {
            return Result.error(codeMsg);
        }
    }
    
    
}
