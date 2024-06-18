package com.store.meonggae.product.domain;


public class ProductDomain {
	private String name, detail, quality_code, category_num,  price, cnt, trade_method_code, category, location, sell_status_code;
	
	public ProductDomain() {
		
	}

	public ProductDomain(String name, String detail, String quality_code, String category_num, String price, String cnt,
			String trade_method_code, String category, String location, String sell_status_code) {
		super();
		this.name = name;
		this.detail = detail;
		this.quality_code = quality_code;
		this.category_num = category_num;
		this.price = price;
		this.cnt = cnt;
		this.trade_method_code = trade_method_code;
		this.category = category;
		this.location = location;
		this.sell_status_code = sell_status_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	public String getQuality_code() {
		return quality_code;
	}

	public void setQuality_code(String quality_code) {
		this.quality_code = quality_code;
	}

	public String getCategory_num() {
		return category_num;
	}

	public void setCategory_num(String category_num) {
		this.category_num = category_num;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public String getTrade_method_code() {
		return trade_method_code;
	}

	public void setTrade_method_code(String trade_method_code) {
		this.trade_method_code = trade_method_code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSell_status_code() {
		return sell_status_code;
	}

	public void setSell_status_code(String sell_status_code) {
		this.sell_status_code = sell_status_code;
	}

	@Override
	public String toString() {
		return "ProductDomain [name=" + name + ", detail=" + detail + ", quality_code=" + quality_code + ", category_num=" + category_num + ", price="
				+ price + ", cnt=" + cnt + ", trade_method_code=" + trade_method_code + ", category=" + category
				+ ", location=" + location + ", sell_status_code=" + sell_status_code + "]";
	}

	
	
	
}
