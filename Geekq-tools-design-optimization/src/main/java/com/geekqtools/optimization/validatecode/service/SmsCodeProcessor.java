/**
 * 
 */
package com.geekqtools.optimization.validatecode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码处理器
 * 
 * @author 邱润泽  bullock
 *
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {

        System.out.println("发送 -- sms -- 验证码！");
	}

}
