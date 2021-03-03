package com.domowka.api.model;

import java.io.Serializable;
import java.util.UUID;

public class PartyMemberId implements Serializable {
    private UUID userId;
    private UUID partyId;

    public PartyMemberId(UUID userId, UUID partyId) {
        this.userId = userId;
        this.partyId = partyId;
    }
}
