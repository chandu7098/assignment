package com.assignement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignement.dto.AuthorDTO;
import com.assignement.model.Address;
import com.assignement.model.Author;
import com.assignement.repo.AuthorRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorService {

	@Autowired
	AuthorRepo authorRepo;

	public List<AuthorDTO> findAllAuthors() {
		log.info("fetching all authors from service layer");
		List<Author> authors =  authorRepo.findAll();
		List<AuthorDTO> authorDTOs = new ArrayList<>();
		if(authors != null && !authors.isEmpty()) {
			for(Author author : authors) {
				authorDTOs.add(AuthorDTO.builder()
						.authorId(author.getAuthorId())
						.firstName(author.getFirstName())
						.lastName(author.getLastName())
						.email(author.getEmail())
						.phoneNumber(author.getPhoneNumber())
						.addressId(author.getAddress().getAddressId())
						.address1(author.getAddress().getAddress1())
						.address2(author.getAddress().getAddress2())
						.city(author.getAddress().getCity())
						.state(author.getAddress().getState())
						.zipcode(author.getAddress().getZipcode())
						.build());

			}
		}
		return authorDTOs;
	}

	public Author saveAuthor(AuthorDTO authorDto) {
		log.info("saving authors from service layer");
		Author author  = Author.builder()

				.firstName(authorDto.getFirstName())
				.lastName(authorDto.getLastName())
				.email(authorDto.getEmail())
				.phoneNumber(authorDto.getPhoneNumber())
				.address(Address.builder()

						.address1(authorDto.getAddress1())
						.address2(authorDto.getAddress2())
						.city(authorDto.getCity())
						.state(authorDto.getState())
						.zipcode(authorDto.getZipcode())
						.build())
				.build();
		return authorRepo.save(author);
	}

	public Optional<Author> findByIdAuthor(Integer id) {
		log.info("finding the authors from service layer");
		return authorRepo.findById(id);
	}

	public AuthorDTO findByAuthorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Author>  optionalAuthor = authorRepo.findById(id);
		if(optionalAuthor.isPresent()) {
			Author author = optionalAuthor.get();
			return AuthorDTO.builder()
					.authorId(author.getAuthorId())
					.firstName(author.getFirstName())
					.lastName(author.getLastName())
					.email(author.getEmail())
					.phoneNumber(author.getPhoneNumber())
					.addressId(author.getAddress().getAddressId())
					.address1(author.getAddress().getAddress1())
					.address2(author.getAddress().getAddress2())
					.city(author.getAddress().getCity())
					.state(author.getAddress().getState())
					.zipcode(author.getAddress().getZipcode())
					.build();
		}

		return null;

	}


	public void deleteAuthor(Author author) {
		log.info("deleting the author from service layer");
		authorRepo.delete(author);

	}

	public Author updateAuthor(AuthorDTO authorDto) {
		Author author  = Author.builder()
				.authorId(authorDto.getAuthorId())
				.firstName(authorDto.getFirstName())
				.lastName(authorDto.getLastName())
				.email(authorDto.getEmail())
				.phoneNumber(authorDto.getPhoneNumber())
				.address(Address.builder()
						.addressId(authorDto.getAddressId())
						.address1(authorDto.getAddress1())
						.address2(authorDto.getAddress2())
						.city(authorDto.getCity())
						.state(authorDto.getState())
						.zipcode(authorDto.getZipcode())
						.build())
				.build();
		return authorRepo.save(author);
	}



}
