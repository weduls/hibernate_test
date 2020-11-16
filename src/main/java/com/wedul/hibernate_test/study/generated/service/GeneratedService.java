package com.wedul.hibernate_test.study.generated.service;

import com.wedul.hibernate_test.study.generated.dao.EmployeeRespository;
import com.wedul.hibernate_test.study.generated.dao.EventRepository;
import com.wedul.hibernate_test.study.generated.dao.PersonRepository;
import com.wedul.hibernate_test.study.generated.dto.Employee;
import com.wedul.hibernate_test.study.generated.dto.Event;
import com.wedul.hibernate_test.study.generated.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneratedService {

    private final PersonRepository personRepository;
    private final EventRepository eventRepository;
    private final EmployeeRespository employeeRespository;

    public Person person(Person person) {
        return personRepository.save(person);
    }

    public Event event(Event event) {
        return eventRepository.save(event);
    }

    public Employee employee(Employee employee) {
        return employeeRespository.save(employee);
    }
}
