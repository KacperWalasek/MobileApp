package com.domowka.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private float longitude;
    private float latitude;
    private String address;
    private Boolean isPublic;

    @OneToMany(mappedBy = "party")
    private List<PartyMember> members;

    public Party(){};
    public Party(@JsonProperty("id") UUID id, @JsonProperty("name") String name,
                 @JsonProperty("longitude") float longitude, @JsonProperty("latitude") float latitude,
                 @JsonProperty("address") String address, @JsonProperty("public") Boolean isPublic) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.isPublic = isPublic;
    }
    public Party(String name, float longitude, float latitude, String address, Boolean isPublic){
        this(new UUID(0,0),name,longitude,latitude,address,isPublic);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getPublic() {
        return isPublic;
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
    public void setDetails(Party party){
        name = party.name;
        longitude = party.longitude;
        latitude = party.latitude;
        address = party.address;
        isPublic = party.isPublic;
    }
    @JsonIgnore
    public List<PartyMember> getMembers() {
        return members;
    }
}
