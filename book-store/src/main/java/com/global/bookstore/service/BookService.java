package com.global.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.bookstore.Repository.BookRepo;
import com.global.bookstore.entity.Book;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;

    public Book findById(Long id) {
     	
    return bookRepo.findById(id).orElseThrow();
    	
    }
	
	/*
	 * public Book findByName(String name) { return bookRepo.findByName(name); }
	 * 
	 * public Book findByPrice(Double price) { return bookRepo.findByPrice(price); }
	 */

}
