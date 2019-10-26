package com.capgemini.librarymanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booksinventory")
public class BooksInventory {
	@Id
	@Column(name = "book_id")
	private String bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "author1")
	private String firstAuthor;
	@Column(name = "author2")
	private String secondAuthor;
	@Column
	private String publisher;
	@Column
	private String yearOfPublication;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getfirstAuthor() {
		return firstAuthor;
	}

	public void setfirstAuthor(String firstauthor) {
		this.firstAuthor = firstauthor;
	}

	public String getsecondAuthor() {
		return secondAuthor;
	}

	public void setsecondAuthor(String secondauthor) {
		this.secondAuthor = secondauthor;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearofpublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

}
