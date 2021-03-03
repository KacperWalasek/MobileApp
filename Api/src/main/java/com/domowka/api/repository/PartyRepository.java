package com.domowka.api.repository;

import com.domowka.api.model.Party;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PartyRepository extends CrudRepository<Party, UUID> {
}
