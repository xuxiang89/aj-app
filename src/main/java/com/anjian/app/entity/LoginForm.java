package com.anjian.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;


@ApiModel(value = "登录表单")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginForm {
    @ApiModelProperty(value = "用户名")
    @NotBlank(message="用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotBlank(message="密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginForm() {
    }
}
