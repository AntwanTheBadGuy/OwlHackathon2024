import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private Map<String, Progress> cookingProgress;

    // Constructor
    public User(String name) {
        this.name = name;
        this.cookingProgress = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    // Add recipe progress for a specific recipe
    public void addRecipeProgress(Recipe recipe) {
        cookingProgress.put(recipe.getName(), new Progress(recipe));
    }

    // Get progress for a recipe
    public Progress getProgress(Recipe recipe) {
        return cookingProgress.get(recipe.getName());
    }

    // Display user progress
    public void displayProgress() {
        System.out.println(name + "'s Cooking Progress:");
        for (String recipeName : cookingProgress.keySet()) {
            System.out.println(recipeName + ": " + cookingProgress.get(recipeName).getCompletionPercentage() + "% complete");
        }
    }
}

