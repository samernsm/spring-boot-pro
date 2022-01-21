package com.global.bookstore.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.global.bookstore.base.BaseService;
import com.global.bookstore.entity.Auther;
import com.global.bookstore.entity.AutherSearch;
import com.global.bookstore.error.DaplicateRecoredException;
import com.global.bookstore.repository.AutherRepo;
import com.global.bookstore.repository.AutherSpec;

@Service
public class AutherService extends BaseService<Auther, Long> {

	@Autowired
	private AutherRepo autherRepo;
	
	Logger log = LoggerFactory.getLogger(AutherService.class);

	@Override
	public Auther insert(Auther entity) {
		
	if (!entity.getEmail().isEmpty() && entity.getEmail() != null) {
		CompletableFuture<Auther> auther = findByEmail(entity.getEmail());
		
		log.info("author name is {} and email is {} " , entity.getFullName() , entity.getEmail());
				
		if(auther.isDone()) {
			
			log.error("This email already found with anther author");
			throw new DaplicateRecoredException("This email already found with anther author");
		}

	}

		return super.insert(entity);
	}

	@Override
	public Auther update(Auther entity) {

		Auther auther = findById(entity.getId());

		auther.setFullName(entity.getFullName());

		return super.update(auther);
	}

	public List<Auther> findByAutherSpec(AutherSearch search) {

		AutherSpec spec = new AutherSpec(search);

		return autherRepo.findAll(spec);

	}

	@Async(value = "threadPoolTaskExecutor")
	public CompletableFuture<Auther> findByEmail(String email) {

		return CompletableFuture.completedFuture(autherRepo.findByEmail(email).get());
	}

}