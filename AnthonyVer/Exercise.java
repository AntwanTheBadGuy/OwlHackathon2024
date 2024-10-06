public class Exercise {
    private String question;
    private String answer;
    private boolean isCompleted;

    // Constructor
    public Exercise(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isCompleted = false;
    }

    // Mark the exercise as completed
    public void completeExercise(String userAnswer) {
        if (userAnswer.equalsIgnoreCase(answer)) {
            isCompleted = true;
        }
    }

    // Check if the exercise is completed
    public boolean isCompleted() {
        return isCompleted;
    }

    // Get the question for the exercise
    public String getQuestion() {
        return question;
    }
}
