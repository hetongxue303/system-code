package com.hetongxue.system.controller;

import com.hetongxue.lang.Const;
import com.hetongxue.response.Result;
import com.hetongxue.utils.CaptchaUtil;
import com.hetongxue.utils.HttpUtil;
import com.wf.captcha.base.Captcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 安全模块
 * @ClassNmae: AuthController
 * @Author: 何同学
 * @DateTime: 2022-06-08 16:58
 */
@RestController
public class AuthController {

    /**
     * 获取验证码
     **/
    @GetMapping("/getVerify")
    public Result getVerify() {
        Captcha captcha = CaptchaUtil.generateCaptcha();
        HttpUtil.getSession().setAttribute(Const.CAPTCHA_KEY, captcha.text());
        // 存入redis  这里先使用session进行验证 后期在更换
        return Result.Success(captcha.toBase64()).setMessage(captcha.text());
    }

}