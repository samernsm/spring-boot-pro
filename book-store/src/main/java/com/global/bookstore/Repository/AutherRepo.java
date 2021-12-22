package com.global.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.bookstore.entity.Auther;

@Repository
public interface AutherRepo  extends  JpaRepository<Auther,Long>{

	
}
