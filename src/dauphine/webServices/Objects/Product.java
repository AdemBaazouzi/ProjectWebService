package dauphine.webServices.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
	
	private Integer productId; // auto-generated value to identify each product
	private String typeOfProduct;
	private Date addedAt;
	private List<Float> notes;
	private List<String> reviews; //commentaires
	private List<User> profsWaitingList;
	private List<User> studentsWaitingList;
	private Boolean status; //true = dispo, false = borrowed
	private Integer BorrowerId;
	
	//constructor
	public Product()
	{
		profsWaitingList = new ArrayList<User>();
		studentsWaitingList = new ArrayList<User>();
		notes = new ArrayList<Float>();
		reviews = new ArrayList<String>();
		status = true;
	}
	
	public Product(Integer productId, String typeOfProduct)
	{
		profsWaitingList = new ArrayList<User>();
		studentsWaitingList = new ArrayList<User>();
		notes = new ArrayList<Float>();
		reviews = new ArrayList<String>();
		status = true;
		this.productId = productId;
		this.typeOfProduct = typeOfProduct;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getTypeOfProduct() {
		return typeOfProduct;
	}
	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}
	public Date getAddedAt() {
		return addedAt;
	}
	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}
	public List<Float> getNotes() {
		return notes;
	}
	public void setNotes(Float note) {
		this.notes.add(note);
	}
	public List<String> getReviews() {
		return reviews;
	}
	public void setReviews(String review) {
		this.reviews.add(review);
	}
	public List<User> getProfsWaitingList() {
		return profsWaitingList;
	}
	public void setProfsWaitingList(User profWaiting) {
		this.profsWaitingList.add(profWaiting);
	}
	public List<User> getStudentsWaitingList() {
		return studentsWaitingList;
	}
	public void setStudentsWaitingList(User studentWaiting) {
		this.studentsWaitingList.add(studentWaiting);
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getBorrowerId() {
		return BorrowerId;
	}
	public void setBorrowerId(Integer borrowerId) {
		BorrowerId = borrowerId;
	}
}
