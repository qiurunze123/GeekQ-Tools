package com.geekqtools.optimization.validatecode.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @author 邱润泽 bullock
 *
 * C extends ValidateCode C需要是 ValidateCode 的实现类或者子类
 */
public abstract  class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor{

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        send(request, validateCode);
    }

    @Override
    public void validate(ServletWebRequest servletWebRequest) {

        System.out.println("检验验证码 ！");
    }

    /**
     * 生成校验码
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getValidateCodeType(request).toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            System.out.println(("验证码生成器" + generatorName + "不存在"));
        }
        return (C) validateCodeGenerator.generate(request);
    }


    /**
     * 根据请求的url获取校验码的类型
     *
     * @param request
     * @return
     */
    private String getValidateCodeType(ServletWebRequest request) {
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
        return type.toLowerCase();
    }
    /**
     * 发送校验码，由子类实现
     *
     * @param request
     * @param validateCode
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;
}
