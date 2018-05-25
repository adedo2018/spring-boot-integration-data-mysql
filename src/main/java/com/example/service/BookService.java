
package com.example.service;

import com.example.persistence.repository.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.persistence.model.Book;

import java.util.Optional;

import javax.annotation.PostConstruct;

@Service
public class BookService {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @PostConstruct
    void init() {
        bookRepository.deleteAll();
        Book book = new Book();
        book.setTitle("Java 9");
        book.setType("hardback");
        book.setGenre("technology");
        book.setFirstName("Mark");
        book.setLastName("Stain");
        bookRepository.save(book);

        bookRepository.findAll().forEach(name -> System.out.println(book));
    }

}
