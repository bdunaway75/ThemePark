import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class facilities {

    ArrayList<String> FoodStand = new ArrayList<String>(List.of("Pizza", "20", "Hamburger", "34", "Fries", "10", "Pretzel", "12"));
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
    public String FoodStand(Person Customer) {
        Random r = new Random();
        int rand = r.nextInt(7);
        while (rand % 2 == 1) {
            rand = r.nextInt(7);
        }

        String food = getFoodStand().get(rand);
        //Parsing cost to int, index + 1 because all cost are one index after the name.
        int cost = Integer.parseInt(getFoodStand().get(rand + 1));
        if (cost > Customer.getMoney()) {
            return "Low Balance";
        } else {
            t.setParkMoney(cost); //Updating Parks money
            Customer.subtractMoney(cost); //Updating customers balance
            return food;
        }


    }

    //Clothing store within the facilities.
    public String ClothingStore(Person Customer) {
        Random r = new Random();
        int rand = r.nextInt(6);
        //Making sure random number is an even number
        while (rand % 2 == 1) {
            rand = r.nextInt(6);
        }

        String clothes = getClothingStore().get(rand);
        //Parsing cost to int, index + 1 because all cost are one index after the name.
        int cost = Integer.parseInt(getFoodStand().get(rand + 1));
        if (cost > Customer.getMoney()) {
            //Customer doesnt have enough money
            return "Low Balance";
        } else {
            t.setParkMoney(cost); //Updating Parks money
            Customer.subtractMoney(cost); //Updating customers balance
            return clothes;
        }


    }
}