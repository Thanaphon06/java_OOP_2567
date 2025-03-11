import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class RestaurantReviewApp {
    private JFrame frame;
    private DefaultListModel<String> restaurantListModel;
    private ArrayList<Restaurant> restaurants;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                RestaurantReviewApp window = new RestaurantReviewApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public RestaurantReviewApp() {
        frame = new JFrame("Restaurant Review App");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        restaurants = new ArrayList<>();
        restaurantListModel = new DefaultListModel<>();

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout());

        JButton btnAddRestaurant = new JButton("Add Restaurant");
        panel.add(btnAddRestaurant);

        JList<String> restaurantList = new JList<>(restaurantListModel);
        frame.getContentPane().add(new JScrollPane(restaurantList), BorderLayout.CENTER);

        btnAddRestaurant.addActionListener(e -> addRestaurant());

        restaurantList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedRestaurantName = restaurantList.getSelectedValue();
                showRestaurantDetails(selectedRestaurantName);
            }
        });

        try {
            loadRestaurants();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRestaurants() throws IOException {
        // Load restaurant data (from a file)
        restaurants = Restaurant.loadRestaurantsFromFile();

        // Update the list model
        for (Restaurant restaurant : restaurants) {
            restaurantListModel.addElement(restaurant.getName());
        }
    }

    private void addRestaurant() {
        String name = JOptionPane.showInputDialog("Please enter restaurant name:");
        String imagePath = JOptionPane.showInputDialog("Please enter the restaurant image path:");

        if (name != null && !name.isEmpty() && imagePath != null && !imagePath.isEmpty()) {
            try {
                Restaurant newRestaurant = new Restaurant(name, imagePath);
                newRestaurant.saveRestaurantToFile();
                restaurants.add(newRestaurant);
                restaurantListModel.addElement(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showRestaurantDetails(String restaurantName) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                JFrame detailsFrame = new JFrame(restaurant.getName());
                detailsFrame.setSize(400, 400);

                JPanel detailsPanel = new JPanel();
                detailsFrame.add(detailsPanel, BorderLayout.CENTER);
                detailsPanel.setLayout(new BorderLayout());

                // Show image
                JLabel imageLabel = new JLabel(new ImageIcon(restaurant.getImagePath()));
                detailsPanel.add(imageLabel, BorderLayout.NORTH);

                // Show reviews
                JTextArea reviewArea = new JTextArea();
                try {
                    RestaurantReview.loadReviewsFromFile(restaurantName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                reviewArea.setEditable(false);
                detailsPanel.add(new JScrollPane(reviewArea), BorderLayout.CENTER);

                // Submit review button
                JPanel buttonPanel = new JPanel();
                JButton btnSubmitReview = new JButton("Submit Review");
                buttonPanel.add(btnSubmitReview);
                detailsPanel.add(buttonPanel, BorderLayout.SOUTH);

                btnSubmitReview.addActionListener(e -> {
                    // Open dialog for review input
                    openReviewDialog(restaurant);
                });

                detailsFrame.setVisible(true);
                break;
            }
        }
    }

    private void openReviewDialog(Restaurant restaurant) {
        JTextField reviewField = new JTextField(20);
        JComboBox<Integer> ratingBox = new JComboBox<>();
        for (int i = 1; i <= 5; i++) {
            ratingBox.addItem(i);
        }

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
        dialogPanel.add(new JLabel("Enter your review:"));
        dialogPanel.add(reviewField);
        dialogPanel.add(new JLabel("Rating:"));
        dialogPanel.add(ratingBox);

        int option = JOptionPane.showConfirmDialog(frame, dialogPanel, "Submit Your Review", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String reviewText = reviewField.getText();
            int rating = (int) ratingBox.getSelectedItem();

            if (!reviewText.isEmpty()) {
                try {
                    RestaurantReview review = new RestaurantReview(restaurant.getName(), reviewText, rating);
                    review.saveReviewToFile();

                    // Update review display
                    showRestaurantDetails(restaurant.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a review.");
            }
        }
    }
}
