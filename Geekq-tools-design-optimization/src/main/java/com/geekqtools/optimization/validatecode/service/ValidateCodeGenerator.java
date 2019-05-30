/**
 * 
 */
package com.geekqtools.optimization.validatecode.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author 邱润泽 bullock
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
