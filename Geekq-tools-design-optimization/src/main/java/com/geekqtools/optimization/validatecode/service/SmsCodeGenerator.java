/**
 * 
 */
package com.geekqtools.optimization.validatecode.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author 邱润泽 bullock
 *
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {


    @Override
    public ValidateCode generate(ServletWebRequest request) {
        ValidateCode code = new ValidateCode("sms",60);
        System.out.println("this is sms code check !");
        return code;
    }
}
