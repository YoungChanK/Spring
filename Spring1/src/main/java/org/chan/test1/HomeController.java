package org.chan.test1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
		
		String str="home.jsp으로 이동합니다.";
		//model�� ���ؼ� ȭ�鿡 �����ش�.
		model.addAttribute("str", str);
		
		return "home";
	} //home 메소드 끝
	
	@RequestMapping(value="/doA", method = RequestMethod.GET)
	public void doA(Locale local,Model model) {
		System.out.println("doA................");
	}
	@RequestMapping(value="/doB", method = RequestMethod.GET)
	public void doB(Locale local,Model model) {
		System.out.println("doB................");
		model.addAttribute("result","DOB RESULT");
	}
	
}
