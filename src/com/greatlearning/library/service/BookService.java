package com.greatlearning.library.service;

import java.util.List;

import com.greatlearning.library.entity.Book;

public interface BookService {
	
	public List<Book> findAll();
	public void save(Book b);
	public Book findById(Integer id);
	public void delete(Book b);
	public List<Book> findByTitle_Author(String title, String author);
}
