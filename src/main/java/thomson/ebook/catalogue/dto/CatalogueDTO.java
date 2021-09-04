/**
 * 
 */
package thomson.ebook.catalogue.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bhanupratapsingh
 *
 */

@Entity
@Table(name = "catalogueDetail")
public class CatalogueDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "bookTitle")
	private String bookTitle;

	@Column(name = "cost")
	private long cost;

	@Column(name = "quantity")
	private short quantity;

	@Column(name = "timeOfPurchase")
	private String timeOfPurchase;

	@Column(name = "isbn")
	private long isbn;
	
	@Column(name = "userId")
	private long userId;


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public String getTimeOfPurchase() {
		return timeOfPurchase;
	}

	public void setTimeOfPurchase(String timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	
}
