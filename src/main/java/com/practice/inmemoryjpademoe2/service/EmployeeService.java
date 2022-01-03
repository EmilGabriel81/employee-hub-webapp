package com.practice.inmemoryjpademoe2.service;

import com.practice.inmemoryjpademoe2.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();// implemented

    Employee findById(Integer theId);// implemented

    Employee save(Employee emp);// implemented save and update(2 in 1)

    void deleteById(Integer theId);

}
