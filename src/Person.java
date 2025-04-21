import java.util.Calendar;

// Person class models basic personal and identity information.
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private byte gender; // 1 = Woman, 2 = Man
    private Calendar birthDate;
    private byte maritalStatus; // 1 = Single, 2 = Married
    private boolean hasDriverLicence; // true if the person has a driver's license

    // Constructor initializes the fields using setter methods for validation
    public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, 
                  String maritalStatus, String hasDriverLicence) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setBirthDate(birthDate);
        setMaritalStatus(maritalStatus);
        setHasDriverLicence(hasDriverLicence);
    }

    // Returns the ID
    public int getId() {
        return id;
    }

    // Sets the ID; must be a positive number
    public void setId(int id) {
        try {
            if (id <= 0)
                throw new IllegalArgumentException("ID must be positive.");
            this.id = id;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Returns gender as a string: "Woman" or "Man"
    public String getGender() {
        return (this.gender == 1) ? "Woman" : "Man";
    }

    // Sets gender using a case-insensitive string input
    public void setGender(String gender) {
        try {
            if (gender.equalsIgnoreCase("Woman"))
                this.gender = 1;
            else if (gender.equalsIgnoreCase("Man"))
                this.gender = 2;
            else
                throw new IllegalArgumentException("Gender should be either 'Man' or 'Woman'.");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Returns marital status as "Single" or "Married"
    public String getMaritalStatus() {
        return (this.maritalStatus == 1) ? "Single" : "Married";
    }

    // Sets marital status using string input: "Single" or "Married"
    public void setMaritalStatus(String maritalStatus) {
        try {
            if (maritalStatus.equalsIgnoreCase("Single"))
                this.maritalStatus = 1;
            else if (maritalStatus.equalsIgnoreCase("Married"))
                this.maritalStatus = 2;
            else
                throw new IllegalArgumentException("Marital status should be either 'Single' or 'Married'.");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Returns the first name
    public String getFirstName() {
        return firstName;
    }

    // Sets first name; must be at least 3 characters
    public void setFirstName(String firstName) {
        try {
            if (firstName != null && firstName.length() >= 3) {
                this.firstName = firstName;
            } else {
                throw new IllegalArgumentException("First name must have at least 3 characters.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Returns the last name
    public String getLastName() {
        return lastName;
    }

    // Sets last name; must be at least 3 characters
    public void setLastName(String lastName) {
        try {
            if (lastName != null && lastName.length() >= 3) {
                this.lastName = lastName;
            } else {
                throw new IllegalArgumentException("Last name must have at least 3 characters.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Returns birth date as Calendar object
    public Calendar getBirthDate() {
        return birthDate;
    }

    // Sets the birth date
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    // Returns driver's license status as "Yes" or "No"
    public String isHasDriverLicence() {
        return hasDriverLicence ? "Yes" : "No";
    }

    // Sets driver's license status using string input: "Yes" or "No"
    public void setHasDriverLicence(String hasDriverLicence) {
        this.hasDriverLicence = hasDriverLicence.equalsIgnoreCase("Yes");
    }

    // Returns string representation of the person with formatted attributes
    @Override
    public String toString() {
        return "Person [id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", gender=" + this.getGender() +
                ", birthDate=" + Test.calendarToString(birthDate) +
                ", maritalStatus=" + this.getMaritalStatus() +
                ", hasDriverLicence=" + this.isHasDriverLicence() + "]\n";
    }
}
