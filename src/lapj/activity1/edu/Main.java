package lapj.activity1.edu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by luispo on 2/28/17.
 */
public class Main {
    public static void main(String[] args) {

        String[] toys = new String[9];
        toys[0] = "Buzz Lightyear";
        toys[1] = "Sheriff Woody";
        toys[2] = "Mr. Potato Head";
        toys[3] = "Barbie";
        toys[4] = "Troll doll";
        toys[5] = "Tonka Truck";
        toys[6] = "Elmo";
        toys[7] = "Big bird";
        toys[8] = "Cookie Monster";

        //Make a list of lists or hashmap to classify the toys.
        //Then sort the list of lists or hashmap ascendingly
        //Print each value

        Arrays.sort(toys);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < toys.length; i++) {
            list.add(toys[i]);
        }


        // displaying array ascending
        System.out.println(Arrays.toString(list.toArray()));
    }
}
