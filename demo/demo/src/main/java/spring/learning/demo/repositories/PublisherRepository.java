package spring.learning.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.learning.demo.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    Iterable<Publisher> findAll();
}
