import java.io.*;
import java.util.*;

public class RestaurantReview {
    private String restaurantName;
    private String review;
    private int rating;  // Rating from 1 to 5

    public RestaurantReview(String restaurantName, String review, int rating) {
        this.restaurantName = restaurantName;
        this.review = review;
        this.rating = rating;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return "Restaurant: " + restaurantName + "\nReview: " + review + "\nRating: " + rating;
    }

    // Method to save review to a text file
    public void saveReviewToFile() throws IOException {
        String fileName = "reviews_" + restaurantName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(this.toString());
            writer.newLine();
        }
    }

    // Static method to load reviews from a file and return as a string
    public static String loadReviewsFromFile(String restaurantName) throws IOException {
        String fileName = "reviews_" + restaurantName + ".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            return "No reviews available for " + restaurantName + ".";
        }

        StringBuilder reviews = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reviews.append(line).append("\n");
            }
        }
        return reviews.toString();
    }
}
