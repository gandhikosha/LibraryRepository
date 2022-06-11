package com.greatlearning.library.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		/*for(Book b:bookList)
		{
			System.out.println(b);
		}*/
		return bookList;
	}
	
	@Transactional
	public Book findById(Integer id)
	{
		Book book=session.get(Book.class, id);		
		return book;
	}
	
	@Transactional
	public void save(Book book)
	{
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(book);
		tr.commit();
	}

	@Transactional
	public void delete(Book b) {
		Transaction tr=session.beginTransaction();
		session.delete(b);
		tr.commit();
	}


	@Override
	@Transactional
	public List<Book> findByTitle_Author(String title, String author) {
		List<Book> bookList=null;
		String query="";
		if(title.length()!=0 && author.length()!=0)
			query="from Book where title like '%"+title+"%' and author like '%"+author+"%'";
		else if(title.length()==0 && author.length()!=0)
			query="from Book where author like '%"+author+"%'";
		else if(title.length()!=0 && author.length()==0)
			query="from Book where title like '%"+title+"%'";
		else
			query="from Book";
		if(query.length()!=0)
		{
			bookList=session.createQuery(query).list();
		}
		return bookList;
	}

}
