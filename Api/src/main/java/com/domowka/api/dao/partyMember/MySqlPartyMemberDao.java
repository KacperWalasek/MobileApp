package com.domowka.api.dao.partyMember;

import com.domowka.api.model.Party;
import com.domowka.api.model.PartyMember;
import com.domowka.api.repository.PartyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mySqlPartyMemberDao")
public class MySqlPartyMemberDao implements PartyMemberDao{
    @Autowired
    private PartyMemberRepository partyMemberRepository;

    @Override
    public int insertMember(PartyMember member) {
        partyMemberRepository.save(member);
        return 0;
    }

    @Override
    public Iterable<PartyMember> getAllMembers() {
        return partyMemberRepository.findAll();
    }

    @Override
    public void deleteByParty(UUID partyId) {
        partyMemberRepository.deleteByParty_Id(partyId);
    }

    @Override
    public void delete(UUID partyId, UUID userId) {
        partyMemberRepository.deleteByParty_IdAndUser_Id(partyId, userId);
    }

    @Override
    public List<PartyMember> getByParty(UUID partyId) {
        return partyMemberRepository.findByParty_Id(partyId);
    }

    @Override
    public List<PartyMember> getByUser(UUID userId) { return partyMemberRepository.findByUser_Id(userId); }

    @Override
    public PartyMember addMember(PartyMember member) {
        return partyMemberRepository.save(member);
    }

    @Override
    public Optional<PartyMember> getMember(UUID partyId, UUID userId) {
        return partyMemberRepository.findByParty_IdAndUser_Id(partyId, userId);
    }

    @Override
    public Optional<PartyMember> changeRole(UUID partyId, UUID userId, String role) {
        Optional<PartyMember> memberOpt = partyMemberRepository.findByParty_IdAndUser_Id(partyId, userId);
        if(memberOpt.isEmpty())
            return Optional.empty();
        PartyMember member = memberOpt.get();
        member.setRole(role);
        partyMemberRepository.save(member);
        return Optional.of(member);
    }


}
