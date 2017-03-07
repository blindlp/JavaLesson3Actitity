package lapj.activity5.edu;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by luispo on 3/6/17.
 */
public class PrintDesserts {

    private ArrayList<Dessert> desserts = new ArrayList<>();

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public void printDesserts(String fileTXT) throws IOException{
        LoadFileDessert fileDessert = new LoadFileDessert(fileTXT);
        ArrayList<String> allLines = fileDessert.getFileDessert();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> description =  new ArrayList<String>();
        ArrayList<Double> price = new ArrayList<Double>();


        for (int i = 0; i < allLines.size(); i++) {
            if( i % 4 == 0) {
                name.add(allLines.get(i));
            } else if (i % 4 == 1) {
                description.add(allLines.get(i));
            } else if (i % 4 == 2) {
                price.add(Double.parseDouble(allLines.get(i).replace("$","").trim()));
            } else {
                continue;
            }
        }

        Dessert dessert;
        for (int i = 0; i < name.size(); i++) {
            dessert = new Dessert();
            dessert.setName(name.get(i));
            dessert.setDescription(description.get(i));
            dessert.setPrice(price.get(i));
            desserts.add(dessert);
        }

        System.out.print("\n\tDesserts");
        for (Dessert dessertLis: desserts
                ) {
            System.out.print(dessertLis.toString());
        }
    }
}
