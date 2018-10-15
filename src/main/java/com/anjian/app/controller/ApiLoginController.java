package com.anjian.app.controller;

import com.anjian.app.common.Result;
import com.anjian.app.common.UtilValidate;
import com.anjian.app.common.annotation.Login;
import com.anjian.app.entity.LoginForm;
import com.anjian.app.service.SysUserService;
import com.anjian.app.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@RestController
@RequestMapping("/api")
@SuppressWarnings("all")
@Api(value="用户登陆controller",tags={"用户操作接口"})
public class ApiLoginController {
    @Autowired
    private SysUserService userService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("apilogin")
    @ApiOperation("登录")
    public Result login(@RequestBody LoginForm loginForm) {

        //表单校验
        if(UtilValidate.isEmpty(loginForm.getUsername())||UtilValidate.isEmpty(loginForm.getUsername())){
            return Result.error("用户名或者密码不能为空");
        }

        //用户登录
        Map<String, Object> map = userService.login(loginForm.getUsername(),loginForm.getPassword());

        return Result.ok(map);
    }

    @Login
    @PostMapping("apilogout")
    @ApiOperation("退出")
    public Result logout(@ApiParam(name="userId",value="用户id",required=true) @RequestParam( value = "userId") Long userId) {
        tokenService.expireToken(userId);
        return Result.ok();
    }

    /*@PostMapping("noToken")
    @ApiOperation("noToken")
    public Result noToken() {
        return Result.ok().put("data", "访问成功了!!!!!");
    }*/

}
