package io.egen.service;

import io.egen.entity.Alert;
import java.util.List;

public interface AlertService {
    List<Alert> findAll();

    Alert create(Alert alert);

    List<Alert> findAlertsByVin(String vin);

    List<Alert> findAlertsByPriority(String priority);
}
