package dauphine.webServices.FakeBase;

import java.util.ArrayList;
import java.util.List;

import dauphine.webServices.Objects.Product;
import dauphine.webServices.Objects.User;

public class DummyMain {
	
	//a dummy base just for test purposes
	public static List<Product> products = new ArrayList<Product>();
	private static Integer idProd = 0;
	private static Integer idUser = 0;
	
	public static void main(String[] args)
	{
		
		//create some products
		Product product1 = new Product(++idProd, "book");		
		Product product2 = new Product(++idProd, "clothes");		
		Product product3 = new Product(++idProd, "clothes");		
		Product product4 = new Product(++idProd, "book");
		Product product5 = new Product(++idProd, "book");
		
		//create some users
		User user1 = new User(++idUser, false);// student
		User user2 = new User(++idUser, true);// teacher
		User user3 = new User(++idUser, true);// teacher
		User user4 = new User(++idUser, false);// student
		
		//Here we begin the real deal
		user1.AddProduct(product1);
		user3.AddProduct(product2);
		user3.AddProduct(product3);
		user2.AddProduct(product4);
		user2.AddProduct(product5);
		
		//Here some products will be borrowed
		user4.BorrowProduct(product1);
		user3.BorrowProduct(product1);
		user2.BorrowProduct(product1);
		user1.BorrowProduct(product1);
		// and returned
		System.out.print(product1.getBorrowerId()+",");
		user4.ReturnProduct(product1);
		System.out.print(product1.getBorrowerId()+",");
		user3.ReturnProduct(product1);
		System.out.print(product1.getBorrowerId()+",");
		user2.ReturnProduct(product1);
		System.out.print(product1.getBorrowerId()+",");
		user1.ReturnProduct(product1);
		System.out.println(product1.getBorrowerId());
		/***should display: 4,3,2,1,null ==> OK!***/
		
		//Now we test the review methods
		user4.ReviewProduct(product1, "Funny Book!");
		user4.NoteProduct(product1, 4.5f);
		user3.ReviewProduct(product1, "cool!");
		user3.NoteProduct(product1, 4.0f);
		user2.ReviewProduct(product1, "OK!");
		user2.NoteProduct(product1, 3.0f);
		user1.ReviewProduct(product1, "Old book!");
		user1.NoteProduct(product1, 1.5f);
		System.out.println(product1.getReviews().toString());
		/***should display: [Funny Book!, cool!, OK!, Old book!] ==> OK!***/
		System.out.println(product1.getNotes().toString());
		/***should display: [4.5, 4.0, 3.0, 1.5] ==> OK!***/
	}

}
