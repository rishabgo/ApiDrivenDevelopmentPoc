package com.rishabh.BooksProject.controller;

import com.rishabh.BooksProject.service.BookService;
import org.books.bookservice.api.BookApi;
import org.books.models.BookInfo;
import org.books.models.BookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController implements BookApi {

    private BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<BookInfo> createBook(final BookInfo bookInfo) {

        BookInfo book = bookService.createBook(bookInfo);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BookInfo> getBook(Integer bookId) {
        final BookInfo bookInfo = bookService.getBook(bookId);
        return new ResponseEntity<>(bookInfo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookResponse> getBooks() {
        final BookResponse bookResponse = bookService.getBooks();
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }
}
