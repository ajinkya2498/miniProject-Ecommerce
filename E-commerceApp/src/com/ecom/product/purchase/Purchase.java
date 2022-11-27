package com.ecom.product.purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecom.database.user.insert.AddCart;
import com.ecom.database.user.insert.GetALLProducts;

public class Purchase {
	String name;
	int userid;

	public Purchase(String name ,int userid) {
		super();
		this.name = name;
		this.userid=userid;
	}

	public void getPurchase() throws SQLException {
	Scanner sc=new Scanner(System.in);
	GetALLProducts gt=new GetALLProducts();
	gt.getProducts();
	AddCart ac1=new AddCart();
	ac1.AddtoCart(name,userid);
	while(true){
	System.out.println("press 1 to add more prodcuct press 2to for billing or or calculate  final total Bill,Please relogin");
	int mode=sc.nextInt();
	switch(mode) {
	case 1:
		AddCart ac=new AddCart();
		ac.AddtoCart(name,userid);
		break;
	case 2:
		CalculateTotal calculateTotal = new CalculateTotal();
		
		calculateTotal.totalBill(userid);
		break;
	default:
		
		System.out.println("Please Select Correct Option to proceed further");
	}
}}


}
