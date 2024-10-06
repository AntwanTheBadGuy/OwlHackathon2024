import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random rng = new Random();
        Country japan = new Japan();    
        //Country italy = new Italy();
        Country spain = new Spain();
        Country thailand = new Thailand();


        // Creatng a new user example Alice
        User user = new User("Alice");

        // Creating a recipe for a cooking lesson i guess from italy
        Recipe pastaRecipe = new Recipe("Spaghetti Bolognese");
        pastaRecipe.addIngredient("Spaghetti");
        pastaRecipe.addIngredient("Ground Beef");
        pastaRecipe.addIngredient("Tomato Sauce");
        pastaRecipe.addIngredient("Onion");
        pastaRecipe.addStep("Boil the spaghetti.");
        pastaRecipe.addStep("Cook the beef with onions.");
        pastaRecipe.addStep("Add tomato sauce to the beef.");
        pastaRecipe.addStep("Mix the spaghetti with the sauce.");

        

        // Create a lesson with the pasta recipe
        
        Lesson pastaLesson = new Lesson("Lesson 1: Spaghetti Bolognese", pastaRecipe);

        // Add exercises to the lesson
        pastaLesson.addExercise(new Exercise("What is the main ingredient in Spaghetti Bolognese?", "Ground Beef"));
        pastaLesson.addExercise(new Exercise("Which ingredient is used for the sauce?", "Tomato Sauce"));
        pastaLesson.addExercise(new Exercise("Do you boil or stir fry the pasta?", "Boil"));

        // Add the recipe progress to the user
        user.addRecipeProgress(pastaRecipe);

        String[] testAnswers = {"Ground Beef", "Tomato Sauce", "Boil"};

        // Simulate the user completing exercises with correct answerss
        Exercise exercise1 = pastaLesson.getExercises().get(rng.nextInt(2));
        exercise1.completeExercise(testAnswers[rng.nextInt(2)]);
        Exercise exercise2 = pastaLesson.getExercises().get(rng.nextInt(2));
        exercise1.completeExercise(testAnswers[rng.nextInt(2)]);
        Exercise exercise3 = pastaLesson.getExercises().get(rng.nextInt(2));
        exercise1.completeExercise(testAnswers[rng.nextInt(2)]);


        // Update progress after completing exercises
        user.getProgress(pastaRecipe).updateProgress(exercise1);
        user.getProgress(pastaRecipe).updateProgress(exercise2);
        user.getProgress(pastaRecipe).updateProgress(exercise3);

        // Display user progress
        user.displayProgress();

        //Creating a recipe for a cooking lesson from Spain
        Recipe paellaRecipe = new Recipe("Seafood Paella");
        paellaRecipe.addIngredient("Olive Oil");
        paellaRecipe.addIngredient("Onion");
        paellaRecipe.addIngredient("Bell Peppers");
        paellaRecipe.addIngredient("Garlic");
        paellaRecipe.addIngredient("Tomato");
        paellaRecipe.addIngredient("Bay Leaf");
        paellaRecipe.addIngredient("Paprika");
        paellaRecipe.addIngredient("Saffron");
        paellaRecipe.addIngredient("Salt");
        paellaRecipe.addIngredient("Pepper");
        paellaRecipe.addIngredient("White Wine");
        paellaRecipe.addIngredient("Chicken");
        paellaRecipe.addIngredient("Rice");
        paellaRecipe.addIngredient("Fresh Parsley");
        paellaRecipe.addIngredient("Broth");
        paellaRecipe.addIngredient("Shrimp");
        paellaRecipe.addIngredient("Mussels");
        paellaRecipe.addIngredient("Calamari");
        paellaRecipe.addIngredient("Peas");
        paellaRecipe.addIngredient("Lemon Slices");        
        paellaRecipe.addStep("Sauté: Add olive oil to a skillet over medium heat. Add onion, bell peppers, and garlic and sauté 
                            until onion is translucent. Add chopped tomato, bay leaf, paprika, saffron, salt, and pepper. Stir 
                            and cook for 5 minutes.");
        paellaRecipe.addStep("Add white wine. Cook for 10 minutes.");
        paellaRecipe.addStep("Add chicken & rice. Add chopped parsley and cook for 1 minute.");
        paellaRecipe.addStep("Add broth. Pour the broth slowly all around the pan and jiggle the pan to get the rice into an 
                            even layer. (Do not stir the mixture going forward!). Bring mixture to a boil. Reduce heat to 
                            medium low. Give the pan a gentle shake back and forth once or twice during cooking.");
        paellaRecipe.addStep("Cook uncovered: Cook paella uncovered for 15-18 minutes, then nestle the shrimp, mussels and 
                            calamari into the mixture, sprinkle peas on top and continue to cook (without stirring) for 
                            about 5 more minutes. Watch for most of the liquid to be absorbed and the rice at the top 
                            nearly tender. (If for some reason your rice is still uncooked, add ¼ cup more water or broth 
                            and continue cooking).");
        paellaRecipe.addStep("Cover and let rest. Remove pan from heat and cover pan with a lid or tinfoil. Place a kitchen 
                            towel over the lid and allow to rest for 10 minutes.");
        paellaRecipe.addStep("Serve. Garnish with fresh parsley and lemon slices. Serve.");

        //MD/Paella: rice, saffron, olive oil, meat, smoked paprika, green beans

        //Spanish; Tortilla
        paellaRecipe.addIngredient("Eggs");
        paellaRecipe.addIngredient("Potatoes");
        paellaRecipe.addIngredient("Onions");

        paellaRecipe.addStep("Place 1 tablespoon of olive oil in a large non-stick skillet and heat over medium-low heat.");
        paellaRecipe.addStep("Add onions and cook until soft, about 5 to 6 minutes before adding potatoes and more olive oil. 
                            Stir together and continue cooking until potatoes are soft.");
        paellaRecipe.addStep("Whisk eggs together in a medium-sized bowl. Add the potatoes and onions to the eggs and mix. 
                            Season with salt and pepper. Add more olive oil to the pan and pour the mixture in. Cover with a 
                            lid and cook until eggs are browning on the edge.");
        paellaRecipe.addStep("To flip the tortilla, place a plate larger than the skillet on top, turn over, and then carefully 
                            slide the tortilla back into the pan to finish cooking. Cook your desired doneness of the eggs, 
                            slightly runny is traditional.");
        paellaRecipe.addStep("Flip the tortilla out onto a plate and set aside to cool for a couple of minutes before slicing 
                            into wedges.");
        paellaRecipe.addStep("Serve warm, cold or at room temperature.");

    }
}

//Possible Add ons:
// Levels or Cooking Skills: You could add difficulty levels (beginner, intermediate, expert) for recipes and exercises.
// Recipe Categories: Categorize recipes (appetizers, main courses, desserts).
// Interactive Feedback: Provide feedback on incorrect answers to help users learn.
// Cooking Challenges: Add timed challenges or cooking events to encourage users to cook in real life.
// Tracking Calories or Nutrition: Include a feature to track the nutritional value of recipes.
