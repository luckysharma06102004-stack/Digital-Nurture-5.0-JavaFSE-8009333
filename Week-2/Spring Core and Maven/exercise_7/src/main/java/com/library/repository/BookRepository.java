package com.library.repository;

public class BookRepository {

    public String findBookById(int id) {
        return "Book #" + id + ": 'Effective Java'";
    }
}