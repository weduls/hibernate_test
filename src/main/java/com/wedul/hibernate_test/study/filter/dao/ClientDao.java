package com.wedul.hibernate_test.study.filter.dao;

import com.wedul.hibernate_test.study.filter.dto.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {
}
