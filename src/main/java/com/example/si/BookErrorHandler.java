
package com.example.si;

import static org.springframework.integration.support.MessageBuilder.withPayload;


import com.example.si.Exception.BookIllegalArgumentException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.http.HttpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.ErrorMessage;

import java.util.Optional;


public class BookErrorHandler {
    private static final Log LOG = LogFactory.getLog(BookErrorHandler.class);


    @ServiceActivator
    public Message<String> bookErrorTranslator(ErrorMessage message) {

        final Throwable cause = Optional.ofNullable(message.getPayload().getCause()).orElse(message.getPayload());
        final String causeMessage = cause.getLocalizedMessage();
        return createResponse(causeMessage, returnHttpStatusCode(cause));
    }

    private Message<String> createResponse(final String causeMessage, final HttpStatus httpStatus) {
        return withPayload(causeMessage).setHeader(HttpHeaders.STATUS_CODE, httpStatus.value()).build();
    }

    private HttpStatus returnHttpStatusCode(Throwable cause){
        if (cause instanceof BookIllegalArgumentException){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}