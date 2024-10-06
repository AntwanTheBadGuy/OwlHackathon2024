import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private String title;
    private Recipe recipe;
    private List<Exercise> exercises;

    // Constructor
    public Lesson(String title, Recipe recipe) {
        this.title = title;
        this.recipe = recipe;
        this.exercises = new ArrayList<>();
    }

    // Get lesson title
    public String getTitle() {
        return title;
    }

    // Add an exercise to the lesson
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    // Get the recipe for the lesson
    public Recipe getRecipe() {
        return recipe;
    }

    // Get list of exercises
    public List<Exercise> getExercises() {
        return exercises;
    }
}
