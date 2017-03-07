package lapj.activity5.edu;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luispo on 3/6/17.
 */


public class Main {
        public static void main(String[] args) throws Exception {
            ;

            String mainDishesFileTXT = "/Users/luispo/IdeaProjects/Lesson3/src/lapj/activity5/edu/main_dish.txt";
            String drinksFileTXT = "/Users/luispo/IdeaProjects/Lesson3/src/lapj/activity5/edu/drinks.txt";
            String dessertsFileTXT = "/Users/luispo/IdeaProjects/Lesson3/src/lapj/activity5/edu/dessert.txt";

            PrintMainDish printMainDish = new PrintMainDish();
            printMainDish.printMainDish(mainDishesFileTXT);

            PrintDrinks printDrinks = new PrintDrinks();
            printDrinks.printDrinks(drinksFileTXT);

            PrintDesserts printDesserts =  new PrintDesserts();
            printDesserts.printDesserts(dessertsFileTXT);




        }
    }



    abstract class Food {
        private String name;
        private double price;
        public Food() {
            ;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public abstract String toString();
    }

    class MainDish extends Food {
        private String mainmeal, accompaniments;
        public MainDish() {
            ;
        }

        public String getMainmeal() {
            return mainmeal;
        }

        public void setMainmeal(String mainmeal) {
            this.mainmeal = mainmeal;
        }

        public String getAccompaniments() {
            return accompaniments;
        }

        public void setAccompaniments(String accompaniments) {
            this.accompaniments = accompaniments;
        }

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t\t"+ getName());
            stringBuilder.append("\n\t\t\t"+ getMainmeal());
            stringBuilder.append("\n\t\t\t"+ getAccompaniments());
            stringBuilder.append("\n\t\t\t$" + getPrice());

            return stringBuilder.toString();
        };
    }

    class Drink extends Food {
        public Drink() {
            ;
        }

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t\t"+ getName());
            stringBuilder.append("\n\t\t\t$" + getPrice());

            return stringBuilder.toString();
        };
    }

    class Dessert extends Food {
        private String description;
        public Dessert() {
            ;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t\t"+ getName());
            stringBuilder.append("\n\t\t\t" + getDescription());
            stringBuilder.append("\n\t\t\t\t$" + getPrice());
            return stringBuilder.toString();
        };
    }


    class Combo {
        //Combine Main Dish, Drink, Dessert

        private MainDish mainDish;
        private Drink drink;
        private Dessert dessert;
        private double ComboPrice;

        public Combo(MainDish mainDish, Drink drink, Dessert dessert) {
            this.mainDish = mainDish;
            this.drink = drink;
            this.dessert = dessert;
            this.ComboPrice = calculateComboPrice();
        }


        public Combo() {
            ;
        }

        private double calculateComboPrice(){
            return (this.mainDish.getPrice() +
                    this.drink.getPrice() +
                    this.dessert.getPrice()) -
                    calculateComboDiscount();
        }

        private double calculateComboDiscount(){
            return 0.00;
        }

        public String toString(){
            return "";
        };

}
