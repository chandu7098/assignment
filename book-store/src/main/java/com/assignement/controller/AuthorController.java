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

import com.assignement.dto.AuthorDTO;
import com.assignement.model.Author;
import com.assignement.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin()
@RestController
//@RequestMapping("/api")
@Slf4j
public class AuthorController {
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/author")
	public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
		log.info("Get request is received to pick all authors");
		try {
			List<AuthorDTO> list = authorService.findAllAuthors();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			log.info("Get request is Completed to pick all authors");
			return new ResponseEntity<>(list, HttpStatus.OK);			
		} catch (Exception e) {
			log.info("Exception occured while fecting all authors {}", e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/author")
	public ResponseEntity<Author> saveAuthor(@RequestBody AuthorDTO author) {
		log.info("post request is received to save authors");
		try {
			log.info("post request is Completed to save authors");
			return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
		} catch (Exception e) {
			log.info("Exception occured while saving the resource {}",e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/author")
	public ResponseEntity<Author> updateAuthor(@RequestBody AuthorDTO author) {
		log.info("put request is received to update authors");
		try {
			log.info("put request is Completed to update authors");
			return new ResponseEntity<>(authorService.updateAuthor(author), HttpStatus.OK);
		} catch (Exception e) {
			log.info("exception occured while updating the resource {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/author/{id}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable Integer id) {
		log.info("delete request is received to delete authors");
		try {
			Optional<Author> author = authorService.findByIdAuthor(id);
			if (author.isPresent()) {
				authorService.deleteAuthor(author.get());
			}
			log.info("delete request is completed to delete authors");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.info("Exception occured while deleting the author {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/author/{id}")
	public ResponseEntity<AuthorDTO> findByAuthorId(@PathVariable Integer id) {
		log.info("get request is received to find specific authors");
		try {
			AuthorDTO author = authorService.findByAuthorId(id);
			if (author != null) {
				log.info("get request is completed to find the specific authors");
				return new ResponseEntity<>(author, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			log.info("exception occur while fecting the author {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
