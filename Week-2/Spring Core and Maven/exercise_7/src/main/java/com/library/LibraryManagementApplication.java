package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Testing Constructor Injection ---");
        BookService constructorInjectedService = (BookService) context.getBean("bookServiceConstructor");
        System.out.println(constructorInjectedService.getBookDetails(101));

        System.out.println("\n--- Testing Setter Injection ---");
        BookService setterInjectedService = (BookService) context.getBean("bookServiceSetter");
        System.out.println(setterInjectedService.getBookDetails(102));
        ((AbstractApplicationContext) context).close();
    }
}