import java.util.ArrayList;
import java.util.Calendar;

// Customer class extends Person and represents a person who owns a list of products
public class Customer extends Person {

	private ArrayList<Product> products = new ArrayList<Product>(); // List of products owned by the customer
	public int createIndex = 0; // Optional index value, could be used for tracking creation order

	// Constructor that initializes all fields including the list of products
	public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, ArrayList<Product> products) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		setProducts(products);
	}

	// Constructor that builds a Customer object using a Person object and products
	public Customer(Person person, ArrayList<Product> products) {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.isHasDriverLicence());
		this.products = products;
	}

	// Returns the list of products owned by the customer
	public ArrayList<Product> getProducts() {
		return this.products;
	}

	// Sets the createIndex value
	public void setCreateIndex(int index) {
		this.createIndex = index;
	}

	// Returns the current value of createIndex
	public int getCreateIndex() {
		return this.createIndex;
	}

	// Sets the products list after checking that it's not null
	public void setProducts(ArrayList<Product> products) {
		if (products != null) {
			this.products = products;
		} else
			throw new NullPointerException("products Arraylist should not be null.");
	}

	// Custom string representation of the Customer object
	@Override
	public String toString() {
		return "Customer" + "[id: " + this.getId() + " products=" + products + "\n";
	}

}
