public class Thailand extends Country {

    // Constructor to initialize Thailand-specific values
    public Thailand() {
        super("Thailand", "Southeast Asia");
    }

    // Overriding the getFamousDish method to return Thailand's famous dish
    @Override
    public String getFamousDish() {
        return "Pad Thai"; // Thailand's famous dish is Pad Thai YMUMUMU
    }
}
