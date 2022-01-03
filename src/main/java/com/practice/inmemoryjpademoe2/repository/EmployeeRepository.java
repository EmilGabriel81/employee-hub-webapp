package com.practice.inmemoryjpademoe2.repository;

import com.practice.inmemoryjpademoe2.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //List<Employee> findAll();
    //Optional<Employee> findById(Integer theId);
    //Employee save(Employee emp);
    //void deleteById(Integer theId);

    List<Employee> findAllByOrderByLastNameAsc();
}
