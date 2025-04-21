import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee {
    // List of products sold by the sales employee
	private ArrayList<Product> sales = new ArrayList<Product>();
    // Static variable to track the number of SalesEmployee instances
	public static int numberOfSalesEmployees;

    // Constructor to initialize a SalesEmployee object with sales information
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double pScore, ArrayList<Product> s) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				pScore); // Calls the parent class (RegularEmployee) constructor
		this.sales = s; // Initializes the sales list
	}

    // Constructor to create a SalesEmployee from an existing RegularEmployee and sales list
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
		// Passes the RegularEmployee's details to the main constructor
		this(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
				re.isHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore(),
				s);
	}

    // Adds a product to the sales list
	public boolean addSale(Product s) {
		sales.add(s); // Adds the product to the sales list
		return true; // Returns true to indicate the sale was added
	}

    // Removes a product from the sales list
	public boolean removeSale(Product s) {
		sales.remove(s); // Removes the product from the sales list
		return true; // Returns true to indicate the sale was removed
	}

    // Returns the list of products sold
	public ArrayList<Product> getSales() {
		return sales; // Returns the sales list
	}

    // Sets the list of products sold
	public void setSales(ArrayList<Product> sales) {
		this.sales = sales; // Sets the sales list
	}

    // Returns the number of SalesEmployee instances
	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees; // Returns the static count of SalesEmployee instances
	}

    // Sets the number of SalesEmployee instances
	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees; // Sets the static count of SalesEmployee instances
	}

    // Overrides the toString() method to include sales information
	@Override
	public String toString() {
		return super.toString() + sales.toString(); // Calls the parent toString() and appends the sales list
	}

    // Calculates and returns the total price of all sales made by the employee
	public double totalPriceOfSales() {
		double sum = 0;
		// Loops through the sales list to calculate the total price
		for (int i = 0; i < sales.size(); i++) {
			sum += sales.get(i).getPrice(); // Adds the price of each product to the sum
		}
		return sum; // Returns the total price of all sales
	}
}
