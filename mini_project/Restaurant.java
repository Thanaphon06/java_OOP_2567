import java.io.*;
import java.util.*;

public class Restaurant {
    private String name;
    private String imagePath;
    private ArrayList<RestaurantReview> reviews;

    public Restaurant(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public ArrayList<RestaurantReview> getReviews() {
        return reviews;
    }

    public void addReview(RestaurantReview review) {
        reviews.add(review);
    }

    // Method to save restaurant details to the file
    public void saveRestaurantToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("restaurants.txt", true))) {
            writer.write(name + "," + imagePath);
            writer.newLine();
        }
    }

    // Static method to load restaurants from the file
    public static ArrayList<Restaurant> loadRestaurantsFromFile() throws IOException {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        File file = new File("restaurants.txt");
        if (!file.exists()) {
            return restaurants;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("restaurants.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String imagePath = data[1];
                Restaurant restaurant = new Restaurant(name, imagePath);
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }
}
