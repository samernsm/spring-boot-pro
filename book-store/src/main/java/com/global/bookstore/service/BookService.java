package com.global.bookstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.global.bookstore.base.BaseService;
import com.global.bookstore.entity.Book;
import com.global.bookstore.repository.BookRepo;

@Service
public class BookService extends BaseService<Book, Long> {

	private BookRepo bookRepo;
	
	Logger log = LoggerFactory.getLogger(BookService.class);
	
    private final static String USERS_PROC = ".INSERT_JP_USERS";
    
    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private Environment env;

	public BookService(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	
    public Book addUsers(Book book) {
        String dbName = env.getProperty("spring.jpa.properties.hibernate.default_schema");
        
        StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(dbName + USERS_PROC);
        
        query.registerStoredProcedureParameter("Email_Param", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("First_Name_Param", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("Middle_Name_Param", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("Last_Name_Param", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("Gender_Param", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("Phone_Number_Param", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("Summary_Param", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("Experience_Param", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("Profile_Img_Param", String.class, ParameterMode.IN);
        
        query.registerStoredProcedureParameter("Result_Param", Integer.class, ParameterMode.OUT);
        
//        query.setParameter("Email_Param", book.getEmail());
//        query.setParameter("First_Name_Param", book.getFirstName());
//        query.setParameter("Middle_Name_Param", book.getMiddleName());
//        query.setParameter("Last_Name_Param", book.getLastName());
//        query.setParameter("Gender_Param", book.getGender());
//        query.setParameter("Phone_Number_Param", book.getPhoneNumber());
//        query.setParameter("Summary_Param", book.getSummary());
//        query.setParameter("Experience_Param", book.getExperience());
//        query.setParameter("Profile_Img_Param", book.getProfileImg());
        
        int count = ((Number) query.getOutputParameterValue("Result_Param")).intValue();
        
//        if (count == 1) {
//            AddUserResponse usrResp = new AddUserResponse(Constant.STATUS_TRUE, Constant.SUCCESS);
//            usrResp.setData(new AddUserSPResponse("User added successfully."));
//            return usrResp;
//        } else {
//            AddUserResponse usrResp = new AddUserResponse(Constant.STATUS_TRUE, Constant.SUCCESS);
//            usrResp.setData(new AddUserSPResponse("User updated successfully."));
//            return usrResp;
//        }
        
        return null;
    }
	
	
	
	
	
	public List<Book> insertAll(List<Book> entities) {
		
		return bookRepo.saveAll(entities);
	}

	public Book update(Book entity) {

		Book book = findById(entity.getId());

		book.setName(entity.getName());

		return update(book);
	}

	
	public int deleteByAutherId (Long id) {
		
		return bookRepo.deleteByAutherId(id);
	}

}
