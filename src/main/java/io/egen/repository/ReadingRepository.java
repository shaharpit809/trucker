package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.data.repository.CrudRepository;

public interface ReadingRepository extends CrudRepository<Reading, String> {
}
