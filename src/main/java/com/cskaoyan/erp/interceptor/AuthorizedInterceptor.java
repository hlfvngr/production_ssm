package com.cskaoyan.erp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 * 判断用户权限的Spring MVC的拦截器
 */
public class AuthorizedInterceptor  implements HandlerInterceptor {
	/** 定义不需要拦截的请求 */
	//private static final String[] IGNORE_URI = {"/loginForm", "/login"};

	/**
	 * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
	 * 当preHandle的返回值为false的时候整个请求就结束了。
	 * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
	 */

	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		String uri = httpServletRequest.getRequestURI();
		if (uri.indexOf("login")>0){
			return true;
		} else {
			HttpSession session = httpServletRequest.getSession(false);
			if (session!=null){
				Object user_session = session.getAttribute("user_session");
				if (user_session !=null){
					return true;
				} else {
					httpServletRequest.getRequestDispatcher("login").forward(httpServletRequest,httpServletResponse);
					return false;
				}
			}

			httpServletRequest.getRequestDispatcher("login").forward(httpServletRequest,httpServletResponse);
			return false;
		}
	}

	/**
	 * 该方法需要preHandle方法的返回值为true时才会执行。
	 * 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
	 */
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}

	/**
	 * 这个方法在preHandle方法返回值为true的时候才会执行。
	 * 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
	 */
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}
}
