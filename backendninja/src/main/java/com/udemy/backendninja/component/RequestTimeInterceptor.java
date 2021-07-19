package com.udemy.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



@Component("requestTimeInterceptor")
public class RequestTimeInterceptor implements HandlerInterceptor{
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	//Se ejecutara antes de entrar en el metodo del controlador
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		
		return true;
	}
	
	//Se ejecutara justo antes de mostrar la vista en el navegador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long)request.getAttribute("startTime");
		LOG.info("--REQUEST ULR: '" + request.getRequestURL().toString()+ "' --TOTAL TIME: '"+ (System.currentTimeMillis() - startTime) +" ms' ");
	}

}
