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
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
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

	/**
	 * This method will load user data and will set in UserModel for view
	 * @param userId
	 * @return UserModel object
	 */
	public UserModel loadUserData(long userId) {
		UserDTO userDto = new UserDTO();
		userDto = userRepository.findById(userId);
		userModel.setUserId(userDto.getId());
		userModel.setFirstName(userDto.getFirstName());
		userModel.setLastName(userDto.getLastName());
		userModel.setEmailAddress(userDto.getEmailAddress());
		userModel.setCatalogueModelList(catalogueService.catalogueLoadByID(userId));
		return userModel;
	}

	/**
	 * This method for update the user details.
	 * @param userModelUpdate
	 * @return UserModel
	 */
	public UserModel updateUserData(UserModel userModelUpdate) {
		UserDTO userDTO = userRepository.findById(userModelUpdate.getUserId());
		userDTO.setFirstName(userModelUpdate.getFirstName());
		userDTO.setLastName(userModelUpdate.getLastName());
		userDTO.setEmailAddress(userModelUpdate.getEmailAddress());
		userRepository.save(userDTO);
		userModelUpdate.setCatalogueModelList(catalogueService.catalogueLoadByID(userModelUpdate.getUserId()));
		return userModelUpdate;
	}
}
