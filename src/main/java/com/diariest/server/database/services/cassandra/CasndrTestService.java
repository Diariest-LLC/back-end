package com.diariest.server.database.services.cassandra;

import com.diariest.server.database.models.cassandra.csndrtest;
import com.diariest.server.database.repositories.cassandra.CasndrTestRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class CasndrTestService {

    @Autowired
    public CasndrTestRepository casndrTestRepository;

    //TODO algorithm methods.

    public void saveAccount(csndrtest user) {
        casndrTestRepository.save(user);
    }

}
