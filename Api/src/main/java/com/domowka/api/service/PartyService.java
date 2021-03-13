package com.domowka.api.service;

import com.domowka.api.dao.party.PartyDao;
import com.domowka.api.dao.partyMember.PartyMemberDao;
import com.domowka.api.dto.PartyMemberDTO;
import com.domowka.api.dto.PostPartyDTO;
import com.domowka.api.model.Party;
import com.domowka.api.model.PartyMember;
import com.domowka.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartyService {
    private final PartyDao partyDao;
    private final PartyMemberDao partyMemberDao;
    private final UserService userService;
    @Autowired
    public PartyService(@Qualifier("mySqlPartyDao") PartyDao partyDao, @Qualifier("mySqlPartyMemberDao") PartyMemberDao partyMemberDao, UserService userService) {
        this.partyDao = partyDao;
        this.partyMemberDao = partyMemberDao;
        this.userService = userService;
    }
    public int insertParty(PostPartyDTO party){
        Optional<User> owner = userService.getUser(party.getOwnerId());
        if(owner.isEmpty())
            return -1;
        Party newParty = partyDao.insertParty(party.getParty());
        partyMemberDao.insertMember(new PartyMember("Admin", newParty, owner.get()));
        return 0;
    }
    public Iterable<Party> getAllParties(){
        return partyDao.getAllParties();
    }
    public Iterable<PartyMember> getAllPartyMembers() { return partyMemberDao.getAllMembers(); }
    public Optional<Party> getParty(UUID id){ return partyDao.getParty(id); }
    @Transactional
    public void deleteParty(UUID id){
        partyMemberDao.deleteByParty(id);
        partyDao.deleteParty(id);
    }
    public Optional<Party> updateParty(UUID id, Party party){ return partyDao.updateParty(id, party); }
    public List<PartyMember> getMembers(UUID partyId){ return partyMemberDao.getByParty(partyId); }
    public Optional<PartyMember> addMember(PartyMemberDTO member) {
        Optional<Party> p = partyDao.getParty(member.getPartyId());
        Optional<User> u = userService.getUser(member.getUserId());
        if(p.isEmpty() || u.isEmpty())
            return Optional.empty();
        return Optional.of(partyMemberDao.addMember(new PartyMember(member.getRole(), p.get(), u.get())));
    }
    @Transactional
    public void deleteMember(UUID partyId, UUID userId) {
        partyMemberDao.delete(partyId, userId);
    }
    public Optional<PartyMember> getMember(UUID partyId, UUID userId){
        return partyMemberDao.getMember(partyId, userId);
    }
    public Optional<PartyMember> changeRole(UUID partyId, UUID userId, String role){
        return partyMemberDao.changeRole(partyId,userId,role);
    }
}
