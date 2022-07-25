package com.assignement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignement.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
//	@Query(value = "DELETE FROM Book where bookId=:bookId", nativeQuery = true)
	void deleteByBookId(Integer bookId);

}
