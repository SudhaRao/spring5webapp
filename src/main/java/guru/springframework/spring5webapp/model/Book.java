package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author sudha
 *
 */

@Entity
public class Book {
	
	private String title;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String isdn;
	private String publisher;
	
	@Autowired
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Book(String title, String isdn, String publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.isdn = isdn;
		this.publisher = publisher;
		this.authors = authors;
	}



	public Book(String title, String isdn, String publisher) {
		super();
		this.title = title;
		this.isdn = isdn;
		this.publisher = publisher;
	}

	

	public Book(String title, Long id, String isdn, String publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.id = id;
		this.isdn = isdn;
		this.publisher = publisher;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsdn() {
		return isdn;
	}
	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
	
}
