package com.student.portal.controller;

import com.student.portal.model.Book;
import com.student.portal.model.Student;
import com.student.portal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    // C //addBook
    @PostMapping()
    public String addStudent(@RequestBody List<Book> book){

        return bookService.addBookData(book);
    }

    // R // allBook
    @GetMapping()
    public List<Book> allBook(){
        return bookService.allBookData();
    }

    // U // UpdateBookById
    @PutMapping("{bookId}")
    public String UpdateBookById(@PathVariable Long bookId , @RequestBody Book book){
        return bookService.updateBookDataById(bookId , book);
    }

    // D // deleteBookById
    @DeleteMapping("{bookId}")
    public String deleteBookById(@PathVariable Long bookId){
        return bookService.deleteBookDataBYId(bookId);
    }

}
