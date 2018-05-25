package com.example.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.persistence.model.Book;

/**
 * @author Fred Assi
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

  Book findById(long id);
}
