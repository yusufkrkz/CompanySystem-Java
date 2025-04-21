import java.util.*;

// RegularEmployee class extends Employee and adds performance score and bonus
public class RegularEmployee extends Employee {
	private double performanceScore;  // Performance score of the employee
	private double bonus;            // Bonus amount for the employee

	// Constructor that initializes a RegularEmployee with all necessary fields
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double performanceScore) {
		// Call the superclass (Employee) constructor
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setPerformanceScore(performanceScore);  // Set the performance score
	}

	// Constructor that creates a RegularEmployee from an existing Employee object
	public RegularEmployee(Employee employee, double perfScore) {
		// Delegate to the main constructor using values from the Employee object
		this(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(),
				employee.getBirthDate(), employee.getMaritalStatus(), employee.isHasDriverLicence(),
				employee.getSalary(), employee.getHireDate(), employee.getDepartment(), perfScore);
	}

	// Getter for performance score
	public double getPerformanceScore() {
		return performanceScore;
	}

	// Setter for performance score with validation
	public void setPerformanceScore(double performanceScore) {
		// If the performance score is non-positive, throw an exception
		if (performanceScore <= 0)
			throw new IllegalArgumentException("performanceScore must be positive.");
		this.performanceScore = performanceScore;
	}

	// Getter for bonus
	public double getBonus() {
		return bonus;
	}

	// Setter for bonus with validation
	public void setBonus(double bonus) {
		// If the bonus is non-positive, throw an exception
		if (bonus <= 0)
			throw new IllegalArgumentException("bonus must be positive.");
		this.bonus = bonus;
	}

	// Override toString method to include regular employee-specific information
	@Override
	public String toString() {
		// Call the superclass's toString method and append regular employee info
		return super.toString() + "RegularEmployee Info [performanceScore=" + performanceScore + ", bonus="
				+ ((Math.round(bonus * 100.0)) / 100.0) + "]\n\t\t\t\t";
	}
}
