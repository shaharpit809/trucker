package io.egen.service;

import io.egen.entity.Vehicle;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return (List<Vehicle>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Optional<Vehicle> existing = repository.findById(vin);
        if(!existing.isPresent()){
            throw new BadRequestException("Vehicle with id : " + vin + " not found.");
        }

        return existing.get();
    }

    @Transactional
    public Vehicle create(Vehicle veh) {
        return null;
    }

    @Transactional
    public List<Vehicle> update(List<Vehicle> vehicleList) {
        vehicleList.forEach(vehicle -> {
            if(!repository.findByVin(vehicle.getVin()).isPresent()){
                System.out.println("Creating a new entry for vehicle :" + vehicle.getVin());
            }
        });
        return (List<Vehicle>) repository.saveAll(vehicleList);
    }

    @Transactional
    public void delete(String vin) {
        Optional<Vehicle> existing = repository.findByVin(vin);
        if(!existing.isPresent()){
            throw new ResourceNotFoundException("Vehicle with id : " + vin + " doesn't exist.");
        }
        repository.delete(existing.get());
    }
}
