package com.example.hormone.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginParam {

    private String uid;

    private String password;

    @ApiModelProperty(value = "验证码")
    private String captcha;

    @ApiModelProperty(value = "验证码key")
    private String checkKey;
}
