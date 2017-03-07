package lapj.activity5.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by luispo on 07/03/2017.
 */
public class PrintCombos {


    public void printCombo(String mainFileTXT,String drinkFileTXT, String dessertFileTXT) throws IOException {

        PrintMainDish printMainDish = new PrintMainDish();
        printMainDish.printMainDish(mainFileTXT);

        PrintDrinks printDrinks = new PrintDrinks();
        printDrinks.printDrinks(drinkFileTXT);

        PrintDesserts printDesserts =  new PrintDesserts();
        printDesserts.printDesserts(dessertFileTXT);

        Random random;
        ArrayList<Combo> combos = new ArrayList<>();
        Combo combo;
        System.out.println("\n\tCombos with special discount ");
        random = new Random();
        for (int i = 0; i < 20; i++) {

            combo = new Combo(printMainDish.getMainDishes().get(random.nextInt(printMainDish.getMainDishes().size())),
                    printDrinks.getDrinks().get(random.nextInt(printDrinks.getDrinks().size())),
                    printDesserts.getDesserts().get(random.nextInt(printDesserts.getDesserts().size()))                );
            combos.add(combo);
        }


        for (Combo c: combos
                ) {
            System.out.print(c.toString());
        }

    }
}
