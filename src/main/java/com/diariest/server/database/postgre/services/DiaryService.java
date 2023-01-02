package com.diariest.server.database.postgre.services;

import com.diariest.server.database.postgre.models.Diary;
import com.diariest.server.database.postgre.repositories.DiaryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public void saveDiary(Diary diary) {
        diaryRepository.save(diary);
    }

}
