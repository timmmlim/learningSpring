package spring.learning.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.learning.demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
