package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passport")
@Api(value = "注册登陆",tags = {"用于用户注册登陆的相关接口"})
public class PassportController {
    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    @ApiOperation(value = "判断用户是否存在",notes = "判断用户是否存在备注",httpMethod = "GET")
    public IMOOCJSONResult usernameIsExist(@RequestParam(value = "username",defaultValue = "aaa")String username) {
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }
        boolean exist = userService.queryUsernameIsExist(username);
        if (exist) {
            return IMOOCJSONResult.errorMsg("用户名不能重复");
        }
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/regist")
    @ApiOperation(value = "用户注册",notes = "用户注册备注",httpMethod = "POST")
    public IMOOCJSONResult regist(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        if (StringUtils.isBlank(username ) ||
            StringUtils.isBlank(password) ||
            StringUtils.isBlank(confirmPassword)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        boolean b = userService.queryUsernameIsExist(username);
        if (b) {
            return IMOOCJSONResult.errorMsg("用户名已存在");
        }

        if (password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码位数不能少于6位");
        }

        if (!password.equals(confirmPassword)) {
            return IMOOCJSONResult.errorMsg("两次密码不一致");
        }

        Users user = userService.createUser(userBO);

        return IMOOCJSONResult.ok(user);
    }
}