package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.library.entity.Book;
import com.greatlearning.library.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired /*spring managed */
	private BookService bookService;
	
	@RequestMapping("/list")
	public String findAll(Model model)
	{
		List<Book> bookList=bookService.findAll() ;
		model.addAttribute("books", bookList);
		return "Books";
	}

}
