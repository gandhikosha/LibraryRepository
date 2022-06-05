package com.greatlearning.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.greatlearning.library.entity.Book;

@Repository
public class BookServiceImpl implements BookService {
	
	private SessionFactory sessionfactory;
	
	private Session session;
	
	
	public BookServiceImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;		
		try {
			session=this.sessionfactory.getCurrentSession();
			
		} catch (HibernateException e) {
			session=this.sessionfactory.openSession();
		}
	}


	@Transactional
	public List<Book> findAll()
	{
		List<Book> bookList=session.createQuery("from Book").list();
		for(Book b:bookList)
		{
			System.out.println(b);
		}
		return bookList;
	}

}
