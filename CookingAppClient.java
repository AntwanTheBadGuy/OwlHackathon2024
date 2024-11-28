import java.util.Scanner;

public class CookingAppClient {

    public static void main(String[] args) {
        // Array of popular dishes for Italian cuisine
        String[] italianDishes = {"Pizza", "Pasta", "Tiramisu"};
        String[] italianDifficulties = {"Easy", "Medium", "Hard"};

        // Array of popular dishes for Japanese cuisine
        String[] japaneseDishes = {"Sushi", "Ramen", "Tempura"};
        String[] japaneseDifficulties = {"Hard", "Medium", "Easy"};

        // Creating a Cuisine object for Italy
        Cuisine italianCuisine = new Cuisine("Italy", "Europe", "Pasta", "Italian", italianDishes, 50, italianDifficulties);

        // Creating a Cuisine object for Japan
        Cuisine japaneseCuisine = new Cuisine("Japan", "Asia", "Sushi", "Japanese", japaneseDishes, 75, japaneseDifficulties);

        // Store both cuisines in an array for easy management
        Cuisine[] cuisines = {italianCuisine, japaneseCuisine};

        // Welcome message and available options for the user
        System.out.println("Welcome to the Cooking App! Here are some options:");
        System.out.println("1. View available cuisines.");
        System.out.println("2. Search for a recipe by dish name.");
        System.out.println("3. View recipes by difficulty level.");
        System.out.println("4. Add a new recipe to a cuisine.");
        System.out.println("5. Compare two cuisines by number of recipes.");
        System.out.println("6. Mark a recipe as completed.");
        System.out.println("7. Exit.");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Please select an option (1-7):");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // View available cuisines
                    System.out.println("Displaying all available cuisines:");
                    displayCuisines(cuisines);
                    break;

                case 2:
                    // Search for a recipe by dish name
                    System.out.println("Enter the name of the dish you're looking for:");
                    String dishName = scanner.nextLine();
                    searchRecipeInCuisinesByDishName(cuisines, dishName);
                    break;

                case 3:
                    // View recipes by difficulty level
                    System.out.println("Enter the difficulty level (Easy, Medium, Hard):");
                    String difficulty = scanner.nextLine();
                    displayRecipesByDifficultyInCuisines(cuisines, difficulty);
                    break;

                case 4:
                    // Add a new recipe to a cuisine
                    System.out.println("Which cuisine would you like to add a recipe to? (Italian, Japanese)");
                    String cuisineChoice = scanner.nextLine();
                    System.out.println("Enter the name of the new recipe:");
                    String newRecipe = scanner.nextLine();
                    System.out.println("Enter the difficulty level of the new recipe (Easy, Medium, Hard):");
                    String newDifficulty = scanner.nextLine();

                    // Add the new recipe to the selected cuisine
                    addRecipeToCuisine(cuisines, cuisineChoice, newRecipe, newDifficulty);
                    break;

                case 5:
                    // Compare two cuisines by the number of recipes
                    System.out.println("Enter the first cuisine to compare (Italian, Japanese):");
                    String cuisine1 = scanner.nextLine();
                    System.out.println("Enter the second cuisine to compare (Italian, Japanese):");
                    String cuisine2 = scanner.nextLine();
                    compareCuisines(cuisines, cuisine1, cuisine2);
                    break;

                case 6:
                    // Mark a recipe as completed
                    System.out.println("Which recipe would you like to mark as completed?");
                    String completedRecipe = scanner.nextLine();
                    markRecipeAsCompleted(cuisines, completedRecipe);
                    break;

                case 7:
                    // Exit the app
                    System.out.println("Thank you for using the Cooking App!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    // Method to display all cuisines
    public static void displayCuisines(Cuisine[] cuisines) {
        for (Cuisine cuisine : cuisines) {
            cuisine.displayCuisineInfo();
            System.out.println("-----------------------------------");
        }
    }

    // Method to search for a recipe by dish name in all cuisines
    public static void searchRecipeInCuisinesByDishName(Cuisine[] cuisines, String dishName) {
        boolean found = false;
        for (Cuisine cuisine : cuisines) {
            for (String dish : cuisine.getPopularDishes()) {
                if (dish.equalsIgnoreCase(dishName)) {
                    System.out.println("Dish Found: " + dish + " in " + cuisine.getCuisineName() + " cuisine.");
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("Dish '" + dishName + "' not found in any cuisine.");
        }
    }

    // Method to display recipes by difficulty level in all cuisines
    public static void displayRecipesByDifficultyInCuisines(Cuisine[] cuisines, String difficulty) {
        boolean found = false;
        System.out.println("Displaying all recipes at difficulty level: " + difficulty);
        for (Cuisine cuisine : cuisines) {
            System.out.println("Cuisine: " + cuisine.getCuisineName());
            boolean difficultyFound = cuisine.displayRecipesByDifficulty(difficulty);
            if (difficultyFound) {
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recipes found at difficulty level '" + difficulty + "' in any cuisine.");
        }
    }

    // Method to add a recipe to a specific cuisine
    public static void addRecipeToCuisine(Cuisine[] cuisines, String cuisineName, String newRecipe, String difficulty) {
        boolean added = false;
        for (Cuisine cuisine : cuisines) {
            if (cuisine.getCuisineName().equalsIgnoreCase(cuisineName)) {
                // Add the recipe by simulating an increase in the list of dishes (this would need to be dynamic)
                System.out.println("Adding " + newRecipe + " (" + difficulty + ") to " + cuisineName + " cuisine.");
                cuisine.addRecipe(); // Simulate adding a recipe
                added = true;
                break;
            }
        }
        if (!added) {
            System.out.println("Cuisine '" + cuisineName + "' not found.");
        }
    }

    // Method to compare two cuisines by name
    public static void compareCuisines(Cuisine[] cuisines, String cuisine1Name, String cuisine2Name) {
        Cuisine cuisine1 = null;
        Cuisine cuisine2 = null;

        for (Cuisine cuisine : cuisines) {
            if (cuisine.getCuisineName().equalsIgnoreCase(cuisine1Name)) {
                cuisine1 = cuisine;
            } else if (cuisine.getCuisineName().equalsIgnoreCase(cuisine2Name)) {
                cuisine2 = cuisine;
            }
        }

        if (cuisine1 != null && cuisine2 != null) {
            compareCuisinesByRecipes(cuisine1, cuisine2);
        } else {
            System.out.println("One or both cuisines not found.");
        }
    }

    // Method to compare the total number of recipes between two cuisines
    public static void compareCuisinesByRecipes(Cuisine cuisine1, Cuisine cuisine2) {
        System.out.println("Comparing cuisines: " + cuisine1.getCuisineName() + " vs. " + cuisine2.getCuisineName());
        if (cuisine1.getTotalRecipes() > cuisine2.getTotalRecipes()) {
            System.out.println(cuisine1.getCuisineName() + " has more recipes (" + cuisine1.getTotalRecipes() + ")");
        } else if (cuisine1.getTotalRecipes() < cuisine2.getTotalRecipes()) {
            System.out.println(cuisine2.getCuisineName() + " has more recipes (" + cuisine2.getTotalRecipes() + ")");
        } else {
            System.out.println("Both cuisines have the same number of recipes (" + cuisine1.getTotalRecipes() + ")");
        }
    }

    // Method to mark a recipe as completed
    public static void markRecipeAsCompleted(Cuisine[] cuisines, String completedRecipe) {
        boolean found = false;
        for (Cuisine cuisine : cuisines) {
            for (String dish : cuisine.getPopularDishes()) {
                if (dish.equalsIgnoreCase(completedRecipe)) {
                    System.out.println("You have successfully completed: " + dish);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("Recipe '" + completedRecipe + "' not found.");
        }
    }
}
