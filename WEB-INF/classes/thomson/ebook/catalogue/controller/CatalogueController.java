/**
 * 
 */
package thomson.ebook.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import thomson.ebook.catalogue.service.CatalogueService;
import thomson.ebook.user.model.UserModel;

/**
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
 * 
 */

@RestController
public class CatalogueController {

	@Autowired
	CatalogueService catalogueService;

	@Autowired
	UserModel userModel;

	/**
	 * This method for handle the loadCatalogue event. This will load the book Catalogue by userID.
	 * @param userId
	 * @return catalogue.jsp
	 */
	@RequestMapping("loadCatalogue")
	public ModelAndView loadCatalogue(@RequestParam("uid") long userId) {
		userModel.setUserId(userId);
		userModel.setCatalogueModelList(catalogueService.loadCatalogueData());
		return new ModelAndView("catalogue", "userModel", userModel);
	}

	/**
	 *  This method for handle the buySelectedItem event. This will process for buy the book which is selected by user.
	 * @param userModel1
	 * @return redirect:userDetail?uid=userId
	 */
	@RequestMapping("buySelectedItem")
	public ModelAndView buySelectedItem(@ModelAttribute("userModel") UserModel userModel1) {
		catalogueService.buySelectedItem(userModel1);
		return new ModelAndView("redirect:userDetail?uid="+userModel1.getUserId());
	}

}
