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

/**
 * Created by marcelwidmer on 25/05/15.
 */
@RestController
@RequestMapping("/api/log")
public class LogRestController {

    @Autowired
    private LogRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity log(@RequestBody LogEntity log) {
        // TODO evtl. call over service layert ?
        this.repository.saveAndFlush(log);
        return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
    }


    @JsonSerialize
    private class EmptyJsonResponse  {
    }
}
