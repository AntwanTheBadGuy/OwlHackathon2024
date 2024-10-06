
public class Spain extends Country {

    // Constructor to initialize Spain-specific values
    public Spain() {
        super("Spain", "Southern Europe");
    }

    // Overriding the getFamousDish method to return Spain's famous dish
    @Override
    public String getFamousDish() {
        return "Paella"; // Spain's famous dish is Paella
    }
}
