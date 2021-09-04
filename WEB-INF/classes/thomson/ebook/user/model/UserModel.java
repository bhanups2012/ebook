package thomson.ebook.user.model;

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

	private long userId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private List<CatalogueModel> catalogueModelList;
	private int[] selectedBooks ;
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int[] getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(int[] selectedBooks) {
		this.selectedBooks = selectedBooks;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

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
