package com.domowka.api.api;

import com.domowka.api.dao.party.PartyDao;
import com.domowka.api.dto.PartyMemberDTO;
import com.domowka.api.dto.PartyMemberPatchDTO;
import com.domowka.api.dto.PostPartyDTO;
import com.domowka.api.model.Party;
import com.domowka.api.model.PartyMember;
import com.domowka.api.model.User;
import com.domowka.api.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/party")
@RestController
public class PartyController {
    private final PartyService service;

    @Autowired
    public PartyController(PartyService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Party> getAllParties(){
        return service.getAllParties();
    }
    @PostMapping
    public void addParty(@RequestBody PostPartyDTO party){
        service.insertParty(party);
    }
    //Admin only
    @GetMapping(path = "/members")
    public Iterable<PartyMember> getAllMembers(){
        return service.getAllPartyMembers();
    }
    @GetMapping(path = "{id}")
    public Party getPartyById(@PathVariable("id") UUID id){
        Optional<Party> party = service.getParty(id);
        if(party.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no party with such id in database");
        return party.get();
    }
    @PutMapping(path = "{id}")
    public void updateParty(@PathVariable("id") UUID id, @RequestBody Party party){ service.updateParty(id,party);}
    @DeleteMapping(path = "{id}")
    public void deleteParty(@PathVariable("id")UUID id){ service.deleteParty(id);}
    @PostMapping(path = "/member")
    public PartyMember addMember(@RequestBody PartyMemberDTO member){
        Optional<PartyMember> pm = service.addMember(member);
        if(pm.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no party or user with such id in database");
        return pm.get();
    }
    @GetMapping(path = "/member/{id}")
    public Iterable<PartyMember> getMembers(@PathVariable("id") UUID partyId){return service.getMembers(partyId); }
    @DeleteMapping(path = "/member")
    public void deleteMember(@RequestParam UUID partyId, @RequestParam UUID userId)
    {
        service.deleteMember(partyId, userId);
    }
    @GetMapping(path = "/member")
    public PartyMember getMember(@RequestParam UUID partyId, @RequestParam UUID userId){
        Optional<PartyMember> member = service.getMember(partyId,userId);
        if(member.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no party or user with such id in database");
        return member.get();
    }
    @PatchMapping(path = "/member")
    public PartyMember patchMember(@RequestParam UUID partyId, @RequestParam UUID userId, @RequestBody PartyMemberPatchDTO patchDTO){
        Optional<PartyMember> memberOpt = service.changeRole(partyId, userId, patchDTO.getRole());
        if(memberOpt.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no party or user with such id in database");
        return memberOpt.get();
    }

}
