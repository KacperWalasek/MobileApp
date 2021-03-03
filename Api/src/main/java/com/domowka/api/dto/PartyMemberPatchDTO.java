package com.domowka.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartyMemberPatchDTO {
    private String role;

    public PartyMemberPatchDTO(@JsonProperty("role") String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
