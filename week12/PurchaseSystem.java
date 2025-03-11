import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Currency class for simplicity
class Currency {
    private double amount;

    public Currency(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%.2f", amount);
    }
}

// ProductUnity class
class ProductUnity {
    private int idProdUnity;
    private String unityAbbreviation;
    private String description;

    public ProductUnity(int idProdUnity, String unityAbbreviation, String description) {
        this.idProdUnity = idProdUnity;
        this.unityAbbreviation = unityAbbreviation;
        this.description = description;
    }
}

// Product class
class Product {
    private String idProduct;
    private String description;
    private float taxableQuantity;
    private Currency unityPrice;
    private ProductUnity taxUnity;
    private ProductUnity comUnity;

    public Product(String idProduct, String description, float taxableQuantity, Currency unityPrice, ProductUnity taxUnity, ProductUnity comUnity) {
        this.idProduct = idProduct;
        this.description = description;
        this.taxableQuantity = taxableQuantity;
        this.unityPrice = unityPrice;
        this.taxUnity = taxUnity;
        this.comUnity = comUnity;
    }

    public String getDescription() {
        return description;
    }

    public Currency getUnityPrice() {
        return unityPrice;
    }
}

// PaymentMethod class
class PaymentMethod {
    private int idPayMethod;
    private String description;
    private Currency credit;

    public PaymentMethod(int idPayMethod, String description, Currency credit) {
        this.idPayMethod = idPayMethod;
        this.description = description;
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }
}

// Seller class
class Seller {
    private int idSeller;
    private String sellerName;

    public Seller(int idSeller, String sellerName) {
        this.idSeller = idSeller;
        this.sellerName = sellerName;
    }

    public String getSellerName() {
        return sellerName;
    }
}

// PurchaseItem class
class PurchaseItem {
    private int idPurchItem;
    private float productQuantity;
    private Currency amountPaid;
    private Product product;

    public PurchaseItem(int idPurchItem, float productQuantity, Currency amountPaid, Product product) {
        this.idPurchItem = idPurchItem;
        this.productQuantity = productQuantity;
        this.amountPaid = amountPaid;
        this.product = product;
    }

    @Override
    public String toString() {
        return product.getDescription() + " x" + productQuantity + " - Paid: " + amountPaid;
    }
}

// PurchaseFinisher class
class PurchaseFinisher {
    private Currency amountPaid;
    private PaymentMethod payMethod;

    public PurchaseFinisher(Currency amountPaid, PaymentMethod payMethod) {
        this.amountPaid = amountPaid;
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "Paid: " + amountPaid + " with " + payMethod.getDescription();
    }
}

// Purchase class
class Purchase {
    private long idPurchase;
    private Date timestamp;
    private Currency totalPurchase;
    private Seller seller;
    private List<PurchaseItem> items;
    private List<PurchaseFinisher> finishers;

    public Purchase(long idPurchase, Date timestamp, Currency totalPurchase, Seller seller) {
        this.idPurchase = idPurchase;
        this.timestamp = timestamp;
        this.totalPurchase = totalPurchase;
        this.seller = seller;
        this.items = new ArrayList<>();
        this.finishers = new ArrayList<>();
    }

    public void addItem(PurchaseItem item) {
        items.add(item);
    }

    public void addFinisher(PurchaseFinisher finisher) {
        finishers.add(finisher);
    }

    public void printPurchaseDetails() {
        System.out.println("Purchase ID: " + idPurchase);
        System.out.println("Date: " + timestamp);
        System.out.println("Seller: " + seller.getSellerName());
        System.out.println("Total: " + totalPurchase);
        System.out.println("Items:");
        for (PurchaseItem item : items) {
            System.out.println("- " + item);
        }
        System.out.println("Payments:");
        for (PurchaseFinisher finisher : finishers) {
            System.out.println("- " + finisher);
        }
    }
}

public class PurchaseSystem {
    public static void main(String[] args) {
        Seller seller = new Seller(1, "John's Store");
        ProductUnity kgUnity = new ProductUnity(1, "kg", "Kilogram");
        Product product = new Product("P001", "Sugar", 50, new Currency(100), kgUnity, kgUnity);

        Purchase purchase = new Purchase(101, new Date(), new Currency(500), seller);
        PurchaseItem item = new PurchaseItem(1, 5, new Currency(500), product);
        purchase.addItem(item);

        PaymentMethod cash = new PaymentMethod(1, "Cash", new Currency(1000));
        PurchaseFinisher finisher = new PurchaseFinisher(new Currency(500), cash);
        purchase.addFinisher(finisher);

        purchase.printPurchaseDetails();
    }
}