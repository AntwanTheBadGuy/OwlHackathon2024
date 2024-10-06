public class Main {
    public static void main(String[] args) {
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

        // Add the recipe progress to the user
        user.addRecipeProgress(pastaRecipe);

        // Simulate the user completing exercises with correct answerss
        Exercise exercise1 = pastaLesson.getExercises().get(0);
        exercise1.completeExercise("Ground Beef");
        Exercise exercise2 = pastaLesson.getExercises().get(1);
        exercise2.completeExercise("Tomato Sauce");

        // Update progress after completing exercises
        user.getProgress(pastaRecipe).updateProgress(exercise1);
        user.getProgress(pastaRecipe).updateProgress(exercise2);

        // Display user progress
        user.displayProgress();
    }
}

//Possible Add ons:
// Levels or Cooking Skills: You could add difficulty levels (beginner, intermediate, expert) for recipes and exercises.
// Recipe Categories: Categorize recipes (appetizers, main courses, desserts).
// Interactive Feedback: Provide feedback on incorrect answers to help users learn.
// Cooking Challenges: Add timed challenges or cooking events to encourage users to cook in real life.
// Tracking Calories or Nutrition: Include a feature to track the nutritional value of recipes.
