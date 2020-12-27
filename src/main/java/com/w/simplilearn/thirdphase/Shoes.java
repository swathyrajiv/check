package com.w.simplilearn.thirdphase;

import java.math.BigDecimal;
import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

public class Shoes {
	int product_id;
	 LocalDate date;
	 int sesproduct_id;
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	String daten;


	public String getDaten() {
		return daten;
	}





	public void setDaten(String daten) {
		this.daten = daten;
	}





	public int getSesproduct_id() {
		return sesproduct_id;
	}





	public void setSesproduct_id(int sesproduct_id) {
		this.sesproduct_id = sesproduct_id;
	}





	public LocalDate getDate() {
		return date;
	}





	public void setDate(LocalDate date) {
		this.date = date;
	}


	String brandName;
	 String size;
     String color;
     String type;
     BigDecimal price;
	
 

	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public int getProduct_id() {
		return product_id;
	}





	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}





	public Shoes() {
        super();
    }


	public String getBrandName() {
		return brandName;
	}


	@Override
	public String toString() {
		return "Shoes [product_id=" + product_id + ", date=" + date + ", sesproduct_id="
				+ sesproduct_id + ", brandName=" + brandName + ", size=" + size + ", color=" + color
				+ ", type=" + type + ", price=" + price + ", daten=" + daten + "]";
	}





	public Shoes(int product_id, LocalDate date, int sesproduct_id, String brandName, String size, String color,
			String type, BigDecimal price,String daten) {
		super();
		this.product_id = product_id;
		this.date = date;
		this.sesproduct_id = sesproduct_id;
		this.brandName = brandName;
		this.size = size;
		this.color = color;
		this.type = type;
		this.price = price;
		this.daten = daten;
	}





	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}



 
    
}
