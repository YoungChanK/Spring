package org.chan.test1;

import org.chan.domain.SampleDTO;
import org.chan.domain.SampleDTOList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//�ڹ������� controller�� �νĽ����ֱ� ���� @Controller�� ���
@Controller
//�������� view�� �ִ� ������ �����ߴ��ϸ� view�ȿ� �ٸ� ������ ������ ������ value���� �̸� �������ش�   (���⼱ GET��ĸ� ����)
// view/doA   ==>>  view/board/doA
@RequestMapping(value="board")

public class SampleController {
	private static final Logger logger=LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value="doW", method = RequestMethod.GET)
	public void doW(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name,@RequestParam("phone") int phone) {
		logger.info("@RequestMapping doW�� ȣ��Ǿ����ϴ� ");
	}
	//������ �뷮�� ū��� ���� ������� �޴°� ����
	@RequestMapping(value="doM" , method = RequestMethod.GET)
	public void doM(SampleDTO sdto) {
		logger.info("@RequestMapping doM�� ȣ��Ǿ����ϴ� ");
	}
	@RequestMapping(value="doD" , method = RequestMethod.GET)
	public void doD(SampleDTOList list) {
		logger.info("SampleDTOList="+list);
		logger.info("@RequestMapping doD�� ȣ��Ǿ����ϴ� ");
	}
	@RequestMapping(value="doR", method = RequestMethod.GET)
	public void doR() {
		logger.info("@RequestMapping doR�� ȣ��Ǿ����ϴ� ");
	}

/*	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called...............");
	}*/
}
