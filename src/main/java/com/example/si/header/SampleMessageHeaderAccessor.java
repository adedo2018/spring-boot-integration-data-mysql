
package com.example.si.header;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;

public class SampleMessageHeaderAccessor extends IntegrationMessageHeaderAccessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleMessageHeaderAccessor.class);


    public static final String BOOK_ID = "BOOK_ID";

    public SampleMessageHeaderAccessor(Message<?> message) {
        super(message);
    }

    public String getBookId() {

        LOGGER.info("SampleMessageHeaderAccessor getBookId method");
        return getHeader(BOOK_ID).toString();
    }

}
