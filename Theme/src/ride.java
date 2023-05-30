class Ride {
    private int AliBnumSeats = 5; // Number of seats for Alibaba ride
    private int DropTnumSeats = 8; // Number of seats for Drop Tower ride
    private ThemePark t; // Instance of ThemePark

    // Constructor
    public Ride(ThemePark t) {
        this.t = t;
    }

    // Getter for number of seats for Drop Tower ride
    public int getDropTnumSeats() {
        return DropTnumSeats;
    }

    // Getter for number of seats for Alibaba ride
    public int getAliBnumSeats() {
        return AliBnumSeats;
    }

    // Method to adjust the number of seats available for Alibaba ride
    public void setAliBnumSeats(int n) {
        if (n == -1) {
            AliBnumSeats--;
        } else {
            AliBnumSeats++;
        }
    }

    // Method to adjust the number of seats available for Drop Tower ride
    public void setDropTSeats(int n) {
        if (n == -1) {
            DropTnumSeats--;
        } else {
            DropTnumSeats++;
        }
    }

    // Method for customers to ride the Alibaba ride
    public int rideAliBaba(String customer) {
        if (getAliBnumSeats() >= 1 && getAliBnumSeats() <= 5) {
            setAliBnumSeats(-1);
            t.setAliBList(customer, -1); // Add customer to Alibaba ride list
            return 1; // Successful ride
        } else {
            return -1; // No seats available
        }
    }

    // Method for customers to ride the Drop Tower ride
    public int rideDropTower(String customer) {
        if (getDropTnumSeats() >= 1 && getDropTnumSeats() <= 8) {
            setDropTSeats(-1);
            t.setDropTList(customer, -1); // Add customer to Drop Tower ride list
            return 1; // Successful ride
        } else {
            return -1; // No seats available
        }
    }

    // Method for customers to exit the Alibaba ride
    public void exitAlibaba(String customer) {
        t.setAliBList(customer, 1); // Remove customer from Alibaba ride list
        setAliBnumSeats(1); // Customer has exited, one more seat available
    }

    // Method for customers to exit the Drop Tower ride
    public void exitDropt(String customer) {
        t.setDropTList(customer, 1); // Remove customer from Drop Tower ride list
        setDropTSeats(1); // Customer has exited, one more seat available
    }
}