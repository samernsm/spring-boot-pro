package com.global.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.bookstore.entity.Book;

@Repository
public interface BookRepo  extends JpaRepository<Book, Long> {

	//public Book findByName(String name);
	
	//public Book findByPrice(Double  price);
  
}
