package com.wedul.hibernate_test.study.filter;

import com.wedul.hibernate_test.study.filter.dto.ClientAccount;
import com.wedul.hibernate_test.study.filter.dto.AccountType;
import com.wedul.hibernate_test.study.filter.dto.Client;
import com.wedul.hibernate_test.study.filter.service.FilterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FilterServiceTest {

    @Autowired
    private FilterService filterService;

    @Test
    @DisplayName("Where 애노테이션")
    void where_annotation_test() {
        // given
        Long clientId = 1L;

        Client client = new Client();
        client.setId(clientId);
        client.setName("wedul");

        ClientAccount account1 = new ClientAccount();
        account1.setType(AccountType.CREDIT);
        account1.setClient(client);
        account1.setAmount(100d);
        account1.setRate(2d);

        ClientAccount account2 = new ClientAccount();
        account2.setType(AccountType.DEBIT);
        account2.setClient(client);
        account2.setAmount(200d);
        account2.setRate(5d);

        // when
        filterService.client(client);
        filterService.account(account1);
        filterService.account(account2);
        Client result = filterService.getClient(clientId);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getCreditAccounts()).isNotEmpty();
        assertThat(result.getDebitAccounts()).isNotEmpty();
        assertThat(result.getCreditAccounts().stream().map(ClientAccount::getType).collect(toSet())).containsOnly(AccountType.CREDIT);
        assertThat(result.getDebitAccounts().stream().map(ClientAccount::getType).collect(toSet())).containsOnly(AccountType.DEBIT);
    }

}
