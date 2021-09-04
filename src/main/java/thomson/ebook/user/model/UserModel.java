package thomson.ebook.user.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import thomson.ebook.catalogue.model.CatalogueModel;

/**
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
 * 
 */

@Component
@Scope(value = "prototype")
public class UserModel {

	private String firstName = null;
	private String lastName = null;
	private String emailAddress = null;
	private List<CatalogueModel> catalogueModelList = null;

	
	

	public List<CatalogueModel> getCatalogueModelList() {
		return catalogueModelList;
	}

	public void setCatalogueModelList(List<CatalogueModel> catalogueModelList) {
		this.catalogueModelList = catalogueModelList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
