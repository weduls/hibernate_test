package com.wedul.hibernate_test.study.generated.service;

import com.wedul.hibernate_test.study.generated.dao.EventRepository;
import com.wedul.hibernate_test.study.generated.dao.PersonRepository;
import com.wedul.hibernate_test.study.generated.dto.Event;
import com.wedul.hibernate_test.study.generated.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneratedService {

    private final PersonRepository personRepository;
    private final EventRepository eventRepository;

    public Person person(Person person) {
        return personRepository.save(person);
    }

    public Event event(Event event) {
        return eventRepository.save(event);
    }
}
