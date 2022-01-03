package com.practice.inmemoryjpademoe2;

import com.practice.inmemoryjpademoe2.entity.Employee;
import com.practice.inmemoryjpademoe2.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InmemoryjpademoE2Application {

    public static void main(String[] args) {
        SpringApplication.run(InmemoryjpademoE2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return args -> {
            Employee e1 = new Employee("John","Slow","johnslow@home.com");
            Employee e2 = new Employee("Jack","Pack","jackpack@home.com");
            Employee e3 = new Employee("Jane","Moe","janemoe@home.com");
            employeeRepository.save(e1);
            employeeRepository.save(e2);
            employeeRepository.save(e3);
        };

    }

}
