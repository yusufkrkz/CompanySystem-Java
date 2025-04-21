import java.util.Calendar;

// Product class represents a product with a name, sale date, and price
public class Product {
	private String productName;  // Product name (e.g., "Laptop")
	private Calendar saleDate;   // The sale date of the product
	private double price;        // Price of the product

	// Constructor initializes product name, sale date, and price
	public Product(String sName, Calendar sDate, double price) {
		this.setProductName(sName);  // Set product name with validation
		this.setSaleDate(sDate);     // Set sale date
		this.setPrice(price);        // Set price with validation
	}

	// Getter for product name
	public String getProductName() {
		return productName;
	}

	// Setter for product name with validation (minimum length of 3 characters)
	public void setProductName(String productName) {
		if (productName != null && productName.length() >= 3) {
			this.productName = productName;
		} else {
			// Throw exception if the product name is less than 3 characters
			throw new IllegalArgumentException("productName should be no less than 3 symbols.");
		}
	}

	// Getter for sale date
	public Calendar getSaleDate() {
		return saleDate;
	}

	// Setter for sale date
	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	// Getter for price
	public double getPrice() {
		return price;
	}

	// Setter for price with validation (price must be positive)
	public void setPrice(double price) {
		if (price <= 0)
			// Throw exception if the price is not positive
			throw new IllegalArgumentException("price must be positive.");

		this.price = price;
	}

	// Override toString method to provide a string representation of the product
	@Override
	public String toString() {
		// Return formatted product details (name, sale date, and price)
		return "Product [productName=" + productName + ", transactionDate=" + Test.calendarToString(saleDate)
				+ ", price=" + ((Math.round(price * 100.0)) / 100.0) + "]]";
	}
}
