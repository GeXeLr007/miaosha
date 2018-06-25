package com.imooc.miaosha.service;

import com.imooc.miaosha.Result.CodeMsg;
import com.imooc.miaosha.dao.MiaoshaUserDao;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.vo.LoginVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class MiaoshaUserService {
    @Autowired
    MiaoshaUserDao userDao;

    public MiaoshaUser getById(long id) {
        return userDao.getById(id);
    }

    public CodeMsg login(LoginVo loginVo) {
        if (loginVo == null) {
            return CodeMsg.SERVER_ERROR;
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if (user == null) {
            return CodeMsg.MOBILE_NOT_EXIST;
        }
        String userPassword = user.getPassword();
        String saltDB = user.getSalt();
        String dbPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if (!dbPass.equals(userPassword)) {
            return CodeMsg.PASSWORD_ERROR;
        } else {
            return CodeMsg.SUCCESS;
        }
    }

}
