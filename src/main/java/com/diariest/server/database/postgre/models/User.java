package com.diariest.server.database.postgre.models;

import com.diariest.server.utils.UtilTime;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userId;
    private String tokenId;
    private String nickName;
    private String email;
    private String phoneNumber;
    private String password;
    private String description;
    private String visibleName;
    private boolean verified;
    private Date createdAt;
    private Date birthDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_macaddress")
    private List<MacAddress> macIds;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_settings")
    private Set<Settings> settings;

    public MacAddress hasSavedMacId(String macId) {
        return this.macIds.stream().filter(data -> data.getMacId().equals(macId)).findFirst().orElse(null);
    }

    public void addSavedMacId(String macId) {
        if(this.hasSavedMacId(macId) != null) return;

        MacAddress macAddress = new MacAddress();
        macAddress.setMacId(macId);
        macAddress.setSavedAt(UtilTime.convertToDate(System.currentTimeMillis()));

        this.macIds.add(macAddress);
    }

    public Settings getSettings() {
        return this.settings.stream().iterator().next();
    }

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class MacAddress {

        private String macId;
        private Date savedAt;

    }

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class Settings {

        private String test;

    }

}
