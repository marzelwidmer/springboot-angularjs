package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.domain.LogEntity;
import ch.keepcalm.web.sba.repository.LogRepository;
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
public class LogRestController {

    @Autowired
    private LogRepository repository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity log(@Valid @RequestBody  LogEntity logEntity) {
        repository.saveAndFlush(logEntity);
        return new ResponseEntity(logEntity.getId(), HttpStatus.CREATED);
    }


    @JsonSerialize
    private class EmptyJsonResponse  {
    }


}
