package lapj.activity2.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Main class of the Java program.
 * Find duplicate values of an array and remove them. Then, print the new array without the duplicated values.
 */

    public class Main {

        public static void main(String[] args) {
            ArrayList<String> computerBrands = new ArrayList<>();

            computerBrands.add("Apple");
            computerBrands.add("Acer");
            computerBrands.add("Samsung");
            computerBrands.add("Asus");
            computerBrands.add("Sony");
            computerBrands.add("Dell");
            computerBrands.add("Hewlett-Packard");
            computerBrands.add("Asus");
            computerBrands.add("Apple");
            computerBrands.add("Acer");
            computerBrands.add("Toshiba");
            computerBrands.add("Sony");
            computerBrands.add("Samsung");

            System.out.println(Arrays.toString(computerBrands.toArray()));
            Collections.sort(computerBrands);
            System.out.println(Arrays.toString(computerBrands.toArray()));

            for (int i = 1; i <computerBrands.size() ; i++) {
                String brand1 = computerBrands.get(i);
                String brand2 = computerBrands.get(i-1);
                if (brand1 == brand2) {
                    computerBrands.remove(i);
                }
            }

            System.out.println(Arrays.toString(computerBrands.toArray()));
        }
    }
