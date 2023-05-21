package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		List<Product> productList = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();

		for (int i = 1; i <= numberProducts; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (typeProduct == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				productList.add(new ImportedProduct(name, price, customsFee));
			} else if (typeProduct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureDate = sc.next();
				productList.add(new UsedProduct(name, price, sdf.parse(manufactureDate)));
			} else {
				productList.add(new Product(name, price));
			}

			System.out.println();
		}

		System.out.println("PRICE TAGS:");

		for (Product obj : productList) {
			System.out.println(obj.priceTag());
		}

		sc.close();
	}

}
