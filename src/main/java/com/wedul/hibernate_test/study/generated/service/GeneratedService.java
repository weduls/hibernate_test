package com.wedul.hibernate_test.study.generated.service;

import com.wedul.hibernate_test.study.generated.dao.PersonRepository;
import com.wedul.hibernate_test.study.generated.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Person person(Person person) {
        return personRepository.save(person);
    }

}
