package com.hotel.service;

import com.hotel.model.Book;
import com.hotel.utils.Pager;

public interface BookService {

    Pager<Book> listAll();

    Book bookDetail(int bookId);

    Pager<Book> listAllLive();

    
    void delBook(int bookId);

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param book
     */
    void updateBook(Book book);

	void add(Book book1);


}
