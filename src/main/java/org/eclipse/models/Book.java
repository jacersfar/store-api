package org.eclipse.models;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="book")
public class Book extends Product{	
	@Column(name="title")
	private String title;
	
	@Column(name="release_date")
	private Calendar releaseDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="author_id", insertable = true, updatable = false)
	private Author author;

	
	public Book() {
		super();
	}

	public Book(long id, double price, int quantity, String title, Calendar releaseDate, Author author) {
		super(id, price, quantity);
		this.title = title;
		this.releaseDate = releaseDate;
		this.author = author;
	}

	public Book(long id, double price, int quantity) {
		super(id, price, quantity);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
