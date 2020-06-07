package com.practice.myspringmvc.repositories;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    private String name;

    @ManyToOne //Many Employees can work in One Department
    private Department department;
}
