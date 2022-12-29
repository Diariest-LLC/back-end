package com.diariest.server.database.models.postgre;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String user_id;
    private String token_id;
    private String password;
    private boolean verified;
    private long created_at;
    private long birth_date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_macaddress")
    private Set<MacAddress> mac_ids;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_settings")
    private Set<Settings> settings;

    public MacAddress hasSavedMacID(String mac_id) {
        return mac_ids.stream().filter(data -> data.getMac_id().equals(mac_id)).findFirst().orElse(null);
    }

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class MacAddress {

        private String mac_id;
        private long saved_at;

    }

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class Settings {

        private String description;
        private String visible_name;
        private String nick_name;
        private boolean public_account;

    }

}
