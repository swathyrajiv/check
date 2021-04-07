package com.w.simplilearn.thirdphase;

import java.math.BigDecimal;

public class Item {
		String cuizineName;
		public String getCuizineName() {
			return cuizineName;
		}
		public void setCuizineName(String cuizineName) {
			this.cuizineName = cuizineName;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		String quantity;
	  BigDecimal price;
	@Override
	public String toString() {
		return "Item [cuizineName=" + cuizineName + ", quantity=" + quantity + ", price=" + price + "]";
	}

	


}
