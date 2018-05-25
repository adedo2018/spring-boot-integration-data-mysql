package com.example.controller;


import com.example.service.BookService;
import com.example.Exception.handler.BookParametersValidator;
import com.example.Exception.handler.ParametersValidatorErrorMessages;
import com.example.header.SampleMessageHeaderAccessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import com.example.persistence.model.Book;

import java.util.Optional;

@Component
public class BookController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private static final String HTTP_HEADER_STATUS = "http_statusCode";

	@Autowired
	BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@ServiceActivator
	public Message<Book> get(@Header(SampleMessageHeaderAccessor.BOOK_ID) String bookId) {
		log.info("Book GET method");

		BookParametersValidator.validateLongParameterForNonNull(bookId, ParametersValidatorErrorMessages.INVALID_BOOK_ID.getDescription());

		Optional<Book> retrieveBook = bookService.findById(Long.parseLong(bookId));

		if(retrieveBook.isPresent()){
			log.info(" book retrieved : "+retrieveBook.get());
			return MessageBuilder.withPayload(retrieveBook.get()).setHeader(HTTP_HEADER_STATUS, HttpStatus.OK).build();
		}else{
			return MessageBuilder.withPayload(new Book()).setHeader(HTTP_HEADER_STATUS, HttpStatus.NOT_FOUND).build();
		}
       }

}
