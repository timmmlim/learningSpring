package spring.learning.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.learning.demo.domain.Author;
import spring.learning.demo.domain.Book;
import spring.learning.demo.domain.Publisher;
import spring.learning.demo.repositories.AuthorRepository;
import spring.learning.demo.repositories.BookRepository;
import spring.learning.demo.repositories.PublisherRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
         // init authors & books
        Author author1 = new Author("Author", "one");
        Book book1 = new Book("book1", "123");

        Author author2 = new Author("Author", "two");
        Book book2 = new Book("book2", "456");

        // add books & authors as set
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        // save repository
        List<Author> authorList = Arrays.asList(author1, author2);
        authorRepository.saveAll(authorList);

        List<Book> bookList = Arrays.asList(book1, book2);
        bookRepository.saveAll(bookList);

        // check result
        System.out.println("Started in bootstrap");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        Iterable<Book> bookAll = bookRepository.findAll();
        for (Book book : bookAll) {
            System.out.println(book.toString());
        }


        // add publisher
        Publisher publisher = new Publisher();
        publisher.setCity("test city");
        publisher.setName("publisher");
        publisherRepository.save(publisher);

        // check result for publishers
        Iterable<Publisher> all = publisherRepository.findAll();
        all.forEach(p -> {
            System.out.println(p.toString());
        });

    }
}
