package com.API.Bokk1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.API.Bokk1.Services.BookService1;
import com.API.Bokk1.Entities.Book1;

@RestController
public class BookController1 {

	
	@Autowired
	private BookService1 bookService;
	
	////handler for getting all objects
	@GetMapping("/books1")	
	public ResponseEntity<List<Book1>> getBooks()
	{
		
		List<Book1> list=this.bookService.getAllBooks();
		
		
		if(list.size() <=0 )
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return   ResponseEntity.of(Optional.of(list));
		
	}

	
	   //handler for getting single object
		@GetMapping("/books1/{id}")	           //here,we are processing get request => In case of GET we are getting/accessing data from server
		public ResponseEntity<Book1> getBook(@PathVariable("id") int id)
		{
			
			Book1 book =bookService.getBookById(id) ; //18
			
			
			if(book==null)
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		
			
			return   ResponseEntity.of(Optional.of(book));
			
		}
	
	
		//handler for adding/creating book object into server
		@PostMapping("/books1")            //here,we are processing post request => In case of POST we are adding/posting data on to the server
		public ResponseEntity<Book1> addBook(@RequestBody Book1 book)   //here, @RequestBody annotation accepts data from request body and stored it into book variable
		{
			
			Book1 b=null; 
			
			try {
				b=this.bookService.addBook(book); //18, coding,pooja
				
				System.out.println(b);
				return ResponseEntity.status(HttpStatus.CREATED).body(b);
				
			} catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}	
			
			//handler for deleting/removing book object from the server
			@DeleteMapping("/books1/{bookId}")  //both "bookId" variables are same
			public  ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bid)
			{
				try {
					
					this.bookService.deleteBook(bid);   //bid=12
					
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
				}
			}
			
			//handler for updating book object
		   @PutMapping("/books1/{bookId}")  //both "bookId" variables are same
			public  ResponseEntity<Book1> updateBook(@RequestBody Book1 book, @PathVariable("bookId") int bid) //12
			{
			try {
							
				this.bookService.updateBook(book,bid);
				return ResponseEntity.ok().body(book);
							
			   } catch (Exception e) {
							// TODO: handle exception
							
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
						}
						
						
						
										
			}	 
			
			
			
			
		}
		
		
		

