package com.revature.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {
    /**
     * Default constructor. 
     */
	/*
	 * A filter is a special servlet whose job is to intercept requests
	 * and perform some sort of authentication.
	 */
    public AuthenticationFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
    
	public void destroy() {
		// TODO Auto-generated method stub
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/*
	 * This doFilter method is where we will implement our authentication
	 * logic. Note that if there are any other filters, the request
	 * and response will be passed to those filters (so down the filter
	 * chain) after they pass through this filter.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * Because this method takes a generic ServletRequest and 
		 * ServletResponse, we'll need to cast these as HttpServlet
		 * Request Response objects in order to access the methods we want.
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		
		//If the user doesn't have a session, let's send back the way
		//they came.
		if(session == null) {
			resp.sendRedirect("../index.html");
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}