package dauphine.webServices.Interfaces;

import dauphine.webServices.Objects.Product;

public interface IUser {
	
	public void AddProduct (Product product);
	public void BorrowProduct (Product product);
	public void ReturnProduct (Product product);
	public void ReviewProduct (Product product, String review);
	public void NoteProduct (Product product, Float note);

}
