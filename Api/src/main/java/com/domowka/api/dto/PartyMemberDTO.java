package com.domowka.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PartyMemberDTO {
    private UUID userId;
    private UUID partyId;
    private String role;

    public PartyMemberDTO(@JsonProperty("userId") UUID userId, @JsonProperty("partyId") UUID partyId, @JsonProperty("role") String role) {
        this.userId = userId;
        this.partyId = partyId;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public UUID getPartyId() {
        return partyId;
    }

    public UUID getUserId() {
        return userId;
    }
}
