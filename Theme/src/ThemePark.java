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
    public void HireEmployee(person employees)
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
    public person[] fireEmployee(person employee, person[] employees)
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
    public void BuyTickets(person customers)
    {


        if(customers.getMoney() >= ticketcost)
        {
            customers.subMoney(ticketcost);//If the customer has enough money, also subtract from customer balance
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
    public void setCustomerList(person customers)
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
    public void Entrance(person customers)
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

}
class ride {
    //Tickets customers buy let you rides free
    private int AliBnumSeats = 5;
    private int DropTnumSeats = 8;
    ThemePark t;


    //Instance of themepark
    public ride(ThemePark t)
    {
        this.t = t;
    }

    //Getter for num of seays
    public int getDropTnumSeats() {
        return DropTnumSeats;
    }

    //Getter for number of seats
    public int getAliBnumSeats()
    {
        return AliBnumSeats;
    }



    //Method Adjust the number of seats available
    public void setAliBnumSeats(int n)
    {
        if(n == -1)
        {
            AliBnumSeats--;
        }
        else
        {
            AliBnumSeats++;
        }
    }

    //Setter for number of seats
    public void setDropTSeats(int n)
    {
        if(n == -1)
        {
            DropTnumSeats--;
        }
        else
        {
            DropTnumSeats++;
        }
    }
    //Sets the list for customers riding
    public int rideAliBaba(String customer)
    {

        if(getAliBnumSeats() >= 1 && getAliBnumSeats() <= 5)
        {
            setAliBnumSeats(-1);
            t.setAliBList(customer, -1);
            return 1;
        }


        else
        {
            return -1; //No seats available
        }


    }

    //Method for the Drop tower ride
    public int rideDropTower(String customer)
    {

        if(getDropTnumSeats() >= 1 && getDropTnumSeats() <= 8)
        {
            setDropTSeats(-1);
            t.setDropTList(customer, -1);
            return 1;
        }


        else
        {
            return -1; //No seats available
        }


    }

    //Method for customers to exit the ride
    public void exitAlibaba(String customer)
    {
        t.setAliBList(customer, 1);
        setAliBnumSeats(1); //Customer has exited, one more seat available;

    }

    //Method for customer to exit the ride
    public void exitDropt(String customer)
    {
        t.setDropTList(customer, 1);
        setDropTSeats(1); //Customer has exited, one more seat available;

    }

}

class facilities{

    ArrayList<String> FoodStand = new ArrayList<String>(List.of("Pizza","20","Hamburger","34","Fries", "10", "Pretzel" , "12"));
    ArrayList<String> ClothingStore = new ArrayList<String>(List.of("Sweater", "20", "Shirt", "40", "Pants", "30"));
    ThemePark t;

    //Constructore holding the themepark instance
    public facilities(ThemePark t) {
        this.t = t;
    }

    //Getter for clothes in the clothes store
    public ArrayList<String> getClothingStore() {
        return ClothingStore;
    }
    //Getter for foods in the food stand
    public ArrayList<String> getFoodStand() {
        return FoodStand;
    }

    //Food Stand in the facilities
    public String FoodStand(person Customer)
    {
        Random r = new Random();
        int rand = r.nextInt(7);
        while(rand % 2 == 1)
        {
            rand = r.nextInt(7);
        }

        String food = getFoodStand().get(rand);
        //Parsing cost to int, index + 1 because all cost are one index after the name.
        int cost = Integer.parseInt(getFoodStand().get(rand + 1));
        if(cost > Customer.getMoney())
        {
            return "Low Balance";
        }

        else
        {
            t.setParkMoney(cost); //Updating Parks money
            Customer.subMoney(cost); //Updating customers balance
            return food;
        }


    }
    //Clothing store within the facilities.
    public String ClothingStore(person Customer)
    {
        Random r = new Random();
        int rand = r.nextInt(6);
        //Making sure random number is an even number
        while(rand % 2 == 1)
        {
            rand = r.nextInt(6);
        }

        String clothes = getClothingStore().get(rand);
        //Parsing cost to int, index + 1 because all cost are one index after the name.
        int cost = Integer.parseInt(getFoodStand().get(rand + 1));
        if(cost > Customer.getMoney())
        {
            //Customer doesnt have enough money
            return "Low Balance";
        }

        else
        {
            t.setParkMoney(cost); //Updating Parks money
            Customer.subMoney(cost); //Updating customers balance
            return clothes;
        }


    }

}

class person {

    /**
     * Methods in this class are for changing the global variables
     * for each person.
     */

    private String customer; //String for customers names
    private int age; //Holds the age of the person
    private int money; //Money the person will have
    private int tickets; //Tickets a person has
    private boolean inPark; //Tells the theme park whether they are in the park or not


    //Setter for customers
    public void setPerson(String customer)
    {
        this.customer = customer;

    }

    //Getter for persons
    public String getPerson()
    {
        return this.customer;
    }

    //Setter for age
    public void setAge(int age)
    {
        this.age = age;
    }

    //Getter for age
    public String getAge()
    {
        return String.valueOf(age);
    }


    /* Method that generates customers*/
    public static person[] genPeople(int Ncusts) {

        person[] people = new person[Ncusts]; //Creating object array that will hold customers
        //Initializing each customer in the object array
        Random r = new Random();
        int i;
        for (i = 0; i < Ncusts; i++) {
            int rand = r.nextInt(6);
            person cus = new person();
            if(rand == 0){
                cus.setPerson("Randal");
            } else if(rand == 1){
                cus.setPerson("John Cena");
            } else if(rand == 2){
                cus.setPerson("Jacob");
            } else if(rand == 3){
                cus.setPerson("Marie");
            } else {
                cus.setPerson("G-Money");
            }
            int age = r.nextInt(90)+1;
            cus.setAge(age);

            people[i] = cus;
        }
        return people;
    }

    //This method will add a person to an existing persons array
    public person[] addPerson(int index, person[] persons, person[] employees)
    {
        person[] people = Arrays.copyOf(persons, persons.length+1);
        people[people.length-1] = employees[index];
        return people;

    }

    //Generating Employees
    public static person[] genEmployees(int ems)
    {
        person[] employee = new person [ems];
        Random r = new Random();
        for (int i = 0; i < ems; i++)
        //Adding the i in the names help keep track of duplicate names, lol
        {
            int rand = r.nextInt(5);
            person cus = new person();
            if(rand == 0){
                cus.setPerson("JasonV"+ i);

            }
            else if(rand == 1){
                cus.setPerson("TimV" + i);
            }
            else if(rand == 2){
                cus.setPerson("TommyV" + i);
            }
            else if(rand == 3){
                cus.setPerson("BenV" + i);
            }
            else {
                cus.setPerson("GiddyV" + i);
            }

            int age = r.nextInt(90)+1;
            cus.setAge(age);
            employee[i] = cus;
        }
        return employee;
    }

    //This method return the index in the Obj. Array, where the person "name" exists
    public int getEmployeeElement(String name, person[] Employees)
    {
        int index;
        for(index = 0; index < Employees.length; index++)
        {
            if(Employees[index].getPerson().equals(name))
            {
                break;
            }
        }
        return index;
    }

    /* Method to set money for each customer*/
    public void setMoney(int money)
    {
        this.money = money;


    }

    /*Method that get money of customer*/
    public int getMoney()
    {
        return money;
    }
    //Subtract from customers balance
    public void subMoney(int amnt)
    {
        money = money - amnt;
    }


    //Setting how many tickets the customer has
    public void setTickets(int tickets)
    {
        this.tickets = tickets;
    }

    //Getter for tickets
    public int getTickets()
    {
        return tickets;
    }

    //Setter for inPark
    public void setInPark(boolean tf)
    {
        inPark = tf;
    }

    //Getter for inPark
    public boolean getinPark()
    {
        return inPark;
    }

    /* Generating money for each customer*/
    public void genMoney(person[] customers)
    {
        Random r = new Random();
        for(person customer : customers )
        {
            customer.setMoney(r.nextInt(300));

        }
    }




    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        person c = new person();
        ThemePark t = new ThemePark("Ali Baba", "Drop Tower", "Food Stand", "Clothes Store");
        List<String> Ctickets = new ArrayList<>();
        List<String> CnoTickets = new ArrayList<>(); //List of customers in the park


        System.out.println("How many customers");
        int size = s.nextInt();

        System.out.println("How many employees?");
        int size2 = s.nextInt();

        person[] myCustomers = genPeople(size);
        person[] Employees = genEmployees(size2);
        c.genMoney(myCustomers); //Generating money for customers
        c.genMoney(Employees); //Generating cash for the employees also
        //Customers buying tickets


        for (person customers : myCustomers)
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


        for (person em : Employees)
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
        for (person customers : myCustomers)
        {
            t.Entrance(customers);
            if(!customers.getinPark())
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

        int ele = c.getEmployeeElement(name, Employees);
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
        if(myCustomers[myCustomers.length-1].inPark)
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
        ride ri = new ride(t);
        for(person element : myCustomers)
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

        for(person element : myCustomers)
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

        for(person element : myCustomers) {
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
        for(person element : myCustomers) {
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