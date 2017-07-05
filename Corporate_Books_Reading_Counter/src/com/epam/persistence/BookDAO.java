package com.epam.persistence;

import java.util.ArrayList;

import com.epam.domain.Book;

public interface BookDAO {

	public void updateBook();

	public ArrayList<?> selectBooks();

	public void insertBook(Book book);

	public void deleteBook(Book book);
}
