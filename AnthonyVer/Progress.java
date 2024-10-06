public class Progress {
    private Recipe recipe;
    private int completedExercises;
    private int totalExercises;
    public int streak;

    // Constructor
    public Progress(Recipe recipe) {
        this.recipe = recipe;
        this.completedExercises = 0;
        this.totalExercises = 0;
    }
    public int getStreak() {
        return this.streak;
    }
    public void addStreak() {
        this.streak += 1;
    }

    // Update progress based on exercise completion
    public void updateProgress(Exercise exercise) {
        if (exercise.isCompleted()) {
            completedExercises++;
            addStreak();
        }
        totalExercises++;
    }

    // Get completion percentage of the recipe
    public int getCompletionPercentage() {
        if (totalExercises == 0) return 0;
        return (int) ((double) completedExercises / totalExercises * 100);
    }
}
