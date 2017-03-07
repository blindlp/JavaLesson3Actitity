package lapj.activity5.edu;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luispo on 3/6/17.
 */
public class PrintMainDish {
    private ArrayList<MainDish> mainDishes = new ArrayList<MainDish>();

    public ArrayList<MainDish> getMainDishes() {
        return mainDishes;
    }

    public void printMainDish(String fileTXT) throws IOException {
        LoadFileMainDish fileMainDish = new LoadFileMainDish(fileTXT);
        ArrayList<String> allLines = fileMainDish.getFileMainDish();
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> mainMeal =  new ArrayList<>();
        ArrayList<String> accompaniments =  new ArrayList<String>();
        ArrayList<Double> price = new ArrayList<Double>();


        for (int i = 0; i < allLines.size(); i++) {
            if (i % 5 == 0) {
                name.add(allLines.get(i));
            } else if ( i % 5 == 1) {
                mainMeal.add(allLines.get(i));
            } else if ( i % 5 == 2) {
                accompaniments.add(allLines.get(i));
            } else if ( i % 5 == 3) {
                price.add(Double.parseDouble(allLines.get(i).replace("$","").trim()));
            } else {
                continue;
            }
        }


        MainDish mainDish;
        for (int i = 0; i < name.size(); i++) {
            mainDish = new MainDish();
            mainDish.setName(name.get(i));
            mainDish.setMainmeal(mainMeal.get(i));
            mainDish.setAccompaniments(accompaniments.get(i));
            mainDish.setPrice(price.get(i));
            mainDishes.add(mainDish);
        }


        System.out.print("Menu");
        System.out.print("\n\tMain Dishes");
        for (MainDish mainDishes : mainDishes
             ) {
            System.out.print(mainDishes.toString());
        }

    }
}
