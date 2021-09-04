package thomson.ebook.catalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thomson.ebook.catalogue.dto.BookDTO;


/**
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
 * 
 */

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Long> {

	BookDTO findByBookId(int bookId);

}
