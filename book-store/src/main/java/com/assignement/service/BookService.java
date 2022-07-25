package com.assignement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignement.dto.BookDTO;
import com.assignement.model.Author;
import com.assignement.model.Book;
import com.assignement.repo.AuthorRepo;
import com.assignement.repo.BookRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	AuthorRepo authorRepo;

	public List<BookDTO> findAllBooks() {
		log.info("Request received to fetch all records from service layer");
		List<Book> books = bookRepo.findAll();
		List<BookDTO> bookDTOs = new ArrayList<>();
		for(Book book : books) {
			bookDTOs.add(BookDTO.builder()
					.bookId(book.getBookId())
					.title(book.getTitle())
					.price(book.getPrice())
					.numberOfPages(book.getNumberOfPages())
					.authorId(book.getAuthor().getAuthorId())
					.authorName(book.getAuthor().getFirstName())
					.build());
		}
		return bookDTOs;
		
	}

	public Book saveBook(BookDTO bookDto) {
		log.info("Request received to save records from service layer");
		Optional<Author> optionalAuthor = authorRepo.findById(bookDto.getAuthorId());
		
		Book book = Book.builder()
		.title(bookDto.getTitle())
		.price(bookDto.getPrice())
		.numberOfPages(bookDto.getNumberOfPages())
		.author(optionalAuthor.get())
		.build();
		
		return bookRepo.save(book);
	}
	
	
	public Book updateBook(BookDTO bookDto) {
		log.info("Request received to updatye records from service layer");
		Optional<Author> optionalAuthor = authorRepo.findById(bookDto.getAuthorId());
		
		Book book = Book.builder()
				.bookId(bookDto.getBookId())
				.title(bookDto.getTitle())
				.price(bookDto.getPrice())
				.numberOfPages(bookDto.getNumberOfPages())
				.author(optionalAuthor.get())
				.build();
		
		return bookRepo.save(book);
	}

	public Optional<Book> findByIdBook(Integer id) {
		log.info("Request received to fetch specific records from service layer");
		// TODO Auto-generated method stub
		return bookRepo.findById(id);
	}
	
	public BookDTO findByBookId(Integer id) {
		log.info("Request received to specific records from service layer");
		Optional<Book> optBook = bookRepo.findById(id);
		if(optBook.isPresent()) {
			Book book = optBook.get();
			return BookDTO.builder()
			.bookId(book.getBookId())
			.title(book.getTitle())
			.price(book.getPrice())
			.numberOfPages(book.getNumberOfPages())
			.authorId(book.getAuthor().getAuthorId())
			.authorName(book.getAuthor().getFirstName())
			.build();
		}else {
			return null;
		}
	}

	public void deleteBook(Book book) {
		log.info("Request received to delete record from service layer");
		bookRepo.delete(book);
		
	}
	
	

}
