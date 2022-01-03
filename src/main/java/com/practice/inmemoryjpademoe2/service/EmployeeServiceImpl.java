package com.practice.inmemoryjpademoe2.service;

import com.practice.inmemoryjpademoe2.entity.Employee;
import com.practice.inmemoryjpademoe2.exceptions.EmployeeNotFoundException;
import com.practice.inmemoryjpademoe2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(Integer theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }else{
            throw new EmployeeNotFoundException("Could not find the employee with id "+theId);
            //throw new RuntimeException("Couldn`t find the id "+theId);
        }

        return employee;
    }

    @Override
    public Employee save(Employee emp) {
        employeeRepository.save(emp);
        return emp;
    }

    @Override
    public void deleteById(Integer theId) {
        employeeRepository.deleteById(theId);
    }
}
