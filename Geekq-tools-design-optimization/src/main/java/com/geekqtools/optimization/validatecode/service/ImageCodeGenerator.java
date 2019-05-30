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
@Component("imageValidateCodeGenerator")
public class ImageCodeGenerator implements ValidateCodeGenerator {


	@Override
	public ValidateCode generate(ServletWebRequest request) {

		ImageCode code = new ImageCode("",60);
		System.out.println("this is image code  check!");
		return code;
	}
}
