package io.egen.service;

import io.egen.entity.Reading;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    ReadingRepository repository;

    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return (List<Reading>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Reading findOne(String rid) {
        Optional<Reading> existing = repository.findById(rid);
        if(!existing.isPresent()){
            throw new BadRequestException("Reading with id : " + rid + " not found.");
        }
        return existing.get();
    }

    @Transactional
    public Reading create(Reading r) {
        Optional<Reading> existing = repository.findById(r.getRid());
        if(existing.isPresent()){
            throw new BadRequestException("Reading with id : " + r.getRid() + " already exists.");
        }
        return repository.save(r);
    }

    @Transactional
    public Reading update(String rid, Reading r) {
        Optional<Reading> existing = repository.findById(rid);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Reading with id : " + rid + " doesn't exists.");
        }
        return repository.save(r);
    }

    @Transactional
    public void delete(String rid) {
        Optional<Reading> existing = repository.findById(rid);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Reading with id : " + rid + " doesn't exists.");
        }
        repository.delete(existing.get());
    }
}
