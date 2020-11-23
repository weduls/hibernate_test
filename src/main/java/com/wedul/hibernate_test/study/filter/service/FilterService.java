package com.wedul.hibernate_test.study.filter.service;

import com.wedul.hibernate_test.study.filter.dao.ClientAccountDao;
import com.wedul.hibernate_test.study.filter.dao.ClientDao;
import com.wedul.hibernate_test.study.filter.dto.ClientAccount;
import com.wedul.hibernate_test.study.filter.dto.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final ClientDao clientDao;
    private final ClientAccountDao accountDao;

    @Transactional
    public Client client(Client client) {
        return clientDao.save(client);
    }

    @Transactional
    public ClientAccount account(ClientAccount account) {
        return accountDao.save(account);
    }

    @Transactional
    public Client getClient(Long id) {
        return clientDao.findById(id).orElse(null);
    }

}
