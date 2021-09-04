/**
 * 
 */
package thomson.ebook.catalogue.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author bhanupratapsingh
 * @date 11/04/2019
 * @version v1.0
 * 
 */
@Component
@Scope(value = "prototype")
public class CatalogueModel {

	private String bookTitle;
	private float cost;
	private short quantity;
	private String timeOfPurchase;
	private long isbn;
	private int bookID;

	public long getBookID() {
		return bookID;
	}

	public String getTimeOfPurchase() {
		return timeOfPurchase;
	}

	public void setTimeOfPurchase(String timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

}
