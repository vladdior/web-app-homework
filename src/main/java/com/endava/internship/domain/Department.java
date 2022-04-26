package com.endava.internship.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department extends AbstractEntity {
    @NotBlank
    private String name;

    @NotBlank
    private String location;
}
