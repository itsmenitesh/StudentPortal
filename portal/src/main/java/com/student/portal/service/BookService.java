package com.student.portal.service;


import com.student.portal.model.Book;
import com.student.portal.model.Student;
import com.student.portal.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    IBookRepository iBookRepository;

    // C // addBook
    public String addBookData(List<Book> book) {
        List<Book> bookList = iBookRepository.saveAll(book);
        if (book != null) {
            return "book added";
        } else {
            return "wrong data";
        }
    }

    // R // allBook
    public List<Book> allBookData() {
        return iBookRepository.findAll();
    }

    // U // updateBookById
    public String updateBookDataById(Long bookId, Book book) {
        Optional<Book> bookList = iBookRepository.findById(bookId);
        if(bookList.isEmpty()){
            return "No Book is exists with this Id please check again";
        }else {
            book.setBookId(bookId);
            iBookRepository.save(book);
            return "data Updated";
        }
    }


    // D // deleteBookById
    public String deleteBookDataBYId(Long bookId) {
        Optional<Book> bookList = iBookRepository.findById(bookId);
        if(bookList.isEmpty()){
            return "No Book is exists with this Id please check again";
        }else {

            iBookRepository.deleteById(bookId);
            return "data deleted";
        }
    }
}
