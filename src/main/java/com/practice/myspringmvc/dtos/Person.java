package com.practice.myspringmvc.dtos;

import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Person {
    @NotNull
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
