package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmlearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmlearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(OrmlearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);

        System.out.println("Inside main");

        testGetEmployee();
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Skills: {}", employee.getSkillList());

        LOGGER.info("End");
    }
}