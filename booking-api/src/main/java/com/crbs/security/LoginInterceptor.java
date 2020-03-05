package com.crbs.security;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.crbs.model.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("preHandle() called");

		HttpSession session = request.getSession();
		Object loginId = session.getAttribute("loginId");
		if (loginId != null) {
			session.removeAttribute("loginId");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("postHandle() called");

		Map<String, Object> model = modelAndView.getModel();

		User u = (User) model.get("loginResult");

		String targetUrl = request.getParameter("targetUrl");
		logger.info("URL::::::::::{}", targetUrl);
		logger.info("urlNo::::::::::{}", request.getParameter("urlNo"));

		if (u != null) {
			request.getSession().setAttribute("loginId", u.getId());
			request.getSession().setAttribute("loginName", u.getName());
			request.getSession().setAttribute("loginPassword", u.getPassword());
			request.getSession().setAttribute("loginPhoneNumber", u.getPhonenumber());
			request.getSession().setAttribute("loginIsAdmin", u.getIsadmin());

			if (targetUrl != null && !targetUrl.equals("")) {
				response.sendRedirect("/v0.0.3/crbs/reservations");
			} else {
				response.sendRedirect("/v0.0.3/crbs");
			}
		} else {
			response.sendRedirect("/v0.0.3/crbs");
			logger.info("login Failed");
		}
	}
}
