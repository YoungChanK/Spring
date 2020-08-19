package org.chan.domain;

public class ReplyVO {
	private int rno;
	private int bno;
	private String replytext;
	private String replyer;
	private String redgate;
	private String updatedate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getRedgate() {
		return redgate;
	}
	public void setRedgate(String redgate) {
		this.redgate = redgate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "replyVO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", redgate=" + redgate + ", updatedate=" + updatedate + "]";
	}
	
	
	
	
	

}
