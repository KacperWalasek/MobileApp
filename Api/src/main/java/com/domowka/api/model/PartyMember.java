package com.domowka.api.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@IdClass(PartyMemberId.class)
public class PartyMember {
//    @Id
//    @Type(type = "uuid-char")
//    private UUID userId;
//    @Id
//    private UUID partyId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    private String role;
    @ManyToOne
    @JoinColumn(name="party_id")
    private Party party;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    public PartyMember(){};
    public PartyMember(UUID id, String role, Party party, User user) {
        this.id = id;
        this.role = role;
        this.party = party;
        this.user = user;
    }
    public PartyMember( String role, Party party, User user) {
        this(new UUID(0,0),role,party,user);
    }

    public String getRole() {
        return role;
    }

    public UUID getUserId() {
        return user.getId();
    }
    public UUID getPartyId(){
        return party.getId();
    }

    public void setRole(String role) {
        this.role = role;
    }
}
