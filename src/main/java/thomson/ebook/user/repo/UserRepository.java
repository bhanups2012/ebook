package thomson.ebook.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thomson.ebook.user.dto.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long>{
	UserDTO findById (long id);
}
