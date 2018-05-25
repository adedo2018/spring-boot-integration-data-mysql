
package com.example.Exception.handler;


import com.example.Exception.BookIllegalArgumentException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BookParametersValidator {

    private static Log LOG = LogFactory.getLog(BookParametersValidator.class);

    private BookParametersValidator(){}

    public static long validateLongParameterForNonNull(String stringNumber, String message){

        LOG.info("BookParametersValidator validateLongParameterForNonNull method");

        if(StringUtils.isBlank(stringNumber)){
            LOG.error(message);
            throw new BookIllegalArgumentException(message);
        }

        long longNumber;
        try {
            longNumber = Long.parseLong(stringNumber);
        }catch(NumberFormatException e){
            throw new BookIllegalArgumentException(message);
        }

        return longNumber;
    }

}

