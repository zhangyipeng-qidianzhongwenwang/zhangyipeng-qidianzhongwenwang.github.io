package com.systop.entity;

import java.util.List;

public class JavaBean<T> {
	private int pc;//当前页码
	private int tp;//总页数
	private int tr;//总记录数
	private int ps;//每页记录数
	private List<T> getBeanList;
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTp() {
		int tp=tr/ps;
		return tr%ps==0?tp:tp+1;
	}
//	public void setTp(int tp) {
//		this.tp = tp;
//	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getGetBeanList() {
		return getBeanList;
	}
	public void setGetBeanList(List<T> getBeanList) {
		this.getBeanList = getBeanList;
	}
	
}
