package com.global.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.global.bookstore.base.BaseRepository;
import com.global.bookstore.entity.Auther;

@Repository
public interface AutherRepo extends BaseRepository<Auther, Long>, JpaSpecificationExecutor<Auther> {
	
	
	@Transactional
	@Query(value = "UPDATE Auther a SET a.isDeleted = false WHERE a.id = ?1")
	@Modifying
	public void restoreById(Long id);
	
	Optional<Auther> findByEmail(String email);

}