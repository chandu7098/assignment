package com.assignement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignement.dto.BookDTO;
import com.assignement.model.Book;
import com.assignement.service.BookService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin()
@RestController
@Slf4j
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<BookDTO>> getAllBooks() {
		log.info("Get request received to fetch all the books");
		try {
			List<BookDTO> list = bookService.findAllBooks();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			log.info("Get request Completed to fetch all the books");
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			log.info("exception occur while fetching the books");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> savebook(@RequestBody BookDTO bookDTO) {
		log.info("post request received to save the books");
		try {
			log.info("post request completed to save he books");
			return new ResponseEntity<>(bookService.saveBook(bookDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			log.info("exception occured while saving the book {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/book")
	public ResponseEntity<Book> updateBook(@RequestBody BookDTO bookDTO) {
		log.info("put  request received to update the book");
		try {
			log.info("put request completed to update the books");
			return new ResponseEntity<>(bookService.updateBook(bookDTO), HttpStatus.OK);
		} catch (Exception e) {
			log.info("exception occur while updating the record {}",e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Integer id) {
		log.info("Delete request received to delete the books");
		try {
			Optional<Book> book = bookService.findByIdBook(id);
			if (book.isPresent()) {
				bookService.deleteBook(book.get());
				log.info("Delete request Completed to delete the books");
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.info("Exception occur while deleting the record {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDTO> findByBookId(@PathVariable Integer id) {
		log.info("Get request received to fetch specific the book");
		try {
			BookDTO book = bookService.findByBookId(id);
			if (book != null) {
				log.info("Get request Completed to fetch specific the book");
				return new ResponseEntity<>(book, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
