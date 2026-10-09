package com.ecodecor.main;

import java.util.List;
import java.util.Scanner;

import com.ecodecor.dao.ProductDAO;
import com.ecodecor.model.Product;
import com.ecodecor.service.RecommendationService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Eco-Friendly Home Decor Recommendation System ===");

        System.out.print("Enter preferred category: ");
        String category = sc.nextLine();

        System.out.print("Enter preferred material: ");
        String material = sc.nextLine();

        System.out.print("Enter preferred style: ");
        String style = sc.nextLine();

        System.out.print("Enter your budget: ");
        double budget = sc.nextDouble();

        ProductDAO dao = new ProductDAO();

        List<Product> products = dao.getAllProducts();

        RecommendationService service = new RecommendationService();

        List<Product> recommendations =
                service.recommendProducts(
                        products,
                        category,
                        material,
                        style,
                        budget
                );

        System.out.println("\n=== Recommended Products ===");

        if (recommendations.isEmpty()) {

            System.out.println("No suitable products found.");

        } else {

            for (Product p : recommendations) {

                System.out.println("-----------------------------");
                System.out.println("Product: " + p.getName());
                System.out.println("Category: " + p.getCategory());
                System.out.println("Material: " + p.getMaterial());
                System.out.println("Style: " + p.getStyle());
                System.out.println("Price: ₹" + p.getPrice());
                System.out.println("Eco Score: " + p.getEcoScore());
            }
        }

        sc.close();
    }
}