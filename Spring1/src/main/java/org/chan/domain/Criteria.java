package org.chan.domain;

public class Criteria {
	//페이지 번호
	private int pageNum;
	//페이지 당 데이터 수
	private int amount;
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		if(pageNum<0) {
			this.pageNum=1;
			return;
		}
		
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public int getpageStart() {
		return (this.pageNum-1)*amount;
	}
	
	public void setAmount(int amount) {
		if(amount<=0 ||amount >100) {
			this.amount=10;
			return;
		}
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
}
