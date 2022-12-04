package com.anshul.interiormanagementsystem.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String brand;
	private Long qty;
	private BigDecimal price;
	private Integer gst;
	private BigDecimal mrp;
	private String date;
	private String updateDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getGst() {
		return gst;
	}
	public void setGst(Integer gst) {
		this.gst = gst;
	}
	public BigDecimal getMrp() {
		return mrp;
	}
	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public Item(String name, String brand, Long qty, BigDecimal price, Integer gst, BigDecimal mrp, String date,
			String updateDate) {
		super();
		this.name = name;
		this.brand = brand;
		this.qty = qty;
		this.price = price;
		this.gst = gst;
		this.mrp = mrp;
		this.date = date;
		this.updateDate = updateDate;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
