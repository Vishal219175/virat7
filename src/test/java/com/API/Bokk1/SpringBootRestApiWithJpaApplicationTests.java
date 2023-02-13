package com.API.Bokk1;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.API.Bokk1.Dao.Book1Repository;
import com.API.Bokk1.Entities.Book1;
import com.API.Bokk1.Services.BookService1;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootRestApiWithJpaApplicationTests {

	@Autowired
	private BookService1 bookService1;
	
	@MockBean
	private Book1Repository book1Repository;
	
	@Test
	public void getuserstest()
	{
		when(book1Repository.findAll()).thenReturn(Stream
				.of(new Book1(3, "vishal", "USA"), new Book1(9, "cristiano", "portugal")).collect(Collectors.toList()));
		
		assertEquals(2, bookService1.getAllBooks().size());
		
	}
	
	
	
}
