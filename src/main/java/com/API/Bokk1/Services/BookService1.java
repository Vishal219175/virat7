package com.API.Bokk1.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.API.Bokk1.Dao.Book1Repository;
import com.API.Bokk1.Entities.Book1;




@Component
public class BookService1 {

	@Autowired
	private Book1Repository book1Repository;
	
	
	// get all books
		public List<Book1> getAllBooks()
		{
					
			List<Book1> list = (List<Book1>) this.book1Repository.findAll();
			
			return list;
		}
		
		
		// get single book by id
		public Book1 getBookById(int id)
		{
			Book1 book=null;
			
			try {
				
				Optional<Book1> optional = book1Repository.findById(id);
				book = optional.get();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return book;
		}    

	// Adding the book
		public Book1 addBook(Book1 b)      
		{
			
			Book1 result = book1Repository.save(b);
			return b;
			
		}
		
	//  deleting the book
		public void deleteBook(int bid)
		{
			
		 book1Repository.deleteById(bid);
		
		}
		
		// update the book
		
		public void updateBook(Book1 book, int bid)
		{
			
		book.setId(bid);
		book1Repository.save(book);
			
			
		}
		

	
	
}
