package com.cognizant.ormlearn;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
@SpringBootApplication
public class OrmlearnApplication {
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(OrmlearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        System.out.println("Inside main");
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
    }
    private static void testGetEmployee() {
        System.out.println("Start Get Employee");
        Employee employee = employeeService.get(1);
        System.out.println("Employee: " + employee);
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("End Get Employee");
    }
    private static void testAddEmployee() {
        System.out.println("Start Add Employee");
        Department department = departmentService.get(2);
        Employee employee = new Employee();
        employee.setName("Lucky Sharma");
        employee.setSalary(65000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        employee.setDepartment(department);
        employeeService.save(employee);
        System.out.println("Employee added successfully");
        System.out.println("End Add Employee");
    }

    private static void testUpdateEmployee() {
        System.out.println("Start Update Employee");
        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2);
        employee.setDepartment(department);
        employeeService.save(employee);
        System.out.println("Updated Employee: " + employee);
        System.out.println("End Update Employee");
    }
}