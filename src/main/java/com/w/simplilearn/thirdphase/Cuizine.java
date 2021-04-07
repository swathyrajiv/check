package com.w.simplilearn.thirdphase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Cuizine {
	int product_id;
	 LocalDate date;
	 int sesproduct_id;
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	String daten;
 String editCuizine;
 int[] selid;

 
 
	public int[] getSelid() {
	return selid;
}





public void setSelid(int[] selid) {
	this.selid = selid;
}





	public String getEditCuizine() {
	return editCuizine;
}





public void setEditCuizine(String editCuizine) {
	this.editCuizine = editCuizine;
}





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


	String cuizineName;
	 String cuizineType;
     String vegornonveg;
     String vegan;
     BigDecimal price;
	
 
     private List<Cuizine> cuizines;


    





	@Override
	public String toString() {
		return "Cuizine [product_id=" + product_id + ", date=" + date + ", sesproduct_id=" + sesproduct_id + ", daten="
				+ daten + ", editCuizine=" + editCuizine + ", selid=" + Arrays.toString(selid) + ", cuizineName="
				+ cuizineName + ", cuizineType=" + cuizineType + ", vegornonveg=" + vegornonveg + ", vegan=" + vegan
				+ ", price=" + price + "]";
	}





	public String getCuizineName() {
		return cuizineName;
	}





	public void setCuizineName(String cuizineName) {
		this.cuizineName = cuizineName;
	}





	public String getCuizineType() {
		return cuizineType;
	}





	public void setCuizineType(String cuizineType) {
		this.cuizineType = cuizineType;
	}





	public String getVegornonveg() {
		return vegornonveg;
	}





	public void setVegornonveg(String vegornonveg) {
		this.vegornonveg = vegornonveg;
	}





	public String getVegan() {
		return vegan;
	}





	public void setVegan(String vegan) {
		this.vegan = vegan;
	}





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





	public Cuizine find(int id) {
		for (Cuizine cuizine : this.cuizines) {
			 cuizine.getProduct_id();
				return cuizine;
			
		}
		
		return null;
	}



	

	


 
    
}
