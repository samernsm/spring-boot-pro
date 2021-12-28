package com.global.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.bookstore.Repository.AutherRepo;
import com.global.bookstore.entity.Auther;

@Service
public class AutherService {
	
	private AutherRepo autherRepo;

	public AutherService(AutherRepo autherRepo) {
		super();
		this.autherRepo = autherRepo;
	}
	
	public Auther findById(Long id) {
		return autherRepo.findById(id).orElseThrow();
	}
     
	public List<Auther> findAll(){
		return autherRepo.findAll();
	}
	
	public Auther insert(Auther entity) {
		if(entity.getId() != null) {
			throw new RuntimeException();
		}
		
		 
		return autherRepo.save(entity);
	}

	
	public List<Auther> insertAll(List<Auther> entity) {
				 
		return autherRepo.saveAll(entity);
	}
	
	public Auther update(Auther entity) {
		Auther auther = findById(entity.getId());
		
		auther.setName(entity.getName());
		
		return autherRepo.save(auther);
	}
	
	public void delete(Long id) {
		autherRepo.deleteById(id);
		
		
	}
}
