package com.diariest.server.database.services.cassandra;

import com.diariest.server.database.repositories.cassandra.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    public AccountRepository accountRepository;

}
