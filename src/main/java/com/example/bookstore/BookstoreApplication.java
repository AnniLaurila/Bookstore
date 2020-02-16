package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			Category category1 = new Category("Lasten kirjat");
			Category category2 = new Category("Kasvatustiede");
			Category category3 = new Category("Tietokirjat");
			
			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);
			
			repository.save(new Book("Meidän Tomppa", "Kristiina Louhi", 2004, "9789513101732", 16.7, category1));
			repository.save(new Book("Pää edellä", "Tiina Huttu", 2017, "9789510424087", 11.6, category2));
			repository.save(new Book("Uhmakirja", "Malin Alfvén", 2012, "9789513167257", 29, category2));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
