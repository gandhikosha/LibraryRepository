package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/save")
	public String save(@RequestParam("id") Integer id,@RequestParam("title") String title,@RequestParam("author") String author,
			@RequestParam("category") String category)
	{
		Book b=null;
		if(id!=-1)
		{
			b=bookService.findById(id);
			b.setAuthor(author);
			b.setCategory(category);
			b.setTitle(title);
		}
		else
			b=new Book(title, author, category);
		
		bookService.save(b);
		return "redirect:list";
	}
	
	
	@RequestMapping("/addBook")
	public String addBook(@RequestParam("id") Integer id, Model model)
	{
	
		
		if(id!=-1)
		{
			Book b=bookService.findById(id);
			model.addAttribute("book", b);
		}
		else
		{
			Book b=new Book();
			b.setId(-1);
			model.addAttribute("book", b);
		}
		
		return "BookForm";
	}
	
	
	@RequestMapping("/deleteBook")
	public String delete(@RequestParam("id") Integer id)
	{
		Book b=null;
		if(id!=-1)
		{
			b=bookService.findById(id);
			bookService.delete(b);
		}
		
		return "redirect:list";
	}
	
	@RequestMapping("/search")
	public String findByTitle_Author(@RequestParam("title")String title, @RequestParam("author") String author,Model model)
	{
		List<Book> bookList=bookService.findByTitle_Author(title,author) ;
		System.out.println(bookList);
		if(bookList.size()!=0)
			model.addAttribute("books", bookList);
		else
			model.addAttribute("error", "No Books Found");
		return "Books";
	}

}
