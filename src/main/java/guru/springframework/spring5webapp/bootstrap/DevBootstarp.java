package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstarp implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authRep;
	private BookRepository bookRep;
	private PublisherRepository publshRep;
	

	public DevBootstarp(AuthorRepository authRep, BookRepository bookRep, PublisherRepository publshRep) {
		super();
		this.authRep = authRep;
		this.bookRep = bookRep;
		this.publshRep = publshRep;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent ctxRefershedEvent) {
		// TODO Auto-generated method stub
		initData();
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher();
		publisher.setName("Aditya Harapana");
		publshRep.save(publisher);
		
		Author aditya = new Author("Aditya", "HARAPANA");
		Book adityabook = new Book("Spring Docker Containerize","1234", publisher);
		aditya.getBooks().add(adityabook);
		

		authRep.save(aditya);
		bookRep.save(adityabook);
		
		
		Publisher publisher1 = new Publisher();
		publisher1.setName("Ashwini Harapana");
		publshRep.save(publisher1);
		
		Author ashwini = new Author("Ashwini", "HARAPANA");
		Book ashwinibook = new Book("J2EE  Concepts","4321", publisher1);
		ashwini.getBooks().add(ashwinibook);
		
		

		authRep.save(ashwini);
		bookRep.save(ashwinibook);
	}
}
