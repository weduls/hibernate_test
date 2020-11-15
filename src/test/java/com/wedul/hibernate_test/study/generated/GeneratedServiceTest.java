package com.wedul.hibernate_test.study.generated;

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
public class PersonServiceTest {

    @Autowired
    private GeneratedService personService;

    @Test
    @DisplayName("@Generated 동작 테스트")
    @Transactional
    void generated_annotation_test() {

        Person person = new Person();
        person.setFirstName("we");
        person.setLastName("dul");
        person.setMiddleName1("1");
        person.setMiddleName2("2");
        person.setMiddleName3("3");
        person.setMiddleName4("4");
        person.setMiddleName5("5");

        person = personService.person(person);

        System.out.println(fullName(person));
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
