package dauphine.webServices.Objects;

import dauphine.webServices.FakeBase.DummyMain;

public class User {
	
	private Integer userId;
	private Boolean typeOfUser; //True = Teacher, False = Student
	private Integer borrowCount;
	
	public User()
	{
		this.borrowCount = 0;
	}
	
	public User(Integer userId, Boolean typeOfUser)
	{
		this.userId = userId;
		this.typeOfUser = typeOfUser;
		this.borrowCount = 0;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Boolean getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(Boolean typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	public Integer getBorrowCount() {
		return borrowCount;
	}
	public void setBorrowCount(Integer borrowCount) {
		this.borrowCount = borrowCount;
	}
	
	//Methods
	
	public void AddProduct (Product product)
	{
		DummyMain.products.add(product);
	}
	
	public void BorrowProduct (Product product)
	{
		// if the product is dispo
		if(product.getStatus())
		{
			System.out.println("Product is free");
			product.setBorrowerId(this.getUserId());
			product.setStatus(false);
			borrowCount ++;
		}
		else // if the product is already borrowed
		{
			System.out.println("Product is borrowed");
			// if the borrower is a teacher
			if(this.getTypeOfUser())
			{
				product.setProfsWaitingList(this);
			}
			else // if the borrower is a student
			{
				product.setStudentsWaitingList(this);
			}
		}
	}
	
	public void ReturnProduct (Product product)
	{
		System.out.println("Product is now free");
		product.setStatus(true);
		product.setBorrowerId(null);
		// verify if there is someone waiting to borrow the product
		if(product.getProfsWaitingList().size() != 0)
		{
			product.getProfsWaitingList().get(0).BorrowProduct(product);
			product.getProfsWaitingList().remove(0);
			return;
		}
		if(product.getStudentsWaitingList().size() != 0)
		{
			product.getStudentsWaitingList().get(0).BorrowProduct(product);
			product.getStudentsWaitingList().remove(0);
		}
	}
	
	public void ReviewProduct (Product product, String review)
	{
		product.setReviews(review);
	}
	
	public void NoteProduct (Product product, Float note)
	{
		product.setNotes(note);
	}
}
