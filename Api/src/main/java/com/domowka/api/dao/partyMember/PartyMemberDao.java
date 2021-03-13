package com.domowka.api.dao.partyMember;

import com.domowka.api.model.PartyMember;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface PartyMemberDao {
    int insertMember(PartyMember member);
    Iterable<PartyMember> getAllMembers();
    void deleteByParty(UUID partyId);
    void delete(UUID partyId, UUID userId);
    List<PartyMember> getByParty(UUID partyId);
    List<PartyMember> getByUser(UUID userId);
    PartyMember addMember(PartyMember member);
    Optional<PartyMember> getMember(UUID partyId, UUID userId);
    Optional<PartyMember> changeRole(UUID partyId, UUID userId, String role);
}
