package com.API.Bokk1.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private int id;
	private String title;
	private String author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	@Override
	public String toString() {
		return "Book1 [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
	public Book1(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	
	public Book1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
}
