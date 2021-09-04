package thomson.ebook.catalogue.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thomson.ebook.catalogue.dto.CatalogueDTO;

@Repository
public interface CatalogueRepository extends JpaRepository<CatalogueDTO, Long> {

	List<CatalogueDTO> findAllById(long userId);
}
