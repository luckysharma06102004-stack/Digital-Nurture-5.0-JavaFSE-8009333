package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService created via CONSTRUCTOR injection.");
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository set via SETTER injection.");
    }
    public String getBookDetails(int id) {
        return bookRepository.findBookById(id);
    }
}