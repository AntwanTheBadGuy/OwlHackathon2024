// Parent class: Country
class Country {
    // Attributes
    private String countryName;
    private String region;
    private String nationalDish;

    // Constructor
    public Country(String countryName, String region, String nationalDish) {
        this.countryName = countryName;
        this.region = region;
        this.nationalDish = nationalDish;
    }

    // Getter Methods
    public String getCountryName() {
        return countryName;
    }

    public String getRegion() {
        return region;
    }

    public String getNationalDish() {
        return nationalDish;
    }

    // Method to display basic country info
    public void displayCountryInfo() {
        System.out.println("Country: " + countryName);
        System.out.println("Region: " + region);
        System.out.println("National Dish: " + nationalDish);
    }
}

// Child class: Cuisine that inherits from Country
class Cuisine extends Country {
    // Attributes specific to Cuisine
    private String cuisineName;
    private String[] popularDishes;
    private int totalRecipes;
    private String[] difficultyLevels; // Attribute for recipe difficulties

    // Constructor
    public Cuisine(String countryName, String region, String nationalDish, String cuisineName, String[] popularDishes, int totalRecipes, String[] difficultyLevels) {
        // Calling the parent class constructor
        super(countryName, region, nationalDish);
        this.cuisineName = cuisineName;
        this.popularDishes = popularDishes;
        this.totalRecipes = totalRecipes;
        this.difficultyLevels = difficultyLevels; // Initialize difficulty levels
    }

    // Getter Methods
    public String getCuisineName() {
        return cuisineName;
    }

    public String[] getPopularDishes() {
        return popularDishes;
    }

    public int getTotalRecipes() {
        return totalRecipes;
    }

    // Method to display Cuisine information
    public void displayCuisineInfo() {
        displayCountryInfo();
        System.out.println("Cuisine Name: " + cuisineName);
        System.out.println("Popular Dishes: ");
        for (String dish : popularDishes) {
            System.out.println("- " + dish);
        }
        System.out.println("Total Recipes: " + totalRecipes);
    }

    // Method to add a new recipe
    public void addRecipe() {
        totalRecipes++;
        System.out.println("A new recipe has been added. Total Recipes: " + totalRecipes);
    }

    // Method: Search for a specific dish by name
    public void searchRecipeByDishName(String dishName) {
        boolean found = false;
        for (String dish : popularDishes) {
            if (dish.equalsIgnoreCase(dishName)) {
                System.out.println("Recipe Found: " + dish);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Recipe '" + dishName + "' not found in " + cuisineName + " cuisine.");
        }
    }

    // Method: Display recipes based on difficulty levels
    public boolean displayRecipesByDifficulty(String difficulty) {
        boolean found = false;
        for (int i = 0; i < popularDishes.length; i++) {
            if (difficultyLevels[i].equalsIgnoreCase(difficulty)) {
                System.out.println("- " + popularDishes[i]);
                found = true;
            }
        }
        return found;
    }
}

// Main class: CookingApp
public class CookingApp {

    // Method to display the details of multiple cuisines
    public static void displayCuisines(Cuisine[] cuisines) {
        for (Cuisine cuisine : cuisines) {
            cuisine.displayCuisineInfo();
            System.out.println("-----------------------------------");
        }
    }

    // Method to search for a cuisine by its name
    public static void searchCuisineByName(Cuisine[] cuisines, String cuisineName) {
        boolean found = false;
        for (Cuisine cuisine : cuisines) {
            if (cuisine.getCuisineName().equalsIgnoreCase(cuisineName)) {
                System.out.println("Cuisine Found:");
                cuisine.displayCuisineInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Cuisine '" + cuisineName + "' not found.");
        }
    }

    // Method to search for a specific recipe by dish name in all cuisines
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

    // Method to display recipes based on difficulty level for all cuisines
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

    // Method to compare two cuisines by the number of total recipes
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

        // Display all cuisines
        System.out.println("Displaying all cuisines:");
        displayCuisines(cuisines);

        // Search for a specific recipe by dish name in all cuisines
        System.out.println("Searching for 'Ramen' across all cuisines:");
        searchRecipeInCuisinesByDishName(cuisines, "Ramen");

        // Display recipes by difficulty level in all cuisines
        System.out.println("Displaying medium difficulty recipes across all cuisines:");
        displayRecipesByDifficultyInCuisines(cuisines, "Medium");

        // Display recipes by difficulty level in Italian cuisine
        System.out.println("Displaying easy difficulty recipes across all cuisines:");
        displayRecipesByDifficultyInCuisines(cuisines, "Easy");

        // Compare the total number of recipes between Italian and Japanese cuisine
        System.out.println("Comparing Italian and Japanese cuisines:");
        compareCuisinesByRecipes(italianCuisine, japaneseCuisine);

        // Add a new recipe to Japanese cuisine and re-compare
        System.out.println("Adding a new recipe to Japanese cuisine...");
        japaneseCuisine.addRecipe();

        // Re-compare the cuisines after adding a new recipe
        System.out.println("Re-comparing after adding a recipe to Japanese cuisine:");
        compareCuisinesByRecipes(italianCuisine, japaneseCuisine);
    }
}
