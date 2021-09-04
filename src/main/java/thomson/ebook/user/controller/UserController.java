/**
 * 
 */
package thomson.ebook.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@Autowired(required=true)
	UserService userService;
	

	@RequestMapping("userDetail")
	public ModelAndView userDetail(@RequestParam("uid") long userId) {
		return new ModelAndView("user", "userModel", userService.loadUserData(userId));
	}
}
