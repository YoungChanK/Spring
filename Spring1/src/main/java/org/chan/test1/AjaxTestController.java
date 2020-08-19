package org.chan.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AjaxTestController {
	private static final Logger logger=LoggerFactory.getLogger(BoardController.class);
	@RequestMapping(value = "ajaxtest", method = RequestMethod.GET)
	public void ajaxtestGET() throws Exception{
		logger.info("ajaxtest get.......");
	}
}
