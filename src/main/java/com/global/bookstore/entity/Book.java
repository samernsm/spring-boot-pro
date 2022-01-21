package com.global.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@NamedEntityGraph(name = "loadAuther",attributeNodes = @NamedAttributeNode("auther"))
@Table( name = "book")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
    private String Name;
    private Double price;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auther_id")
    private Auther auther;
    
    
    
    
    
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
	public Auther getAuther() {
		return auther;
	}
	public void setAuther(Auther auther) {
		this.auther = auther;
	}
    


}
