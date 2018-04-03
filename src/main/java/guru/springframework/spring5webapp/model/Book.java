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
import javax.persistence.OneToOne;

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
	public Long id;
	private String isbn;
	@OneToOne
	private Publisher publisher;
	@Autowired
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName = "id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String isbn, Publisher publisher) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}


	public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}
	
	

	public Book(String title, Long id, String isbn, Publisher publisher, Set<Author> authors) {
		super();
		this.title = title;
		this.id = id;
		this.isbn = isbn;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
	
}
