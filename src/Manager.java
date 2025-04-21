import java.util.ArrayList;
import java.util.Calendar;

// Manager class extends Employee class, representing a manager who oversees employees
public class Manager extends Employee {

	// List to hold the employees under this manager (specifically RegularEmployee objects)
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
	// Total bonus budget available for this manager to distribute to employees
	private double bonusBudget;

	// Constructor to initialize Manager using personal information, job details, and bonus budget
	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department); // Call the Employee constructor
		setBonusBudget(bonusBudget); // Set bonus budget with validation
	}

	// Constructor to initialize Manager using an existing Employee object and a bonus budget
	public Manager(Employee employee, double bonusBudget) {
		this(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(),
				employee.getBirthDate(), employee.getMaritalStatus(), employee.isHasDriverLicence(),
				employee.getSalary(), employee.getHireDate(), employee.getDepartment(), bonusBudget); // Reuse first constructor
	}

	// Getter for regularEmployees list
	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	// Setter for regularEmployees with validation (ArrayList cannot be null)
	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		if (regularEmployees != null)
			this.regularEmployees = regularEmployees;
		else
			throw new NullPointerException("regularEmployees ArrayList holds null value");
	}

	// Getter for bonusBudget
	public double getBonusBudget() {
		return bonusBudget;
	}

	// Setter for bonusBudget with validation (bonusBudget must be positive)
	public void setBonusBudget(double bonusBudget) {
		if (bonusBudget <= 0)
			throw new IllegalArgumentException("bonusBudget must be positive.");
		this.bonusBudget = bonusBudget;
	}

	// Method to add a RegularEmployee to the list if not already present
	public void addEmployee(RegularEmployee e) {
		if (!regularEmployees.contains(e))
			regularEmployees.add(e);
	}

	// Method to remove a RegularEmployee from the list
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}

	// Method to distribute the bonus budget among employees based on their performance scores
	public void distributeBonusBudget() {
		int sum = 0;
		// Calculate the total sum of salary * performance score for all regular employees
		for (RegularEmployee regularEmployee : regularEmployees) {
			sum += (regularEmployee.getSalary()) * (regularEmployee.getPerformanceScore());
		}

		// Calculate the unit amount to distribute based on the total bonus budget
		double unit = bonusBudget / sum;

		// Distribute bonus to each regular employee based on their salary and performance score
		for (RegularEmployee regularEmployee : regularEmployees) {
			double bonus = unit * regularEmployee.getSalary() * regularEmployee.getPerformanceScore();
			regularEmployee.setBonus(bonus);
		}
	}

	// Override the toString method to provide a detailed report of the manager and their employees
	@Override
	public String toString() {
		// String for manager info
		String strManager = "	Manager [id: " + this.getId() + ", " + this.getFirstName() + " " + this.getLastName()
				+ "\n		# of Employees: " + regularEmployees.size() + "]";

		// Initialize strings to hold different types of employees' information
		String developerInfo = "";
		String salesEmployeeInfo = "";
		String regularEmployeeInfo = "";
		int no = 1;

		// Iterate over regular employees to separate by type (Developer, SalesEmployee, etc.)
		for (int i = 0; i < regularEmployees.size(); i++) {
			if (regularEmployees.get(i) instanceof Developer) {
				developerInfo += "\n\t\t\t" + no + ". " + "Developer \n\t\t\t\tPerson Info[id="
						+ regularEmployees.get(i).getId() + ", firstName=" + regularEmployees.get(i).getFirstName()
						+ ", lastName=" + regularEmployees.get(i).getLastName() + ", gender="
						+ regularEmployees.get(i).getGender() + "]\n\t\t\t\t" + regularEmployees.get(i).toString();
				no++;
			}
		}

		// Gather information on SalesEmployees
		for (int i = 0; i < regularEmployees.size(); i++) {
			if (regularEmployees.get(i) instanceof SalesEmployee) {
				salesEmployeeInfo += "\n\t\t\t" + no + ". " + "SalesEmployee \n\t\t\t\tPerson Info[id="
						+ regularEmployees.get(i).getId() + ", firstName=" + regularEmployees.get(i).getFirstName()
						+ ", lastName=" + regularEmployees.get(i).getLastName() + ", gender="
						+ regularEmployees.get(i).getGender() + "]\n\t\t\t\t" + regularEmployees.get(i).toString();
				no++;
			}
		}

		// Gather information on other RegularEmployees (excluding Developer and SalesEmployee)
		for (int i = 0; i < regularEmployees.size(); i++) {
			if (regularEmployees.get(i) instanceof RegularEmployee && !(regularEmployees.get(i) instanceof Developer)
					&& !(regularEmployees.get(i) instanceof SalesEmployee)) {
				regularEmployeeInfo += "\n\t\t\t" + no + ". " + "RegularEmployee \n\t\t\t\tPerson Info[id="
						+ regularEmployees.get(i).getId() + ", firstName=" + regularEmployees.get(i).getFirstName()
						+ ", lastName=" + regularEmployees.get(i).getLastName() + ", gender="
						+ regularEmployees.get(i).getGender() + "]\n\t\t\t\t" + "Employee Info [salary="
						+ regularEmployees.get(i).getSalary() + ", hireDate="
						+ Test.calendarToString(regularEmployees.get(i).getHireDate()) + "]\n\t\t\t\t"
						+ "RegularEmployee Info [performanceScore=" + regularEmployees.get(i).getPerformanceScore()
						+ ", bonus=" + regularEmployees.get(i).getBonus() + "]";
				no++;
			}
		}

		// Return the complete information about the manager and their employees
		return strManager + developerInfo + salesEmployeeInfo + regularEmployeeInfo + "\n\n";
	}
}
