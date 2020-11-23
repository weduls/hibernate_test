package com.wedul.hibernate_test.study.filter.dao;

import com.wedul.hibernate_test.study.filter.dto.ClientAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountDao extends JpaRepository<ClientAccount, Long> {
}
