
package com.example.si;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    private Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    public String retrieveABookById(Long id){
        LOG.info("BookService retrieveABookById method");

        return "you did it!!";
    }
}



