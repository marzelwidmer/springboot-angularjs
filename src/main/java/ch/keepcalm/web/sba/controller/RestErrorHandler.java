package ch.keepcalm.web.sba.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Created by marcelwidmer on 03/06/15.
 */
@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    private static Logger LOG = Logger.getLogger(RestErrorHandler.class);


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        LOG.error(ex);
        String bodyOfResponse = ex.getMessage();
        return new ResponseEntity("myOwnErrorMessage", headers, status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleException(final RuntimeException e, WebRequest request) {
        LOG.error(e);

        String bodyOfResponse = e.getMessage();
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}