package com.csm.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column
    private String empName;
    @Column
    private Date hireDate;
    @Column
    private int dept;
    @Column
    private double salary;
    @Column
    private String empType;

}
