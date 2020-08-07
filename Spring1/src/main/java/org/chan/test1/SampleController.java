package org.chan.test1;

import org.chan.domain.SampleDTO;
import org.chan.domain.SampleDTOList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//자바파일을 controller로 인식시켜주기 위해 @Controller를 사용
@Controller
//그전까진 view에 있는 파일을 메핑했다하면 view안에 다른 파일이 있을시 위에서 value값을 미리 선언해준다   (여기선 GET방식만 가능)
// view/doA   ==>>  view/board/doA
@RequestMapping(value="board")

public class SampleController {
	private static final Logger logger=LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value="doW", method = RequestMethod.GET)
	public void doW(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name,@RequestParam("phone") int phone) {
		logger.info("@RequestMapping doW가 호출되었습니다 ");
	}
	//데이터 용량이 큰경우 밑의 방식으로 받는게 좋음
	@RequestMapping(value="doM" , method = RequestMethod.GET)
	public void doM(SampleDTO sdto) {
		logger.info("@RequestMapping doM가 호출되었습니다 ");
	}
	@RequestMapping(value="doD" , method = RequestMethod.GET)
	public void doD(SampleDTOList list) {
		logger.info("SampleDTOList="+list);
		logger.info("@RequestMapping doD가 호출되었습니다 ");
	}
	@RequestMapping(value="doR", method = RequestMethod.GET)
	public void doR() {
		logger.info("@RequestMapping doR가 호출되었습니다 ");
	}

/*	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called...............");
	}*/
}
