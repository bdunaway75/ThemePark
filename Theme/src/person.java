import java.util.Arrays;
import java.util.Random;

class Person {

    /**
     * The Person class represents a person in the theme park.
     * It provides methods to set and get the person's name, age, money, tickets,
     * and their presence in the park.
     */

    private String name; // Name of the person
    private int age; // Age of the person
    private int money; // Amount of money the person has
    private int tickets; // Number of tickets the person has
    private boolean inPark; // Indicates whether the person is in the park or not


    // Setter for the person's name
    public void setPerson(String name) {
        this.name = name;
    }

    // Getter for the person's name
    public String getPerson() {
        return this.name;
    }

    // Setter for the person's age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for the person's age
    public String getAge() {
        return String.valueOf(age);
    }


    /* Method that generates an array of people */
    public static Person[] generatePeople(int numOfPeople) {
        Person[] people = new Person[numOfPeople];

        // Array of possible names
        String[] names = {"Randal", "John Cena", "Jacob", "Marie", "G-Money"};

        Random random = new Random();

        for (int i = 0; i < numOfPeople; i++) {
            Person person = new Person();
            person.setPerson(names[random.nextInt(names.length)]);
            person.setAge(random.nextInt(90) + 1);
            people[i] = person;
        }

        return people;
    }

    // This method adds a person to an existing array of persons
    public Person[] addPerson(int index, Person[] persons, Person[] employees) {
        Person[] people = Arrays.copyOf(persons, persons.length + 1);
        people[people.length - 1] = employees[index];
        return people;
    }

    // Generating employees
    public static Person[] generateEmployees(int numOfEmployees) {
        Person[] employees = new Person[numOfEmployees];

        // Array of possible names
        String[] names = {"JasonV", "TimV", "TommyV", "BenV", "GiddyV"};

        Random random = new Random();

        for (int i = 0; i < numOfEmployees; i++) {
            Person employee = new Person();
            employee.setPerson(names[random.nextInt(names.length)] + i);
            employee.setAge(random.nextInt(90) + 1);
            employees[i] = employee;
        }

        return employees;
    }

    // This method returns the index in the object array where the person with the given name exists
    public int getEmployeeIndex(String name, Person[] employees) {
        for (int index = 0; index < employees.length; index++) {
            if (employees[index].getPerson().equals(name)) {
                return index;
            }
        }
        return -1;
    }

    /* Method to set the amount of money for each person */
    public void setMoney(int money) {
        this.money = money;
    }

    /* Method to get the amount of money for a person */
    public int getMoney() {
        return money;
    }

    // Subtract an amount from the person's balance
    public void subtractMoney(int amount) {
        money -= amount;
    }

    // Set the number of tickets the person has
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    // Get the number of tickets a person has
    public int getTickets() {
        return tickets;
    }

    // Set whether the person is in the park or not
    public void setInPark(boolean inPark) {
        this.inPark = inPark;
    }

    // Check if the person is in the park or not
    public boolean isInPark() {
        return inPark;
    }

    /* Generate a random amount of money for each person */
    public void generateMoney(Person[] persons) {
        Random random = new Random();
        for (Person person : persons) {
            person.setMoney(random.nextInt(300));
        }
    }
}