package com.wedul.hibernate_test.study.generated;

import com.wedul.hibernate_test.study.generated.dto.Event;
import com.wedul.hibernate_test.study.generated.dto.Person;
import com.wedul.hibernate_test.study.generated.service.GeneratedService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GeneratedServiceTest {

    @Autowired
    private GeneratedService generatedService;

    @Autowired
    private EntityManager entityManager;

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
