package com.wedul.hibernate_test.study.filter.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Client {

    @Id
    private Long id;

    private String name;

    @Where( clause = "account_type = 'DEBIT'")
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<ClientAccount> debitAccounts = new ArrayList<>( );

    @Where( clause = "account_type = 'CREDIT'")
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<ClientAccount> creditAccounts = new ArrayList<>( );

}