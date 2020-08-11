package io.egen.service;

import io.egen.entity.Alert;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepository repository;

    @Transactional(readOnly = true)
    public List<Alert> findAll() {
        return (List<Alert>) repository.findAll();
    }

    @Transactional
    public Alert create(Alert alert) {
        return repository.save(alert);
    }

    @Transactional
    public List<Alert> findAlertsByVin(String vin) {
        List<Alert> existing = repository.findByVin(vin);
        if(existing.isEmpty()){
            throw new ResourceNotFoundException("Alerts for vehicle with id : " + vin + " not found.");
        }
        return existing;
    }

    @Transactional
    public List<Alert> findAlertsByPriority(String priority) {
        List<Alert> existing = repository.findByPriority(priority);
        if(existing.isEmpty()){
            throw new ResourceNotFoundException("Alerts with " + priority + " priority now found.");
        }
        return existing;
    }
}
