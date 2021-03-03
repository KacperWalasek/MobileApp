package com.domowka.api.dto;

import com.domowka.api.model.Party;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PostPartyDTO {
    private String name;
    private float longitude;
    private float latitude;
    private String address;
    private Boolean isPublic;
    private UUID ownerId;

    public PostPartyDTO(@JsonProperty("name") String name,
                        @JsonProperty("longitude") float longitude, @JsonProperty("latitude") float latitude,
                        @JsonProperty("address") String address, @JsonProperty("public") Boolean isPublic,
                        @JsonProperty("ownerId") UUID ownerId) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.isPublic = isPublic;
        this.ownerId = ownerId;
    }
    @JsonIgnore
    public Party getParty(){
        return new Party(name,longitude,latitude,address,isPublic);
    }
    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public String getName() {
        return name;
    }

    public UUID getOwnerId() {
        return ownerId;
    }
}
