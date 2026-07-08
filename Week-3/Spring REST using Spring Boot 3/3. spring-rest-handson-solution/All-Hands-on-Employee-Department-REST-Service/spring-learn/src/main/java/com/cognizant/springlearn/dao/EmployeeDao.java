package com.cognizant.springlearn.dao;
import com.cognizant.springlearn.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDao {
    private static final Logger LOGGER =
        LoggerFactory.getLogger(EmployeeDao.class);
    private static ArrayList<Employee> EMPLOYEE_LIST;
    public EmployeeDao() {
        LOGGER.info("Start");
        ApplicationContext context =
            new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
        LOGGER.info("End");
    }
    public List<Employee> getAllEmployees() {
        LOGGER.info("Start");
        LOGGER.info("End");
        return EMPLOYEE_LIST;
    }
}