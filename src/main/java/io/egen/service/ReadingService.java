package io.egen.service;

import io.egen.entity.Reading;

import java.util.List;

public interface ReadingService {
    List<Reading> findAll();

    Reading findOne(String rid);

    Reading create(Reading r);

    Reading update(String rid, Reading r);

    void delete(String rid);
}
