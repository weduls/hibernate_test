package com.wedul.hibernate_test.study.generated.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "`timestamp`")
    @CreationTimestamp
    private Date timestamp;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Date updatedOn;

    //Constructors, getters, and setters are omitted for brevity
}