package com.wedul.hibernate_test.study.generated.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName1;

    private String middleName2;

    private String middleName3;

    private String middleName4;

    private String middleName5;

    @Generated( value = GenerationTime.ALWAYS )
    @Column(columnDefinition =
        "VARCHAR(255) AS (CONCAT(" +
            "	COALESCE(first_name, ''), " +
            "	COALESCE(CONCAT(' ', middle_name1), ''), " +
            "	COALESCE(CONCAT(' ', middle_name2), ''), " +
            "	COALESCE(CONCAT(' ', middle_name3), ''), " +
            "	COALESCE(CONCAT(' ', middle_name4), ''), " +
            "	COALESCE(CONCAT(' ', middle_name5), ''), " +
            "	COALESCE(CONCAT(' ', last_name), '') " +
            ")) ")
    private String fullName;

}
