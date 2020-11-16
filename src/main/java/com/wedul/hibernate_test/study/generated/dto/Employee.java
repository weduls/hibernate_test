package com.wedul.hibernate_test.study.generated.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pswd")
    @ColumnTransformer(
        read = "AES_DECRYPT(UNHEX(pswd), SHA2('enc_key',512))",
        write = "HEX(AES_ENCRYPT(?, SHA2('enc_key',512)))"
    )
    private String password;

    private int accessLevel;

    @Builder
    public Employee(Long id, String password, int accessLevel) {
        this.id = id;
        this.password = password;
        this.accessLevel = accessLevel;
    }
}
