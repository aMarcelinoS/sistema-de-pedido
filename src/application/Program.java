package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat ("dd/MM/yyyy");
		
		
		
		//PART 1
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/AAAA): ");
		Date birthDate = sdf1.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		System.out.println();
		
			
		//PART 2
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		//PART 3
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Enter #"+i+" item data:");
			System.out.printf("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product (productName, productPrice);
			OrderItem item = new OrderItem (quantity, productPrice, product); 
			
			order.addItem(item);
		}
		
		//PART 4
		System.out.println();
		System.out.println(order);
			
		
		sc.close();
	}

}
