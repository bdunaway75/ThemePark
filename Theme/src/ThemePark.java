import java.util.*;


public class ThemePark {
    private int customersIn; //Number of customers in the themepark
    List<String> Clist = new ArrayList<>(); //List of customers in the park
    List<String> Employees = new ArrayList<>(); //List of Employees
    List<String> AliBList = new ArrayList<>(); //List to hold the customers riding the Ali Baba
    List<String> DropTList = new ArrayList<>(); //List to hold customer riding the Drop Tower
    private int money;//Park balance
    String[] Rides; //String holding the ride names
    int NumofRides; //Number of rides
    String[] facilities; //String holding the facilities
    int numFacilities; //Number of facilities
    final int ticketcost = 80; //Cost of a ticket

    //Theme park constructor
    public ThemePark(String Ride1, String Ride2, String facilities1, String facilities2)
    {
        Rides = new String[]{Ride1, Ride2};
        NumofRides = Rides.length;
        facilities = new String[]{facilities1,facilities2};
        numFacilities = facilities.length;
    }



    public List<String> getAliBList()
    {

        return AliBList;

    }

    //Getter for Drop tower list
    public List<String> getDropTList()
    {
        return DropTList;
    }

    //Setter for AliBaba list
    public void setAliBList(String name, int n)
    {
        if(n == -1)
        {
            AliBList.add("Person: " + name);
        }

        else if(n == 1)
        {
            AliBList.remove("Person: " + name);
        }
    }

    //Setter for Drop tower list
    public void setDropTList(String name, int n)
    {
        if(n == -1)
        {
            DropTList.add("Person: " + name);
        }

        else if(n == 1)
        {
            DropTList.remove("Person: " + name);
        }
    }
    //Getter for number of rides
    public int getNumofRides() {
        return NumofRides;
    }

    //Getter for number of facilities
    public int getNumFacilities() {
        return numFacilities;
    }

    //Setter for employees
    public void HireEmployee(Person employees)
    {
        this.Employees.add("Employee: " + employees.getPerson());
        this.Employees.add("Age: " + employees.getAge());
    }

    //Getter for employees
    public List<String> getEmployees()
    {
        return Employees;
    }

    //This method removes the employee from the roster, and also
    // removes the person the Employee object array. It then adds
    // that person back to the person[] array, since they are no
    //longer an employee
    public Person[] fireEmployee(Person employee, Person[] employees)
    {
        String name = employee.getPerson();
        String age = employee.getAge();
        Employees.remove("Employee: "+ name); //Removing employee from roster
        Employees.remove("Age: " + age );
        for(int i = 0; i < employees.length - 1; i++)
        {
            if(employees[i] == employee)
            {
                for(int j = i + 1; j < employees.length - 1; j++)
                {
                    employees[j - 1] = employees[j];
                }
                break;
            }
        }
        return Arrays.copyOf(employees, employees.length-1);
    }

    //Method that sets the theme parks money
    public void setParkMoney(int amount)
    {
        this.money = this.money + amount;
    }

    //Getter for balance of park
    public int getMoney()
    {
        return money;
    }

    //TicketBooth to buy tickets
    public void BuyTickets(Person customers)
    {
        if(customers.getMoney() >= ticketcost)
        {
            customers.subtractMoney(ticketcost);//If the customer has enough money, also subtract from customer balance
            setParkMoney(ticketcost); //Increase park balance by the amount of purchased ticket
            customers.setTickets(1); //Setting the amount of tickets the customer has
        }
        else
        {
            customers.setTickets(0); //Customer doesn't have enough money for ticket}
        }
    }
    //Incrementing Customers in the park when this method is called
    public void incCustomersIn()
    {
        customersIn++;
    }

    //Getter for customerin
    public int getCustomersIn()
    {
        return customersIn;
    }

    //Setter for customersList
    public void setCustomerList(Person customers)
    {
        this.Clist.add("Customer: " + customers.getPerson());
        this.Clist.add("Age: " + customers.getAge());
        this.Clist.add("Money: $" + customers.getMoney());
    }

    //Getter for cutomersList
    public List<String> getCustomerList()
    {
        return Clist;
    }

    //Method acts as the entrance to the park, counts customers if they come in
    public void Entrance(Person customers)
    {
        if(customers.getTickets() > 0)
        {
            incCustomersIn(); //Incrementing amount of customers in park
            setCustomerList(customers);
            customers.setInPark(true); //Setting truth value to customer that go in
        }

        else
        {
            customers.setInPark(false);
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Person c = new Person();
        ThemePark t = new ThemePark("Ali Baba", "Drop Tower", "Food Stand", "Clothes Store");
        List<String> Ctickets = new ArrayList<>();
        List<String> CnoTickets = new ArrayList<>(); //List of customers in the park

        System.out.println("How many customers");
        int size = s.nextInt();

        System.out.println("How many employees?");
        int size2 = s.nextInt();

        Person[] myCustomers = Person.generatePeople(size);
        Person[] Employees = Person.generateEmployees(size2);
        c.generateMoney(myCustomers); //Generating money for customers
        c.generateMoney(Employees); //Generating cash for the employees also
        //Customers buying tickets

        for (Person customers : myCustomers)
        {

            t.BuyTickets(customers);
            if(customers.getTickets() > 0)
            {
                Ctickets.add(customers.getPerson());
            }
            else
            {
                CnoTickets.add(customers.getPerson());
            }

        }

        System.out.println("Customer that were able to purchase tickets: " + Ctickets);
        System.out.println("Customers that couldn't afford it: " + CnoTickets);


        for (Person em : Employees)
        {
            t.HireEmployee(em);
        }

        System.out.println("\nCustomers with tickets are now walking to the entrance...");
        System.out.println("Type 'Y' to continue.");
        Scanner in = new Scanner(System.in);
        String res = in.nextLine();
        String newR = res.toUpperCase(Locale.ROOT);

        while(!newR.equals("Y"))
        {
            System.out.println("Waiting, type 'Y' to continue." );
            res = in.nextLine();
            newR = res.toUpperCase(Locale.ROOT);
        }

        List<String> plot = new ArrayList<>(); //List of customers in the park
        for (Person customers : myCustomers)
        {
            t.Entrance(customers);
            if(!customers.isInPark())
            {
                plot.add(customers.getPerson());
            }

        }

        System.out.println("\n----------------------------------------------------------");
        System.out.println("Current employees in the park: " + t.getEmployees());
        System.out.println("----------------------------------------------------------");
        System.out.println("Customers that were able to enter: " + t.getCustomerList());
        System.out.println("----------------------------------------------------------");
        System.out.println("Customers in the parking-lot: " + plot);
        System.out.println("----------------------------------------------------------\n");

        Random r = new Random();
        int rand = r.nextInt(Employees.length);
        Scanner n = new Scanner(System.in);
        System.out.println("\nUh Oh! Looks like employee "+ Employees[rand].getPerson() + " got in an argument with a customer, please fire him!\nType '"+ Employees[rand].getPerson()+"' to fire him/her. **Case Sensitive**");
        String name = n.nextLine();

        int ele = c.getEmployeeIndex(name, Employees);
        myCustomers = c.addPerson(ele, myCustomers, Employees);
        Employees = t.fireEmployee(Employees[ele], Employees);
        //Although the var Employees is never used again, it could serve as more functionality
        //if the program were to continue. The Employee object array is a copy of the old one,
        //except with the desired employee removed. This employee is added back to the person[]
        //array since he is now just a person, and not an employee.

        System.out.println("\nNew ThemePark employee roster: " + t.getEmployees());

        System.out.println("\nSince " + myCustomers[myCustomers.length-1].getPerson() + " was fired, he will attempt to enter the park.");
        t.BuyTickets(myCustomers[myCustomers.length-1]);
        t.Entrance(myCustomers[myCustomers.length-1]);
        if(myCustomers[myCustomers.length-1].isInPark())
        {
            System.out.println(myCustomers[myCustomers.length-1].getPerson() + " was able to buy a ticket, and entered the park.");
        }
        else
        {
            System.out.println(myCustomers[myCustomers.length-1].getPerson() + " is broke and did not have enough money to buy a ticket. He is now homeless in the parking-lot");
        }

        System.out.println("Customers are walking to the rides, proceed? Press 'Y'");
        res = in.nextLine();
        newR = res.toUpperCase(Locale.ROOT);

        while(!newR.equals("Y"))
        {
            System.out.println("Waiting, type 'Y' to continue." );
            res = in.nextLine();
            newR = res.toUpperCase(Locale.ROOT);
        }
        System.out.println("----------------------------------------------------------\n");
        Ride ri = new Ride(t);
        for(Person element : myCustomers)
        {
            int passenger = ri.rideAliBaba(element.getPerson());

            if(passenger == -1)
            {
                System.out.println(element.getPerson() + " was not able to ride Ali Baba, no seats available. Now going to ride the Drop Tower");
                passenger = ri.rideDropTower(element.getPerson());
                if(passenger == -1)
                {
                    System.out.println("Both rides are full, " + element.getPerson());
                }
            }

        }
        System.out.println("\n----------------------------------------------------------");
        System.out.println("Customers riding Ali Baba: "+ t.getAliBList() + ". Seats available = " + ri.getAliBnumSeats());
        System.out.println("Customers riding the Drop Tower: "+ t.getDropTList() + ". Seats available = " + ri.getDropTnumSeats());
        System.out.println("----------------------------------------------------------\n");

        for(Person element : myCustomers)
        {
            if(t.getAliBList().contains("Person: " + element.getPerson()))
            {
                ri.exitAlibaba(element.getPerson());

            }
            else if(t.getDropTList().contains("Person: " + element.getPerson()))
            {
                ri.exitDropt(element.getPerson());
            }
        }

        if(t.getDropTList().isEmpty() && t.getAliBList().isEmpty())
        {
            System.out.println("All customers have exited the rides. Seats available: DropT = " + ri.getDropTnumSeats() + ", Ali Baba = " + ri.getAliBnumSeats());
        }

        System.out.println("\n----------------------------------------------------------");
        System.out.println("Customers are new entering the facilities");
        System.out.println("----------------------------------------------------------\n");
        facilities f = new facilities(t);

        for(Person element : myCustomers) {
            String food = f.FoodStand(element);
            if (food.equals("Low Balance")) {
                System.out.println(element.getPerson() + " did not have enough money to buy anything from the food stand");
            }
            else
            {
                System.out.println(element.getPerson() + " has purchased a " + food + ", and is now eating it");
            }
        }

        System.out.println("\n----------------------------------------------------------");
        for(Person element : myCustomers) {
            String clothes = f.ClothingStore(element);
            if (clothes.equals("Low Balance")) {
                System.out.println(element.getPerson() + " did not have enough money to buy anything from the clothes store");
            }
            else
            {
                System.out.println(element.getPerson() + " has purchased a " + clothes);
            }
        }
        System.out.println("----------------------------------------------------------\n");

        System.out.println("Proceed to Theme Parks statistic?: Press 'Y'");
        res = in.nextLine();
        newR = res.toUpperCase(Locale.ROOT);

        while(!newR.equals("Y"))
        {
            System.out.println("Waiting, type 'Y' to continue." );
            res = in.nextLine();
            newR = res.toUpperCase(Locale.ROOT);
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Theme Parks Statistics:");
        System.out.println("Number of people in the park: " + t.getCustomersIn() );
        System.out.println("Number of rides: " + t.getNumofRides());
        System.out.println("Number of properties: " + t.getNumFacilities());
        System.out.println("Cash flow from today: " + t.getMoney());
        System.out.println("Customer List: " + t.getCustomerList()); //Also shows the employee that was fired, as a new customer
        System.out.println("Employees List: " + t.getEmployees()); //Also demonstrates the removal of the employee that was fired
    }
}