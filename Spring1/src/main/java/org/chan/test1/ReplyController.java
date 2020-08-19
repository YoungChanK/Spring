package org.chan.test1;

import java.util.List;

import org.chan.domain.Criteria;
import org.chan.domain.ReplyVO;
import org.chan.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies")
public class ReplyController {
	@Autowired
	private ReplyService reservice;
	
	@RequestMapping(value="/all/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno")int bno,@PathVariable("page")int page) throws Exception{
		Criteria cri= new Criteria(page,10); 
		return new ResponseEntity<>(reservice.list(bno,cri),HttpStatus.OK);
		
	}
	//댓글쓰기
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> list(@RequestBody ReplyVO vo) throws Exception{
		ResponseEntity<String> entity=null;
		try {
			reservice.create(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//수정하기
	@RequestMapping(value="{rno}",method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno")int rno,@RequestBody ReplyVO vo) throws Exception{
		ResponseEntity<String> entity=null;
		try {
			vo.setRno(rno);
			reservice.update(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//삭제하기
	@RequestMapping(value="{rno}",method= RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno")int rno) throws Exception{
		ResponseEntity<String> entity=null;
		try {
		
			reservice.delete(rno);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
