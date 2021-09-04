/**
 * 
 */
package thomson.ebook.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import thomson.ebook.user.model.UserModel;
import thomson.ebook.user.service.UserService;

/**
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
 * 
 */

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	/**
	 * This method for handling the request of userDetail event. This will load the user detail by using userID
	 * @param userId
	 * @return view user.jsp
	 */
	@RequestMapping("userDetail")
	public ModelAndView userDetail(@RequestParam("uid") long userId) {
		return new ModelAndView("user", "userModel", userService.loadUserData(userId));
	}
	
	/**
	 * This method for handling the request of updateUserDetail event. This will update the user detail by using userID
	 * @param userModel
	 * @return user.jsp
	 */
	@RequestMapping("updateUserDetail")
	public ModelAndView updateUserDetail( @ModelAttribute("userModel") UserModel userModel ) {
		UserModel model = userService.updateUserData(userModel);
		model.setMsg("Data updated Successfully !!");
		return new ModelAndView("user", "userModel", model);
	}

}
