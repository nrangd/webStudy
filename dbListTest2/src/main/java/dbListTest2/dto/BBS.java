package dbListTest2.dto;

import java.sql.Date;

public class BBS {
	
	Integer bbs_id;
	Integer bbs_number;
	String bbs_subject;
	Date bbs_regist_date;
	Date bbs_reservation_date;
	String bbs_content;
	String bbs_keyword;
	
	public BBS(Integer bbs_number, String bbs_subject, Date bbs_regist_date, Date bbs_reservation_date,
			String bbs_keyword) {
		super();
		this.bbs_number = bbs_number;
		this.bbs_subject = bbs_subject;
		this.bbs_regist_date = bbs_regist_date;
		this.bbs_reservation_date = bbs_reservation_date;
		this.bbs_keyword = bbs_keyword;
	}
	public BBS(Integer bbs_id, Integer bbs_number, String bbs_subject, Date bbs_regist_date, Date bbs_reservation_date,
			String bbs_content, String bbs_keyword) {
		this.bbs_id = bbs_id;
		this.bbs_number = bbs_number;
		this.bbs_subject = bbs_subject;
		this.bbs_regist_date = bbs_regist_date;
		this.bbs_reservation_date = bbs_reservation_date;
		this.bbs_content = bbs_content;
		this.bbs_keyword = bbs_keyword;
	}
	public Integer getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(Integer bbs_id) {
		this.bbs_id = bbs_id;
	}
	public Integer getBbs_number() {
		return bbs_number;
	}
	public void setBbs_number(Integer bbs_number) {
		this.bbs_number = bbs_number;
	}
	public String getBbs_subject() {
		return bbs_subject;
	}
	public void setBbs_subject(String bbs_subject) {
		this.bbs_subject = bbs_subject;
	}
	public Date getBbs_regist_date() {
		return bbs_regist_date;
	}
	public void setBbs_regist_date(Date bbs_regist_date) {
		this.bbs_regist_date = bbs_regist_date;
	}
	public Date getBbs_reservation_date() {
		return bbs_reservation_date;
	}
	public void setBbs_reservation_date(Date bbs_reservation_date) {
		this.bbs_reservation_date = bbs_reservation_date;
	}
	public String getBbs_content() {
		return bbs_content;
	}
	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}
	public String getBbs_keyword() {
		return bbs_keyword;
	}
	public void setBbs_keyword(String bbs_keyword) {
		this.bbs_keyword = bbs_keyword;
	}
}
