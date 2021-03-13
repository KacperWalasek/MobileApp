package com.domowka.api.repository;

import com.domowka.api.model.PartyMember;
import com.domowka.api.model.PartyMemberId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PartyMemberRepository extends CrudRepository<PartyMember, PartyMemberId> {
    List<PartyMember> findByParty_Id(UUID id);
    List<PartyMember> findByUser_Id(UUID id);
    void deleteByParty_Id(UUID id);
    void deleteByParty_IdAndUser_Id(UUID partyId, UUID userId);
    Optional<PartyMember> findByParty_IdAndUser_Id(UUID partyId, UUID userId);
}

