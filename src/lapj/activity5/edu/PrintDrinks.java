package lapj.activity5.edu;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luispo on 3/6/17.
 */
public class PrintDrinks {

    private ArrayList<Drink> drinks =  new ArrayList<Drink>();

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void printDrinks(String fileTXT) throws IOException {


        LoadFileDrinks fileDrinks = new LoadFileDrinks(fileTXT);
        ArrayList<String> allLines = fileDrinks.getFileDrinks();
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<Double> price = new ArrayList<Double>();

        for (int i = 0; i < allLines.size(); i++) {
            if( i % 3 == 0) {
              name.add(allLines.get(i));
            } else if ( i % 3 == 1) {
                price.add(Double.parseDouble(allLines.get(i).replace("$","").trim()));
            } else {
                continue;
            }
        }

        Drink drink;
        for (int i = 0; i < name.size(); i++) {
            drink = new Drink();
            drink.setName(name.get(i));
            drink.setPrice(price.get(i));
            drinks.add(drink);
        }

        System.out.print("\n\tDrinks");
        for (Drink drs: drinks
             ) {
            System.out.print(drs.toString());
        }

    }




}
