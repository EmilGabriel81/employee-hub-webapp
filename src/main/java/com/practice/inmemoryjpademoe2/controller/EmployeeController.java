package com.practice.inmemoryjpademoe2.controller;

import com.practice.inmemoryjpademoe2.entity.Employee;
import com.practice.inmemoryjpademoe2.exceptions.EmployeeNotFoundException;
import com.practice.inmemoryjpademoe2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /** Get all The employees **/

    @GetMapping("/employees")
    public String getEmployees(Model model){
        List<Employee>emps = employeeService.findAll();
        model.addAttribute("empList",emps);
        return "employees";
    }

    @GetMapping("/employees/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee theEmployee = new Employee();
        model.addAttribute("employee", theEmployee);
        return"employee-form";
    }

    /** Get an employee by id **/

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null) {
           // throw new RuntimeException("Employee id not found - " + id);
            throw new EmployeeNotFoundException("Employee id not found - " + id);
        }
        return employee;
    }

    // add mapping for POST /employees - add new employee
    /** Save an employee **/

    @PostMapping("/employees/save")
    public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        //theEmployee.setId(0);
        employeeService.save(theEmployee);
       // System.out.println("Saving the employee... employee.id -"+theEmployee.getId());
        return "redirect:/employees";
    }

    /** Modify the details of an employee **/

//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee){
//        employeeService.save(employee);
//        return employee;
//    }

    @GetMapping("/employees/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model){
        Employee theEmployee = employeeService.findById(theId);
        model.addAttribute("employee", theEmployee);
        return "employee-form";
    }

    /** Delete an employee **/

//    @DeleteMapping("/employees/{id}")
//    public String deleteEmployee(@PathVariable int id){
//        Employee employee = employeeService.findById(id);
//        if (employee == null) {
//           // throw new RuntimeException("Employee id not found - " + id);
//            throw new EmployeeNotFoundException("Employee id not found - " + id);
//        }
//        employeeService.deleteById(id);
//        return " Successfuly removed employee id - "+id+" name - "+employee.getFirstName();
//    }

    @GetMapping("/employees/delete")
    public String delete(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees";
    }


}
