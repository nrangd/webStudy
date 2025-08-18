package chap06.dto;

public class Cloth {
	String cloth_part;
	String cloth_brand;
	Integer cloth_price;
	String cloth_size;
	Integer cloth_id;
	
	public Cloth(String cloth_part, String cloth_brand, String cloth_price, String cloth_size, String cloth_id) {
		this.cloth_part = cloth_part;
		this.cloth_brand = cloth_brand;
		this.cloth_price = Integer.parseInt(cloth_price);
		this.cloth_size = cloth_size;
		this.cloth_id = Integer.parseInt(cloth_id);
	}
	
	public Cloth(String cloth_part, String cloth_brand, Integer cloth_price, String cloth_size, Integer cloth_id) {
		this.cloth_part = cloth_part;
		this.cloth_brand = cloth_brand;
		this.cloth_price = cloth_price;
		this.cloth_size = cloth_size;
		this.cloth_id = cloth_id;
	}
	public String getCloth_part() {
		return cloth_part;
	}
	public void setCloth_part(String cloth_part) {
		this.cloth_part = cloth_part;
	}
	public String getCloth_brand() {
		return cloth_brand;
	}
	public void setCloth_brand(String cloth_brand) {
		this.cloth_brand = cloth_brand;
	}
	public Integer getCloth_price() {
		return cloth_price;
	}
	public void setCloth_price(Integer cloth_price) {
		this.cloth_price = cloth_price;
	}
	public String getCloth_size() {
		return cloth_size;
	}
	public void setCloth_size(String cloth_size) {
		this.cloth_size = cloth_size;
	}
	public Integer getCloth_id() {
		return cloth_id;
	}
	public void setCloth_id(Integer cloth_id) {
		this.cloth_id = cloth_id;
	}
	
}
