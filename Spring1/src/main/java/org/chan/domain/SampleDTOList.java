package org.chan.domain;

import java.util.ArrayList;
import java.util.List;

public class SampleDTOList {
	private List<SampleDTO> list;
	//기본생성자로 초기화
	public SampleDTOList() {
		list = new ArrayList<>();
	}
	
	public List<SampleDTO> getList() {
		return list;
	}
	public void setList(List<SampleDTO> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "SampleDTOList [list=" + list + "]";
	}
	
}
