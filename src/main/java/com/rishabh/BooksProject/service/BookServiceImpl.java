package com.rishabh.BooksProject.service;

import org.books.models.BookInfo;
import org.books.models.BookResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private final Map<Integer, BookInfo> booksMap = new HashMap<>();

    @Override
    public BookInfo getBook(final Integer bookId) {

        if (bookId == null || bookId == 0) throw new IllegalArgumentException("Please check bookId");

        if (booksMap.get(bookId) == null) {
            throw new RuntimeException("Book not found!");
        } else {
            return booksMap.get(bookId);
        }
    }

    @Override
    public BookResponse getBooks() {

        if (booksMap.isEmpty()) throw new RuntimeException("No Book Found exception");
        return new BookResponse().bookResponse(new ArrayList<>(booksMap.values()));
    }

    @Override
    public BookInfo createBook(final BookInfo bookInfo) {

        if (bookInfo.getBookId() == null || bookInfo.getBookId() == 0) throw new RuntimeException("Invalid book id");
        booksMap.put(bookInfo.getBookId(), bookInfo);
        return bookInfo;
    }
}
