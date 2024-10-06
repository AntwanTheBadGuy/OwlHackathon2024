
public class Japan extends Country {

    // Constructor to initialize Japan-specific values
    public Japan() {
        super("Japan", "East Asia");
    }

    // Overriding the getFamousDish method to return Japan's famous dish
    @Override
    public String getFamousDish() {
        return "Sushi"; // Japan's famous dish is Sushi
    }
}
