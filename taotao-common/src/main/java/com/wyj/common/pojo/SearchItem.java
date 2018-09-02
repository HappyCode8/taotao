package com.wyj.common.pojo;

import java.io.Serializable;

public class SearchItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private String sell_point;
	private Long price;
	private String image;
	private String caterory_name;
	private String item_desc;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSell_point() {
		return sell_point;
	}
	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCaterory_name() {
		return caterory_name;
	}
	public void setCaterory_name(String caterory_name) {
		this.caterory_name = caterory_name;
	}
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public String[] getImages() {
	    if (image != null && !"".equals(image)) {
	        String[] strings = image.split(",");
	        return strings;
	    }
	    return null;
	}
}
