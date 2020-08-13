package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i ++ ) {

            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i) ? ");
            char answer = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (answer == 'c') {
                products.add(new Product(name, price));
            } else if (answer == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufacturedDate = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, manufacturedDate));
            } else {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product prod : products) {
            System.out.println(prod.priceTag());
        }

        sc.close();

    }
}
