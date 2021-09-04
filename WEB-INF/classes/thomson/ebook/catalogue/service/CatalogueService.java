package thomson.ebook.catalogue.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thomson.ebook.catalogue.dto.BookDTO;
import thomson.ebook.catalogue.dto.CatalogueDTO;
import thomson.ebook.catalogue.model.CatalogueModel;
import thomson.ebook.catalogue.repo.BookRepository;
import thomson.ebook.catalogue.repo.CatalogueRepository;
import thomson.ebook.user.model.UserModel;

/**
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
 * 
 */

@Service
public class CatalogueService {

	@Autowired(required = true)
	CatalogueRepository catalogueRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CatalogueModel catalogueModel;

	/**
	 * This method for load catalogue data by userId from Catalogue table
	 * 
	 * @param userId
	 * @return List<CatalogueModel>
	 */
	public List<CatalogueModel> catalogueLoadByID(long userId) {
		List<CatalogueModel> catalogueModelList = new LinkedList<CatalogueModel>();
		List<CatalogueDTO> catalogueDTOList = catalogueRepository.findByuserId(userId);
		for (CatalogueDTO catalogueDTOData : catalogueDTOList) {
			catalogueModel = new CatalogueModel();
			catalogueModel.setBookTitle(catalogueDTOData.getBookTitle());
			catalogueModel.setCost(catalogueDTOData.getCost());
			catalogueModel.setTimeOfPurchase(catalogueDTOData.getTimeOfPurchase());
			catalogueModel.setQuantity(catalogueDTOData.getQuantity());
			catalogueModelList.add(catalogueModel);
		}
		return catalogueModelList;
	}

	/**
	 * This method for loadCatalogue data from book table
	 * @return List<CatalogueModel>
	 */
	public List<CatalogueModel> loadCatalogueData() {
		List<CatalogueModel> catalogueModelList = new ArrayList<CatalogueModel>();
		List<BookDTO> catalogueDTOList = bookRepository.findAll();
		for (BookDTO bookDTO : catalogueDTOList) {
			catalogueModel = new CatalogueModel();
			catalogueModel.setBookID(bookDTO.getBookId());
			catalogueModel.setBookTitle(bookDTO.getBookTitle());
			catalogueModel.setCost(bookDTO.getCost());
			catalogueModel.setQuantity(bookDTO.getQuantity());
			catalogueModelList.add(catalogueModel);
		}
		return catalogueModelList;
	}

	/**
	 * This method for buy the book process.
	 * @param userModel
	 */
	public void buySelectedItem(UserModel userModel) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss");
		;
		for (int bookId : userModel.getSelectedBooks()) {
			BookDTO bookDTO = bookRepository.findByBookId(bookId);
			CatalogueDTO catalogueDTO = new CatalogueDTO();
			catalogueDTO.setUserId(userModel.getUserId());
			catalogueDTO.setBookTitle(bookDTO.getBookTitle());
			catalogueDTO.setCost(bookDTO.getCost());
			catalogueDTO.setQuantity(bookDTO.getQuantity());
			catalogueDTO.setTimeOfPurchase(format.format(ZonedDateTime.now()));
			catalogueRepository.save(catalogueDTO);
		}

	}
}
