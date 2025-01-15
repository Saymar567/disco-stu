package com.ipartek.model.dto;

public class V_Disco extends Disco {
	
	private String categoria;
	
	public V_Disco(int id, String title, String groupname, String year, double price, int FK_categoria, String categoria) {
		super(id, title, groupname, year, price, FK_categoria);
		this.categoria = categoria;
	}
	
	public V_Disco() {
		super();
		this.categoria = "";
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "V_Disco [categoria=" + categoria + ", toString()=" + super.toString() + "]";
	}
	
	
}
