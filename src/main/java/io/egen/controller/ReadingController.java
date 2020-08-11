package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readings")
@CrossOrigin(origins = {"http://mocker.ennate.academy", "http://mocker.egen.io", "*"})
public class ReadingController {

    @Autowired
    ReadingService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reading> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Reading findOne(@PathVariable("id") String rid){
        return service.findOne(rid);
    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Reading create(@RequestBody Reading r){
        return service.create(r);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Reading update(@PathVariable("id") String rid, @RequestBody Reading r){
        return service.update(rid, r);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") String rid){
        service.delete(rid);
    }
}
