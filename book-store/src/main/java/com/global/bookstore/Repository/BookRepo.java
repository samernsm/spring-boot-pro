package com.global.bookstore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.bookstore.entity.Book;

@Repository
public interface BookRepo  extends JpaRepository<Book, Long> {

	//public Book findByName(String name);
	
	//public Book findByPrice(Double  price);
	@Override
	@EntityGraph(value   = "loadAuther")
	Optional<Book> findById(Long id); 
	
	@Override
	@EntityGraph(attributePaths = {"auther"})
	List<Book> findAll(); 
	
	
}
