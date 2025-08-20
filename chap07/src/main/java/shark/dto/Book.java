package shark.dto;

import java.util.Date;

public class Book {
	private String isbn;
	private String book_name;
	private String author;
	private Integer price;
	private Integer page;
	private Date pub_date;
	
	public Book() {
		
	}
	
	public Book(String isbn, String book_name, String author, Integer price, Integer page, Date pub_date) {
		
		this.isbn = isbn;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.page = page;
		this.pub_date = pub_date;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Date getPub_date() {
		return pub_date;
	}
	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}
	
	@Override
	public String toString() {
		return book_name + "책입니다";
	}
}
