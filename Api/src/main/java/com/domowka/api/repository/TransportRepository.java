package com.domowka.api.repository;

import com.domowka.api.model.Transport;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TransportRepository extends CrudRepository<Transport, UUID> {
}
