package com.endava.internship.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends AbstractEntity {
    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "phone_number", unique = true)
    @NotBlank
    private String phoneNumber;

    @Column(precision = 10, scale = 2)
    @Min(1)
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;
}
