package org.chan.test1;

import java.util.ArrayList;
import java.util.List;

import org.chan.domain.SampleVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class RestSampleController {

	@RequestMapping("hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping("sendVO")
	public SampleVO sendVO() {
		SampleVO vo =new SampleVO();
		vo.setFirstName("자바");
		vo.setLastName("정");
		vo.setMno(123);
		return vo;
	}
	@RequestMapping("sendlist")
	public List<SampleVO> sendlist() {
		List<SampleVO> list=new ArrayList<>();
		for(int i=0;i<10;i++) {
		SampleVO vo =new SampleVO();
		vo.setFirstName("길동");
		vo.setLastName("홍");
		vo.setMno(i);
		list.add(vo);
		}
		return list;
	}
	@RequestMapping("sendMap")
	public List<SampleVO> sendlMap() {
		List<SampleVO> list=new ArrayList<>();
		for(int i=0;i<10;i++) {
			SampleVO vo =new SampleVO();
			vo.setFirstName("길동");
			vo.setLastName("홍");
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}

}
