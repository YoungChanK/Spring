package org.chan.intercertor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.chan.test1.SampleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger=LoggerFactory.getLogger(SampleController.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("pre handle...........");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// MemberController에 loginPost메소드에 얻은 select 결과의 model 정보를 interceptor해서 session영역에 저장
		//Session 사용하겠다고 선언
		HttpSession session = request.getSession();
		// MemberController에 loginPost메소드에 얻은 select 결과의 model 정보를 가지고 와라
		Object userVO= modelAndView.getModel().get("userVO");
		
		//uservo에 정보가 있으면
		if(userVO!=null) {
			logger.info("new login success");
			session.setAttribute("login", userVO);
			response.sendRedirect("/chan"); //메인으로 이동
		}else {
			
		}
		
	}

}

