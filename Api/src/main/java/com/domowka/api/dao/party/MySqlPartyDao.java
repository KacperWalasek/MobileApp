package com.domowka.api.dao.party;

import com.domowka.api.model.Party;
import com.domowka.api.model.User;
import com.domowka.api.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("mySqlPartyDao")
public class MySqlPartyDao implements PartyDao{

    @Autowired
    private PartyRepository partyRepository;

    @Override
    public Party insertParty(Party party) {
        return partyRepository.save(party);
    }

    @Override
    public Iterable<Party> getAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public Optional<Party> getParty(UUID id) {
        return partyRepository.findById(id);
    }

    @Override
    public Optional<Party> updateParty(UUID id, Party party) {
        Optional<Party> oldPartyOpt = partyRepository.findById(id);
        if(oldPartyOpt.isEmpty())
            return Optional.empty();
        Party oldParty = oldPartyOpt.get();
        oldParty.setDetails(party);
        return Optional.of(partyRepository.save(oldParty));
    }

    @Override
    public void deleteParty(UUID id) {
        partyRepository.deleteById(id);
    }
}
