package org.chan.domain;

public class SampleDTO {
	private String id;
	private String password;
	private String name;
	private int phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "SampleDTO [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + "]";
	}
}
