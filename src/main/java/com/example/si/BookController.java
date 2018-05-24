package com.example.si;


import com.example.si.header.SampleMessageHeaderAccessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class BookController {
	private Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private static final String HTTP_HEADER_STATUS = "http_statusCode";
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@ServiceActivator
	public Message<String> get(@Header(SampleMessageHeaderAccessor.BOOK_ID) String bookId) {
		log.info("Book GET method");

		BookParametersValidator.validateLongParameterForNonNull(bookId, ParametersValidatorErrorMessages.INVALID_BOOK_ID.getDescription());

		String retrieveBook = bookService.retrieveABookById(Long.parseLong(bookId));

       return MessageBuilder
           .withPayload(retrieveBook).setHeader(HTTP_HEADER_STATUS, HttpStatus.OK).build();
	}

}
