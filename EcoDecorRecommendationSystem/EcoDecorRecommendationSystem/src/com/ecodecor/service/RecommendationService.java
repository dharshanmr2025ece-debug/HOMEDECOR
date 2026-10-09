package com.ecodecor.service;

import java.util.ArrayList;
import java.util.List;

import com.ecodecor.model.Product;

public class RecommendationService {

    public List<Product> recommendProducts(
            List<Product> products,
            String preferredCategory,
            String preferredMaterial,
            String preferredStyle,
            double budget) {

        List<Product> recommendations = new ArrayList<>();

        for (Product product : products) {

            int score = 0;

            // Category matching
            if (product.getCategory().equalsIgnoreCase(preferredCategory)) {
                score += 30;
            }

            // Material matching
            if (product.getMaterial().equalsIgnoreCase(preferredMaterial)) {
                score += 30;
            }

            // Style matching
            if (product.getStyle().equalsIgnoreCase(preferredStyle)) {
                score += 20;
            }

            // Budget matching
            if (product.getPrice() <= budget) {
                score += 10;
            }

            // Eco-friendly score
            if (product.getEcoScore() >= 8) {
                score += 10;
            }

            // Recommend if score is 50 or above
            if (score >= 50) {
                recommendations.add(product);
            }
        }

        return recommendations;
    }
}