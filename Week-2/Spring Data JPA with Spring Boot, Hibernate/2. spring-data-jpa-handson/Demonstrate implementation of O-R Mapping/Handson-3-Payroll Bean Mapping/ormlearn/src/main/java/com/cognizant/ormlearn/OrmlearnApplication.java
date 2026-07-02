package com.cognizant.ormlearn;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
@SpringBootApplication
public class OrmlearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnApplication.class);
    private static EmployeeRepository employeeRepository;
    private static DepartmentRepository departmentRepository;
    private static SkillRepository skillRepository;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnApplication.class, args);
        employeeRepository = context.getBean(EmployeeRepository.class);
        departmentRepository = context.getBean(DepartmentRepository.class);
        skillRepository = context.getBean(SkillRepository.class);
        LOGGER.info("Inside main");
        testGetAllEmployees();
        testGetAllDepartments();
        testGetAllSkills();
    }
    private static void testGetAllEmployees() {
        LOGGER.info("=== testGetAllEmployees Start ===");
        List<Employee> employees = employeeRepository.findAll();
        LOGGER.debug("Employees: {}", employees);
        LOGGER.info("=== testGetAllEmployees End ===");
    }
    private static void testGetAllDepartments() {
        LOGGER.info("=== testGetAllDepartments Start ===");
        List<Department> departments = departmentRepository.findAll();
        LOGGER.debug("Departments: {}", departments);
        LOGGER.info("=== testGetAllDepartments End ===");
    }
    private static void testGetAllSkills() {
        LOGGER.info("=== testGetAllSkills Start ===");
        List<Skill> skills = skillRepository.findAll();
        LOGGER.debug("Skills: {}", skills);
        LOGGER.info("=== testGetAllSkills End ===");
    }
}