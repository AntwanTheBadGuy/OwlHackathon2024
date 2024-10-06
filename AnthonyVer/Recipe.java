import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients;
    private List<String> steps;

    // Constructor
    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    // Get the name of the recipe
    public String getName() {
        return name;
    }

    // Add an ingredient to the recipe
    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    // Add a cooking step to the recipe
    public void addStep(String step) {
        steps.add(step);
    }

    // Get list of ingredients
    public List<String> getIngredients() {
        return ingredients;
    }

    // Get list of steps
    public List<String> getSteps() {
        return steps;
    }
}
