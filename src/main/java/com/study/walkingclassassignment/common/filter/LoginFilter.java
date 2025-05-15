package com.study.walkingclassassignment.common.filter;

import java.io.IOException;

import org.springframework.util.PatternMatchUtils;

import com.study.walkingclassassignment.common.exception.CustomException;
import com.study.walkingclassassignment.common.exception.ErrorCode;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private static final String[] WHITE_LIST = {"/", "/login", "/signup"};

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
		IOException,
		ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		String requestURI = httpRequest.getRequestURI();

		if (!isWhiteList(requestURI)) {
			HttpSession httpSession = httpRequest.getSession(false);
			if (httpSession == null || httpSession.getAttribute(Const.LOGIN_USER) == null) {
				throw new CustomException(ErrorCode.NEED_LOGIN);
			}
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	private boolean isWhiteList(String requestURI) {
		return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
	}
}
