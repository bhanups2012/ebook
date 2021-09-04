/**
 * 
 */
package thomson.ebook.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thomson.ebook.catalogue.service.CatalogueService;
import thomson.ebook.user.dto.UserDTO;
import thomson.ebook.user.model.UserModel;
import thomson.ebook.user.repo.UserRepository;

/**
 * @author bhanupratapsingh
 *
 */

@Service
public class UserService {

	@Autowired
	UserModel userModel;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CatalogueService catalogueService;

	public UserModel loadUserData(long userId) {
		UserDTO userDto = userRepository.findById(userId);
		userModel.setFirstName(userDto.getFirstName());
		userModel.setLastName(userDto.getLastName());
		userModel.setEmailAddress(userDto.getEmailAddress());

		userModel.setCatalogueModelList(catalogueService.catalogueLoadByID(userId));
		return userModel;
	}
}
