package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.domain.LoggingStore;
import ch.keepcalm.web.sba.repository.LoggingStoreRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by marcelwidmer on 25/05/15.
 */
@RestController
@RequestMapping("/log")
public class LoggingRestController {

    @Autowired
    private LoggingStoreRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity log(@Valid @RequestBody LoggingStore loggingStore) {
        repository.saveAndFlush(loggingStore);
        return new ResponseEntity(loggingStore.getId(), HttpStatus.CREATED);
    }


    @JsonSerialize
    private class EmptyJsonResponse  {
    }


}
