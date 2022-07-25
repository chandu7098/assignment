package com.assignement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class BookDTO {
	private Integer bookId;
	private String title;
	private Double price;
	private Integer numberOfPages;
	private Integer authorId;
	private String authorName;
}
