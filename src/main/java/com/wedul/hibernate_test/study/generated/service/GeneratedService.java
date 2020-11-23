package com.wedul.hibernate_test.study.generated.service;

import com.wedul.hibernate_test.study.generated.dao.AccountRepository;
import com.wedul.hibernate_test.study.generated.dao.EmployeeRespository;
import com.wedul.hibernate_test.study.generated.dao.EventRepository;
import com.wedul.hibernate_test.study.generated.dao.PersonRepository;
import com.wedul.hibernate_test.study.generated.dto.Account;
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
    private final AccountRepository accountRepository;

    public Person person(Person person) {
        return personRepository.save(person);
    }

    public Event event(Event event) {
        return eventRepository.save(event);
    }

    public Employee employee(Employee employee) {
        return employeeRespository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRespository.findById(id).orElse(null);
    }

    public Account account(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}
