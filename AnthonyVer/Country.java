
public abstract class Country {
    // Common properties
    private String name;
    private String region;

    // Constructor
    public Country(String name, String region) {
        this.name = name;
        this.region = region;
    }

    // Getters for the properties
    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    // Abstract method that subclasses must implement
    public abstract String getFamousDish();

    // Optional: A method to describe the country and its famous dish
    public void describe() {
        System.out.println("The country " + name + " is located in " + region + " region.");
        System.out.println("One of the most famous dishes from " + name + " is " + getFamousDish() + ".");
    }
}
