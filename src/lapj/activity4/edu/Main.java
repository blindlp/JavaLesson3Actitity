package lapj.activity4.edu;

/**
 * Created by luispo on 3/1/17.
 */
import java.io.*;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Recipe> recipes = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        firstExercise();
        System.out.println("----------------------------");
        secondExercise();
        System.out.println("----------------------------");
        thirdExercise();
    }

    public static void firstExercise() {

        BufferedReader input = null;

        try {
            //Choose the file that you will use.
            String filenameTXT = "/Users/luispo/IdeaProjects/Lesson3/src/lapj/activity4/edu/recipes.txt";
            String filenameJSON = "Root/src/recipes.json";

            //Read your input and create the Objects Recipe

            input = new BufferedReader(new FileReader(filenameTXT));
            // create a new Object Recepe

            Recipe recipe = null;
            boolean newRecepe = true;
            boolean addIngredient = false;
            boolean addStep = false;
            String sCurrentLine;


            while ((sCurrentLine = input.readLine()) != null) {
                if (sCurrentLine.trim().isEmpty()) {
                        recipes.add(recipe);
                        newRecepe =true;
                        addIngredient =false;
                        addStep =false;
                }
                if(newRecepe) {
                    recipe = new Recipe();
                    recipe.setName(sCurrentLine.trim());
                    newRecepe = false;
                } else if("ingredients:".equals(sCurrentLine.trim())) {
                    addIngredient = true;
                    newRecepe = false;
                    addStep = false;
                } else if("steps:".equals(sCurrentLine.trim())) {
                    addIngredient = false;
                    addStep = true;
                } else if(addIngredient && !"ingredients:".equals(sCurrentLine.trim())) {
                        recipe.addIngredients(sCurrentLine.trim());
                } else if (addStep && !"steps:".equals(sCurrentLine.trim())) {
                    recipe.addSteps(sCurrentLine.trim());
                } else {
                    recipe.setName(sCurrentLine.trim());
                }


            }


            if(recipe != null) {
                recipes.add(recipe);
            }

            for (Recipe r: recipes
                 ) {
                System.out.println(r.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null){
                    input.close();
                }
            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

        //Print all the objects Recipe that you created.



        //Expected output. (Use tab instead of space to give format to the output)
        /*

Crock Pot Roast
    ingredients:
        1 beef roast, Meat
        1 package brown gravy mix, Baking
        1 package dried Italian salad dressing mix, Condiments
        1 package dry ranch dressing mix, Condiments
        1/2 cup water, Drinks
    steps:
        1. Place beef roast in crock pot
        2. Mix the dried mixes together in a bowl and sprinkle over the roast.
        3. Pour the water around the roast.
        4. Cook on low for 7-9 hours.
Roasted asparagus
    ingredients:
        1 lb asparagus, Produce
        1 1/2 tbsp olive oil, Condiments
        1/2 tsp kosher salt, Baking
    steps:
        1. Preheat oven to 425F.
        2. Cut off the woody bottom part of the asparagus spears and discard.
        3. With a vegetable peeler, peel off the skin on the bottom 2-3 inches of the spears.
        4. Place asparagus on foil-lined baking sheet and drizzle with olive oil.
        5. Sprinkle with salt.
        6. With your hands, roll the asparagus around until they are evenly coated with oil and salt.
        7. Roast for 10-15 minutes, depending on the thickness of your stalks and how tender you like them.
        8. They should be tender when pierced with the tip of a knife.
        9. The tips of the spears will get very brown but watch them to prevent burning.
        10. They are great plain, but sometimes I serve them with a light vinaigrette if we need something acidic to balance out our meal.
Curried Lentils and Rice
    ingredients:
        1 quart beef broth, Misc
        1 cup dried green lentils, Misc
        1/2 cup basmati rice, Misc
        1 tsp curry powder, Condiments
        1 tsp salt, Condiments
    steps:
        1. Bring broth to a low boil.
        2. Add curry powder and salt.
        3. Cook lentils for 20 minutes.
        4. Add rice and simmer for 20 minutes.

        */

    }

    public static void secondExercise() {
        try {
            FileOutputStream output = new FileOutputStream("/Users/luispo/IdeaProjects/Lesson3/src/lapj/activity4/edu/favorite_recepe.txt");

            //Write to the file the favorite recipe Crock Pot Roast information to test
            //Use methods of the Object Recipe to generate the amount of ingredients
            //and the amount of steps.

            //Write the favorite recipe to the file

            String test = null;

            for (Recipe favorite: recipes
                 ) {
                if(favorite.getName().equals("Crock Pot Roast")) {
                    test = favorite.favoriteRecepe().toString();
                }

            }


            byte[] contentInBytes = test.getBytes();

            output.write(contentInBytes);

            //Expected action: Save the favorite recipe
            //Use tab instead of space to give format after each new line.
/*
Crock Pot Roast
    ingredients: 5
    steps: 4
*/


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void thirdExercise() throws IOException{

        BufferedReader bufferedReader = null;
        //Read the favorite_recipe.txt file
        //Print what the file "favorite_recipe.txt" has
        String textFile = "/Users/luispo/IdeaProjects/Lesson3/src/lapj/activity4/edu/favorite_recepe.txt";

        bufferedReader = new BufferedReader(new FileReader(textFile));

        String sCurrentLine;

        try {

            while ((sCurrentLine = bufferedReader.readLine()) !=null) {
                System.out.println(sCurrentLine.trim());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

        //Expected output:

        /*
Crock Pot Roast
    ingredients: 5
    steps: 4
*/

    }
}

class Recipe {

    // we define the atributes of my recipe
    private String name;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public Recipe(String name, ArrayList<String> ingredients, ArrayList<String> steps) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Recipe() {
        this.name = "";
        ingredients = new ArrayList<String>();
        steps = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // method to add ingredient to the list
    public void addIngredients(String ingredient) {
        this.ingredients.add(ingredient);
    }
    // method to add steps to the list
    public void addSteps(String step) {
        this.steps.add(step);
    }
    // count quantity of ingredients
    public int countIngredients(ArrayList<String> ingredients) {
        return ingredients.size();
    }
    // count quantity of steps
    public int countSteps(ArrayList<String> steps) {
        return steps.size();
    }
    // method to print favorite recipe
    public String favoriteRecepe() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName());
        stringBuilder.append("\n\t" + "ingredients: " + countIngredients(ingredients));
        stringBuilder.append("\n\t" + "steps: " + countSteps(steps));
        return stringBuilder.toString();
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getName());
        stringBuilder.append("\n\t" + "ingredients:");
        for (String list: ingredients)
        {
            stringBuilder.append("\n\t\t" + list );
        }
        stringBuilder.append("\n\t" + "steps:");
        for (String step: steps
             ) {
            stringBuilder.append("\n\t\t" + step );
        }

        return stringBuilder.toString();
    }


}
