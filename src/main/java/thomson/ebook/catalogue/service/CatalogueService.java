package thomson.ebook.catalogue.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thomson.ebook.catalogue.dto.CatalogueDTO;
import thomson.ebook.catalogue.model.CatalogueModel;
import thomson.ebook.catalogue.repo.CatalogueRepository;

@Service
public class CatalogueService {

	@Autowired
	CatalogueRepository catalogueRepository;

	public List<CatalogueModel> catalogueLoadByID(long userId) {
		List<CatalogueModel> catalogueModelList = new LinkedList<CatalogueModel>();
		CatalogueDTO catalogueDTO = new CatalogueDTO();
		catalogueDTO.setBookTitle("The Jungle book");
		catalogueDTO.setCost(5000);
		catalogueDTO.setTimeOfPurchase("14/04/2019 21:29:06");
		catalogueDTO.setQuantity((short) 10);
		catalogueDTO.setUserId(1);
		catalogueRepository.save(catalogueDTO);

		catalogueDTO.setBookTitle("The Earth");
		catalogueDTO.setCost(6000);
		catalogueDTO.setTimeOfPurchase("13/04/2019 21:29:06");
		catalogueDTO.setQuantity((short) 11);
		catalogueDTO.setUserId(1);
		catalogueRepository.save(catalogueDTO);

		catalogueDTO.setBookTitle("The Planet");
		catalogueDTO.setCost(7000);
		catalogueDTO.setTimeOfPurchase("12/04/2019 21:29:06");
		catalogueDTO.setQuantity((short) 13);
		catalogueDTO.setUserId(1);
		catalogueRepository.save(catalogueDTO);

		catalogueDTO.setBookTitle("The Animal");
		catalogueDTO.setCost(8000);
		catalogueDTO.setTimeOfPurchase("11/04/2019 21:29:06");
		catalogueDTO.setQuantity((short) 14);
		catalogueDTO.setUserId(1);
		catalogueRepository.save(catalogueDTO);

		CatalogueModel catalogueModel;
		List<CatalogueDTO> catalogueDTOList = catalogueRepository.findAllById(userId);
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
}
