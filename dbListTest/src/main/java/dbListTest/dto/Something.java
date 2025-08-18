package dbListTest.dto;

import java.sql.Date;
import java.time.LocalDate;

public class Something {
	Integer st_id;
	String st_str1;
	String st_str2;
	Date st_date;
	Integer st_number;
	public Something(String st_id, String st_str1, String st_str2, String st_date, String st_number) {
		this.st_id = Integer.parseInt(st_id);
		this.st_str1 = st_str1;
		this.st_str2 = st_str2;
		this.st_date = Date.valueOf(LocalDate.parse(st_date));
		this.st_number = Integer.parseInt(st_number);
	}
	public Something(Integer st_id, String st_str1, String st_str2, Date st_date, Integer st_number) {
		this.st_id = st_id;
		this.st_str1 = st_str1;
		this.st_str2 = st_str2;
		this.st_date = st_date;
		this.st_number = st_number;
	}
	public Integer getSt_id() {
		return st_id;
	}
	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}
	public String getSt_str1() {
		return st_str1;
	}
	public void setSt_str1(String st_str1) {
		this.st_str1 = st_str1;
	}
	public String getSt_str2() {
		return st_str2;
	}
	public void setSt_str2(String st_str2) {
		this.st_str2 = st_str2;
	}
	public Date getSt_date() {
		return st_date;
	}
	public void setSt_date(Date st_date) {
		this.st_date = st_date;
	}
	public Integer getSt_number() {
		return st_number;
	}
	public void setSt_number(Integer st_number) {
		this.st_number = st_number;
	}
	
	
}
