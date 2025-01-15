package com.ipartek.model.dto;

public class Disco {

	private int id;
	private String title;
	private String groupname;
	private String year;
	private double price;
	private int FK_categoria;
	
	public Disco(int id, String title, String groupname, String year, double price, int FK_categoria) {
		super();
		
		this.id = id;
		this.title = title;
		this.groupname = groupname;
		this.year = year;
		this.price = price;
		this.FK_categoria = FK_categoria;
	}
	
	public Disco() {
		this.id = 0;
		this.title = "";
		this.groupname = "";
		this.year = "";
		this.price = 0.0;
		this.FK_categoria = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFK_categoria() {
		return FK_categoria;
	}
	public void setFK_categoria(int FK_categoria) {
		this.FK_categoria = FK_categoria;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", title=" + title + ", groupname=" + groupname + ", year=" + year + ", price="
				+ price + ", FK_categoria=" + FK_categoria + "]";
	}
	
	
	
}
