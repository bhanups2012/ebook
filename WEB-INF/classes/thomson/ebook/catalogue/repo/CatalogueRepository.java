package thomson.ebook.catalogue.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thomson.ebook.catalogue.dto.CatalogueDTO;

/**
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
 * 
 */
@Repository
public interface CatalogueRepository extends JpaRepository<CatalogueDTO, Long> {

	List<CatalogueDTO> findByuserId(long userId);
}
