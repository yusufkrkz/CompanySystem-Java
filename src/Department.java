
// Department class represents a department in an organization, identified by ID and name.
public class Department {
	private int departmentID;        // Unique identifier for the department
	private String departmentName;   // Name of the department

	// Constructor to initialize department with ID and name
	public Department(int departmentID, String departmentName) {
		this.setDepartmentID(departmentID);
		this.setDepartmentName(departmentName);
	}

	// Getter for department ID
	public int getDepartmentID() {
		return departmentID;
	}

	// Setter for department ID with validation
	public void setDepartmentID(int departmentID) {
		if (departmentID <= 0)
			throw new IllegalArgumentException("departmentID must be positive.");
		this.departmentID = departmentID;
	}

	// Getter for department name
	public String getDepartmentName() {
		return departmentName;
	}

	// Setter for department name with validation (must be at least 3 characters)
	public void setDepartmentName(String departmentName) {
		if (departmentName != null && departmentName.length() >= 3) {
			this.departmentName = departmentName;
		} else {
			throw new IllegalArgumentException("departmentName should be no less than 3 symbols.");
		}
	}

	// String representation of the Department object
	@Override
	public String toString() {
		String str = "************************************************\n";
		str += "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + "]\n";
		return str;
	}
}
