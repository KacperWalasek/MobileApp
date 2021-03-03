package com.domowka.api.dao.party;

import com.domowka.api.model.Party;


import java.util.Optional;
import java.util.UUID;

public interface PartyDao {
    Party insertParty(Party party);
    Iterable<Party> getAllParties();
    Optional<Party> getParty(UUID id);
    Optional<Party> updateParty(UUID id, Party party);
    void deleteParty(UUID id);
}
