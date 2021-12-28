package com.global.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.bookstore.Repository.AutherRepo;
import com.global.bookstore.Repository.BookRepo;
import com.global.bookstore.entity.Auther;
import com.global.bookstore.entity.Book;

@Service
public class BookService {

	
    private	BookRepo bookRepo;

    
	public BookService(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	
	
	
	public Book findById(Long id) {
     	
    return bookRepo.findById(id).orElseThrow();
    	
    }
	
         
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	
	public Book insert(Book entity) {
		if(entity.getId() != null) {
			throw new RuntimeException();
		}
		
		 
		return bookRepo.save(entity);
	}
    
	public List<Book> insertAll(List<Book> entity) {
			
		 
		return bookRepo.saveAll(entity);
	}
	
	public Book update(Book entity) {
		Book book = findById(entity.getId());
		
		book.setName(entity.getName());
		book.setPrice(entity.getPrice());
		
		
		return bookRepo.save(book);
	}
	
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
		
		
	}


}
