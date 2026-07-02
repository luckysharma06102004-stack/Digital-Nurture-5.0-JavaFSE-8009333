package com.cognizant.ormlearn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.service.DepartmentService;
@SpringBootApplication
public class OrmlearnApplication {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmlearnApplication.class);
    private static DepartmentService departmentService;
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(OrmlearnApplication.class, args);
        departmentService = context.getBean(DepartmentService.class);
        System.out.println("Inside main");
        testGetDepartment();
    }
    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployeeList());
        LOGGER.info("End");
    }
}