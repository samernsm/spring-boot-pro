package com.global.bookstore.entity;

public class BookDto {
	
	private Long id ;
    private String Name;
    private Double price;
	private Auther auther;    
    
	public Auther getAuther() {
		return auther;
	}
	public void setAuther(Auther auther) {
		this.auther = auther;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
