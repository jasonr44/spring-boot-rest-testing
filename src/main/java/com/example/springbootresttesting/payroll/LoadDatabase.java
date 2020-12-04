package com.example.springbootresttesting.payroll;

import com.example.springbootresttesting.payroll.employee.Employee;
import com.example.springbootresttesting.payroll.employee.EmployeeRepository;
import com.example.springbootresttesting.payroll.order.Order;
import com.example.springbootresttesting.payroll.order.OrderRepository;
import com.example.springbootresttesting.payroll.order.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar", "This guy is a burglar."));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief", "This guy is a thief -- which is pretty much like a burglar."));

            employeeRepository.findAll().forEach(employee -> {
                log.info("Preloaded " + employee);
            });

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
