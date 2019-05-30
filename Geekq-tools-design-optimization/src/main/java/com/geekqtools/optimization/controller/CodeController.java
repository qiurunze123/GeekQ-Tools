package com.geekqtools.optimization.controller;

import com.geekqtools.optimization.validatecode.service.ValidateCodeProcessorHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 邱润泽 bullock
 *
 * /code/image   /code/sms
 *
 *  俩种合并 都是发送验证码 根据 bean 名称寻找 相应的bean
 *  再将公共方法抽象 分别子类实现 根据
 *  每个bean的不同来寻找相应的generator
 *
 *  <C extends T> 是限制 Class<C>里的C的 也就是C需要是T的实现类或者子类
 *
 */
@RestController
public class CodeController {


    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     *
     * @param request
     * @param response
     * @param type
     * @throws Exception
     */
    @GetMapping("code" + "/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type)
            throws Exception {

        validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }
}
