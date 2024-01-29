package com.dotori.backend.domain.book.controller;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dotori.backend.domain.book.model.dto.response.GetBookResponse;
import com.dotori.backend.domain.book.model.dto.response.GetBooksResponse;
import com.dotori.backend.domain.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	@GetMapping
	public ResponseEntity<GetBooksResponse> getBooks() {
		return new ResponseEntity<>(bookService.getBooks(), OK);
	}

	@GetMapping("/{bookId}")
	public ResponseEntity<GetBookResponse> getBook(@PathVariable Long bookId) {
		return new ResponseEntity<>(bookService.getBook(bookId), OK);
	}
}