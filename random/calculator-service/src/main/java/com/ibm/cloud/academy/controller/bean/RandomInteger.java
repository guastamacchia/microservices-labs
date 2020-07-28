package com.ibm.cloud.academy.controller.bean;

public class RandomInteger {
	private Integer value;
	private String hostname;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
