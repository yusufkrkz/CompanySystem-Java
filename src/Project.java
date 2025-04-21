import java.util.Calendar;

// Project class represents a project with a name, start date, and state (open or closed)
public class Project {
	private String projectName;  // Name of the project
	private Calendar startDate;  // Start date of the project
	private boolean state;      // State of the project: true = Open, false = Closed

	// Constructor to initialize the project with a name, start date, and state
	public Project(String pName, Calendar startDate, String state) {
		this.setProjectName(pName);  // Set the project name with validation
		this.setStardDate(startDate);  // Set the start date
		setState(state);  // Set the state ("Open" or "Close")
	}

	// Setter for the state with validation, converts string to boolean
	public void setState(String state) {
		// If the state is "Open", set the boolean state to true
		if (state.equals("Open"))
			this.state = true;
		// If the state is "Close", set the boolean state to false
		if (state.equals("Close"))
			this.state = false;
	}

	// Getter for the state, returns "Open" or "Close" based on boolean value
	public String getState() {
		// If the state is true, return "Open"; otherwise return "Close"
		if (state == true)
			return "Open";
		else
			return "Close";
	}

	// Method to close the project by setting the state to false
	public void close() {
		// If the project is open (true), set it to closed (false)
		if (state == true)
			state = false;
	}

	// Getter for the project name
	public String getProjectName() {
		return projectName;
	}

	// Setter for project name with validation (minimum length of 3 characters)
	public void setProjectName(String projectName) {
		try {
			// Ensure project name is not null and is at least 3 characters long
			if (projectName != null && projectName.length() >= 3) {
				this.projectName = projectName;
			} else {
				// Throw exception if the project name is less than 3 characters
				throw new IllegalArgumentException("projectName should be no less than 3 symbols.");
			}
		} catch (Exception e) {
			// Print the stack trace and terminate the program if validation fails
			e.printStackTrace();
			System.exit(1);
		}
	}

	// Getter for the start date of the project
	public Calendar getStardDate() {
		return startDate;
	}

	// Setter for the start date of the project
	public void setStardDate(Calendar stardDate) {
		this.startDate = stardDate;
	}

	// Override toString method to provide a string representation of the project
	@Override
	public String toString() {
		// Return formatted project details (name, start date, and state)
		return "Project [projectName=" + projectName + ", startDate=" + Test.calendarToString(startDate) + ", state="
				+ state + "]";
	}
}
