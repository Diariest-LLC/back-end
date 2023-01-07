package com.diariest.server.database.postgre.models;

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
@Table(name = "diary_data")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String diaryId;
    private String ownerId;
    private String description;
    private String visibleName;
    private String nickName;
    private boolean verified;
    private Date createdAt;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "diary_category_ids")
    private List<CategoryIds> categoryIds;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "diary_diarists")
    private List<Diarist> diarists;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "diary_settings")
    private Set<Settings> settings;

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class Settings {

        private String test;

    }
    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class CategoryIds {

        private String categoryId;

    }

    @Embeddable
    @NoArgsConstructor
    @Data
    @Getter
    @Setter
    public static class Diarist {

        private String userId;
        private Date diaristAt;

    }

}
