package com.rishabh.BooksProject.service;

import org.books.models.BookInfo;
import org.books.models.BookResponse;
import org.springframework.http.ResponseEntity;

public interface BookService {
    BookInfo getBook(Integer bookId);

    BookResponse getBooks();

    BookInfo createBook(BookInfo bookInfo);
}
