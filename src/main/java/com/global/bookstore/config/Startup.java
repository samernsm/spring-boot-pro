package com.global.bookstore.config;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.bookstore.entity.Auther;
import com.global.bookstore.entity.Book;
import com.global.bookstore.service.AutherService;
import com.global.bookstore.service.BookService;

@Component
public class Startup implements CommandLineRunner {

	@Autowired
	private AutherService autherService;
	
	@Autowired
	private BookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Auther auther1 = new Auther();
		auther1.setName("ali");
	
		Auther auther2 = new Auther();
		auther2.setName("moh");
	
		Auther auther3 = new Auther();
		auther3.setName("said");
		
		autherService.insertAll(Arrays.asList(auther1,auther2,auther3));
	
	    //------------------book-----------------
		
		Book book1 = new Book();
		book1.setName("java");
	    book1.setPrice(200.0);
		book1.setAuther(autherService.findById(1L));
	    
	    
		Book book2 = new Book();
		book2.setName("c#");
		book2.setPrice(300.0);
		book2.setAuther(autherService.findById(1L));
		
		
		Book book3 = new Book();
		book3.setName("python");
		book3.setPrice(400.0);
		book3.setAuther(autherService.findById(2L)); 
		
	    bookService.insertAll(Arrays.asList(book1,book2,book3));
	
	}

}
