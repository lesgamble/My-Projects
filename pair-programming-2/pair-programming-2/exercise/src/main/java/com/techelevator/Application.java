package com.techelevator;



import java.util.*;
 public class Application {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();
    private List<Employee> engineerPeople = new ArrayList<>();
    private List<Employee> marketPeople = new ArrayList<>();
    /**
     * The main entry point in the application
     * @param args
     */

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the Teams project
        createTeamsProject();

        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department Marketing = new Department(1, "Marketing");
        departments.add(Marketing);
        Department Sales = new Department(2, "Sales");
        departments.add(Sales);
        Department Engineering = new Department(3, "Engineering");
        departments.add(Engineering);

    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i).getName());

        }

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee Dean = new Employee();
        Dean.setEmployeeId(1);
        Dean.setFirstName("Dean");
        Dean.setLastName("Johnson");
        Dean.setEmail("djohnson@teams.com");
        Dean.setSalary(Employee.STARTING_SALARY);
        Dean.setDepartment(departments.get(2));
        Dean.setHireDate("08/21/2020");

        Employee Angie = new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020");
        Angie.raiseSalary(10);


        Employee Margaret = new Employee(3, "Margaret", "Thompson", "nthompson@teams.com", departments.get(0), "08/21/2020");
        Margaret.setSalary(60000);



        employees.add(Dean);
        employees.add(Angie);
        employees.add(Margaret);

    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getFullName() + " (" + employees.get(i).getSalary() + ") " + employees.get(i).getDepartment().getName());

        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project TEams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020");
        for (Employee engineers : employees) {
            if (engineers.getDepartment().getName().equalsIgnoreCase("engineering")){
                engineerPeople.add(engineers);
            }

        }
            TEams.setTeamMembers(engineerPeople);
            projects.put(TEams.getName(), TEams);


    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project page = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020");

        for (Employee marketers : employees) {
            if (marketers.getDepartment().getName().equalsIgnoreCase("Marketing")){
                marketPeople.add(marketers);
            }

        }
        page.setTeamMembers(marketPeople);
        projects.put(page.getName(), page);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        System.out.println("TEams: " + engineerPeople.size());
        System.out.println("Marketing Landing Page: " + marketPeople.size());
    }

}
