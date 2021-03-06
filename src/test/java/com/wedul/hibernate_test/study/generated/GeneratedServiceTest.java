package com.wedul.hibernate_test.study.generated;

import com.wedul.hibernate_test.study.generated.dto.Account;
import com.wedul.hibernate_test.study.generated.dto.Employee;
import com.wedul.hibernate_test.study.generated.dto.Event;
import com.wedul.hibernate_test.study.generated.dto.Person;
import com.wedul.hibernate_test.study.generated.service.GeneratedService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GeneratedServiceTest {

    @Autowired
    private GeneratedService generatedService;

    @Test
    @DisplayName("CreationTimestamp와 UpdateTimestamp 기능 테스트")
    void timestamp_annotaion_test() {
        // given
        Event event = new Event();
        event.setName("wedul");

        // when
        event = updateEvent(event);

        // then
        assertThat(event.getTimestamp()).isBefore(event.getUpdatedOn());
    }

    @Transactional
    Event updateEvent(Event event) {
        event = generatedService.event(event);
        event.setName("cho");
        event = generatedService.event(event);
        return event;
    }

    @Test
    @DisplayName("컬럼 트랜스포머 테스트")
    void column_trans_former_test() {

        // given
        String password = "wedul";
        Employee employee = Employee.builder()
            .password(password)
            .accessLevel(1)
            .build();

        // when
        employee = generatedService.employee(employee);
        employee = generatedService.getEmployee(employee.getId());

        // then
        assertThat(employee.getPassword()).isEqualTo(password);
    }

    @Test
    @DisplayName("@Generated 컬럼 동작 테스트")
    void generated_annotation_test() {
        // given
        Person person = new Person();
        person.setFirstName("we");
        person.setLastName("dul");
        person.setMiddleName1("1");
        person.setMiddleName2("2");
        person.setMiddleName3("3");
        person.setMiddleName4("4");
        person.setMiddleName5("5");

        // when
        person = generatedService.person(person);

        // then
        assertThat(person.getFullName()).isEqualTo(fullName(person));
    }

    @Test
    @DisplayName("@Formular Test")
    void formular_test() {
        // given
        double credit = 123.0;
        double rate = 1.2;

        Account account = new Account();
        account.setCredit(credit);
        account.setRate(rate);

        // when
        account = generatedService.account(account);
        account = generatedService.getAccount(account.getId());

        // then
        assertThat(account.getInterest()).isEqualTo(credit * rate);
    }

    private String fullName(Person person) {
        return coalesce(person.getFirstName(), "")
            + coalesce(" " + person.getMiddleName1(), "")
            + coalesce(" " + person.getMiddleName2(), "")
            + coalesce(" " + person.getMiddleName3(), "")
            + coalesce(" " + person.getMiddleName4(), "")
            + coalesce(" " + person.getMiddleName5(), "")
            + coalesce(" " + person.getLastName(), "");
    }

    private String coalesce(String input, String defaultStr) {
        return StringUtils.isBlank(input) ? defaultStr : input;
    }

}
