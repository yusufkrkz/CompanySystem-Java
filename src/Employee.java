import java.util.Calendar;

// Employee class extends Person class, representing an employee in an organization
public class Employee extends Person {
	private double salary;            // Salary of the employee
	private Calendar hireDate;        // Date when the employee was hired
	private Department department;    // Department where the employee works
	public static int numberOfEmployees;  // Static field to keep track of the total number of employees

	// Constructor to initialize Employee using personal information and job details
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, 
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);  // Call the Person constructor
		setSalary(salary);   // Set salary with validation
		setHireDate(hireDate);   // Set hire date
		setDepartment(department);  // Set department with validation
	}

	// Constructor to initialize Employee using a Person object and job details
	public Employee(Person person, double salary, Calendar hireDate, Department department) {
		this(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.isHasDriverLicence(), salary, hireDate, department);  // Reuse the first constructor
	}

	// Getter for salary
	public double getSalary() {
		return salary;
	}

	// Setter for salary with validation (salary must be positive)
	public void setSalary(double salary) {
		if (salary <= 0)
			throw new IllegalArgumentException("salary must be positive.");
		this.salary = salary;
	}

	// Getter for hire date
	public Calendar getHireDate() {
		return hireDate;
	}

	// Setter for hire date
	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	// Getter for department
	public Department getDepartment() {
		return department;
	}

	// Setter for department with validation (department cannot be null)
	public void setDepartment(Department department) {
		if (department != null)
			this.department = department;
		else
			throw new NullPointerException("department holds null value.");
	}

	// Static getter for number of employees
	public static int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	// Static setter for number of employees with validation (number must be positive)
	public static void setNumberOfEmployees(int numberOfEmployees) {
		if (numberOfEmployees <= 0)
			throw new IllegalArgumentException("numberOfEmployees must be positive.");
		Employee.numberOfEmployees = numberOfEmployees;
	}

	// Method to raise salary by a percentage (positive percentage only)
	public double raiseSalary(double percent) {
		if (percent >= 0)
			this.salary += salary * percent;  // Increase salary by the given percentage
		else
			throw new IllegalArgumentException("percent must be positive.");
		return salary;
	}

	// Method to raise salary by a fixed amount (positive amount only)
	public double raiseSalary(int amount) {
		if (amount >= 0)
			this.salary += amount;  // Increase salary by the given amount
		else
			throw new IllegalArgumentException("amount must be positive.");
		return salary;
	}

	// Override the toString method to return employee information in a readable format
	@Override
	public String toString() {
		return "Employee Info [salary=" + ((Math.round(salary * 100.0)) / 100.0) + ", hireDate="
				+ Test.calendarToString(hireDate) + "]\n\t\t\t\t";  // Round salary to 2 decimal places
	}
}
