package com.diariest.server.database.postgre.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private String password;
    private boolean verified;
    private Timestamp createdAt;
    private Timestamp birthDate;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_macaddress")
    private List<MacAddress> macIds;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_settings")
    private Set<Settings> settings;

    public MacAddress hasSavedMacID(String mac_id) {
        return macIds.stream().filter(data -> data.getMacId().equals(mac_id)).findFirst().orElse(null);
    }

    public Settings getSettings() {
        return settings.stream().findFirst().get();
    }

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class MacAddress {

        private String macId;
        private Timestamp savedAt;

    }

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class Settings {

        private String description;
        private String visibleName;
        private String nickName;

    }

}
