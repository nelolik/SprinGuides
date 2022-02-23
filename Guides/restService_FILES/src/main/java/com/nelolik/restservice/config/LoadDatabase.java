package com.nelolik.restservice.config;

import com.nelolik.restservice.model.Employee;
import com.nelolik.restservice.model.Order;
import com.nelolik.restservice.model.Status;
import com.nelolik.restservice.repository.EmployeeRepository;
import com.nelolik.restservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Scanner;

@Configuration
public class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(EmployeeRepository employeeRepository,
                                          OrderRepository orderRepository) {
        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + employeeRepository.save(new Employee("Frodo", "Baggins", "thief")));
            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED.name()));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS.name()));
            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
