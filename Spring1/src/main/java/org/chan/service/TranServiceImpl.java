package org.chan.service;

import org.chan.aop.SampleAdvice;
import org.chan.mapper.TranMapper1;
import org.chan.mapper.TranMapper2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TranServiceImpl implements TranService{
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	@Autowired
	private TranMapper1 tmapper1;
	@Autowired
	private TranMapper2 tmapper2;
	@Transactional
	@Override
	public void addData(String value) {
		logger.info("transction 적용 전");
		tmapper1.inserCol1(value);
		tmapper2.inserCol1(value);
	}

}
