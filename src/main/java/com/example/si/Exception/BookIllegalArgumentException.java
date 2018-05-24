/*
 * (c) Copyright 2017 Brite:Bill Ltd.
 *
 * 7 Grand Canal Street Lower, Dublin 2, Ireland
 * info@britebill.com
 * +353 1 661 9426
 */
package com.example.si.Exception;

public class BookIllegalArgumentException extends RuntimeException {

    /**
     *
     * @param message
     */
    public BookIllegalArgumentException(String message) {
        super(message);
    }
}
