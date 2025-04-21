import java.util.ArrayList;
import java.util.Calendar;


// Developer is a subclass of RegularEmployee and represents an employee who works on multiple projects.
public class Developer extends RegularEmployee {
	private ArrayList<Project> projects; // List of projects the developer is assigned to
	public static int numberOfDevelopers; // Keeps track of total number of Developer instances (if used)

	// Constructor with all properties
	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore,
			ArrayList<Project> p) {
		// Call the superclass constructor (RegularEmployee)
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				pScore);
		this.projects = p; // Assign the list of projects to this developer
	}

	// Alternate constructor using an existing RegularEmployee object
	public Developer(RegularEmployee re, ArrayList<Project> p) {
		// Reuse data from the RegularEmployee and assign projects
		this(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(),
				re.isHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore(),
				p);
	}

	// Adds a new project to the developer's list
	public boolean addProject(Project p) {
		projects.add(p);
		return true;
	}

	// Removes a project from the developer's list
	public boolean removeProject(Project p) {
		projects.remove(p);
		return true;
	}

	// Returns the list of projects
	public ArrayList<Project> getProjects() {
		return projects;
	}

	// Sets a new list of projects
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	// Static getter for numberOfDevelopers (could be used to track count externally)
	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}

	// Static setter for numberOfDevelopers
	public static void setNumberOfDevelopers(int numberOfDevelopers) {
		Developer.numberOfDevelopers = numberOfDevelopers;
	}

	// Returns a string representation of the developer, including project list
	@Override
	public String toString() {
		return super.toString() + projects;
	}
}
