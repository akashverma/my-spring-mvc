package com.practice.myspringmvc.repositories;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept")
public class Department {
    private String deptName;

    @OneToMany //One dept can have Many employees
    private Employee employee;
}
