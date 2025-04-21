import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

// This program illustrate simple company hierarchy and reads an input file and writes to resulting output.
public class Test {

	public static void main(String[] args) throws IOException {

		ArrayList<Person> persons = new ArrayList<>();
		ArrayList<Department> departments = new ArrayList<>();
		ArrayList<Project> projects = new ArrayList<>();
		ArrayList<Product> products = new ArrayList<>();

		File file = new File("input.txt");
		Scanner input = new Scanner(file);

		int mainIndex = 0;

		while (input.hasNext()) {
			String str = input.nextLine();
			String[] tokens = str.split("\s");

			switch (tokens[0]) {
			case "Department":
				departments.add(new Department(Integer.parseInt(tokens[1]), tokens[2]));
				break;
			case "Project":
				projects.add(new Project(tokens[1], stringToCalendar(tokens[2]), tokens[3]));

				break;
			case "Product":
				products.add(new Product(tokens[1], stringToCalendar(tokens[2]), Double.parseDouble(tokens[3])));

				break;
			case "Person":
				persons.add(new Person(Integer.parseInt(tokens[3]), tokens[1], tokens[2], tokens[4],
						stringToCalendar(tokens[5]), tokens[6], tokens[7]));

				break;
			case "Employee":
				int index = 0;
				for (int i = 0; i < persons.size(); i++) {
					if (persons.get(i).getId() == Integer.parseInt(tokens[1]))
						index = i;
					
				}
				int index2 = 0;
				for (int i = 0; i < departments.size(); i++) {
					if ((departments.get(i).getDepartmentName().equals(tokens[4])))
						index2 = i;
				}

				persons.set(index, new Employee(persons.get(index), Integer.parseInt(tokens[2]),
						stringToCalendar(tokens[3]), departments.get(index2)));
				Employee.numberOfEmployees++;
				break;
			case "Manager":
				int indexOfManager = 0;
				for (int i = 0; i < persons.size(); i++) {
					if (persons.get(i).getId() == Integer.parseInt(tokens[1]))
						indexOfManager = i;
				}

				persons.set(indexOfManager,
						new Manager((Employee) persons.get(indexOfManager), Integer.parseInt(tokens[2])));
				
				break;
			case "RegularEmployee":
				int indexOfRegularEmployee = 0;
				for (int i = 0; i < persons.size(); i++) {
					if (persons.get(i).getId() == Integer.parseInt(tokens[1]))
						indexOfRegularEmployee = i;
				}

				persons.set(indexOfRegularEmployee, new RegularEmployee((Employee) persons.get(indexOfRegularEmployee),
						Integer.parseInt(tokens[2])));
				
				break;
			case "Developer":
				int indexOfDeveloper = 0;
				for (int i = 0; i < persons.size(); i++) {
					if (persons.get(i).getId() == Integer.parseInt(tokens[1]))
						indexOfDeveloper = i;
				}
				ArrayList<Project> tempList = new ArrayList<Project>();
				for (int i = 2; i < tokens.length; i++) {
					for (int j = 0; j < projects.size(); j++) {
						if (projects.get(j).getProjectName().equals(tokens[i]))
							tempList.add(projects.get(j));
					}
				}

				persons.set(indexOfDeveloper, new Developer((RegularEmployee) persons.get(indexOfDeveloper), tempList));
				Developer.numberOfDevelopers++;
				break;
			case "SalesEmployee":
				int indexOfSalesEmployee = 0;
				for (int i = 0; i < persons.size(); i++) {
					if (persons.get(i).getId() == Integer.parseInt(tokens[1]))
						indexOfSalesEmployee = i;
				}
				ArrayList<Product> tempList2 = new ArrayList<Product>();
				for (int i = 2; i < tokens.length; i++) {
					for (int j = 0; j < products.size(); j++) {
						if (products.get(j).getProductName().equals(tokens[i]))
							tempList2.add(products.get(j));
					}
				}

				persons.set(indexOfSalesEmployee,
						new SalesEmployee((RegularEmployee) persons.get(indexOfSalesEmployee), tempList2));
				SalesEmployee.numberOfSalesEmployees++;
				break;

			case "Customer":
				int indexOfCustomer = 0;
				for (int i = 0; i < persons.size(); i++) {
					if (persons.get(i).getId() == Integer.parseInt(tokens[1]))
						indexOfCustomer = i;
				}
				ArrayList<Product> tempList3 = new ArrayList<Product>();
				for (int i = 2; i < tokens.length; i++) {
					for (int j = 0; j < products.size(); j++) {
						if (products.get(j).getProductName().equals(tokens[i]))
							tempList3.add(products.get(j));
					}
				}

				persons.set(indexOfCustomer, new Customer(persons.get(indexOfCustomer), tempList3));
				((Customer) persons.get(indexOfCustomer)).setCreateIndex(mainIndex);
				mainIndex++;
				break;

			default:
				System.out.println("Cannot found.");
				break;
			}
		}

		for (int i = 0; i < persons.size(); i++) {
			for (int j = 0; j < persons.size(); j++) {
				if (persons.get(i) instanceof Manager) {
					if (persons.get(j) instanceof Developer || persons.get(j) instanceof RegularEmployee
							|| persons.get(j) instanceof SalesEmployee) {
						if (((Manager) persons.get(i)).getDepartment()
								.getDepartmentID() == ((RegularEmployee) persons.get(j)).getDepartment()
										.getDepartmentID()) {

							((Manager) persons.get(i)).addEmployee((RegularEmployee) persons.get(j));
						}
					}

				}

			}

		}

		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i) instanceof Manager)
				((Manager) persons.get(i)).distributeBonusBudget();
		}
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i) instanceof Manager)
				((Manager) persons.get(i)).raiseSalary(0.2);
		}
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i) instanceof RegularEmployee && !(persons.get(i) instanceof Developer)
					&& !(persons.get(i) instanceof SalesEmployee))
				((RegularEmployee) persons.get(i)).raiseSalary(0.3);
		}
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i) instanceof Developer)
				((Developer) persons.get(i)).raiseSalary(0.23);
		}
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i) instanceof SalesEmployee)
				((SalesEmployee) persons.get(i)).raiseSalary(0.18);
		}
		int index = 0;
		double sum = 0;
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i) instanceof SalesEmployee)
				if (((SalesEmployee) persons.get(i)).totalPriceOfSales() > sum) {
					sum = ((SalesEmployee) persons.get(i)).totalPriceOfSales();
					index = persons.indexOf(persons.get(i));
				}
		}
		((SalesEmployee) persons.get(index)).raiseSalary(10000);

		// Printing toString methods
		File fileOutput = new File("output.txt");
		PrintWriter output = new PrintWriter(fileOutput);

		for (int i = 0; i < departments.size(); i++) {

			output.print(departments.get(i).toString());

			for (int j = 0; j < persons.size(); j++) {
				if (persons.get(j) instanceof Manager) {
					if (((Manager) persons.get(j)).getDepartment().getDepartmentID() == departments.get(i)
							.getDepartmentID())
						output.print(persons.get(j).toString());
				}

			}

		}

		for (int i = 0; i < persons.size() - 1; i++) {
			for (int j = i + 1; j < persons.size(); j++) {
				if (persons.get(j) instanceof Customer) {
					if (persons.get(i) instanceof Customer) {
						if (((Customer) persons.get(i)).getCreateIndex() > ((Customer) persons.get(j))
								.getCreateIndex()) {
							Person tempPerson = persons.get(i);
							persons.set(i, persons.get(j));
							persons.set(j, tempPerson);

						}
					}
				}
			}
		}

		output.print("\n\n**********************CUSTOMERS************************\n");
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i) instanceof Customer) {
				output.print(persons.get(i).toString());
			}

		}
		output.print("\n**********************PEOPLE************************\n");

		for (int i = 0; i < persons.size(); i++) {
			if (!(persons.get(i) instanceof Customer) && !(persons.get(i) instanceof Employee)) {
				output.print(persons.get(i).toString());
			}
		}

		output.close();
		input.close();

	}

	public static Calendar stringToCalendar(String string) {
		String[] strarr = string.split("/");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strarr[0]));
		calendar.set(Calendar.MONTH, Integer.parseInt(strarr[1]) - 1);
		calendar.set(Calendar.YEAR, Integer.parseInt(strarr[2]));
		return calendar;

	}

	public static String calendarToString(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		return day + "/" + month + "/" + year;

	}

}
