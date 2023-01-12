public abstract class Animal {
    protected double weight;
    protected int daysGrowing;
    protected double growthRate;
    protected int foodNeed;
    protected int waterNeed;
    protected String status;
    protected String type;
    protected static String name;

    public Animal(double growthRate, int foodNeed, int waterNeed, String name) {
        this.growthRate = growthRate;
        this.foodNeed = foodNeed;
        this.waterNeed = waterNeed;
        this.name = name;
        status = "Baby";
        type = "Generic";
    }

    public String getNeeds() {
        return "Food need: " + foodNeed + ", Water Need: " + waterNeed + "\n";
    }

    public String getReport() {
        return "Type: " + type + ", Status: " + status + ", Weight: " + weight
                + ", daysGrowing: " + daysGrowing + "\n" + getNeeds();
    }

    public void updateStatus() {
        if (weight >= 15) {
            status = "Old";
        } else if (weight >= 10) {
            status = "Mature";
        } else if (weight >= 5) {
            status = "Young";
        } else if (weight > 0) {
            status = "Toddler";
        } else {
            status = "Baby";
        }
    }

    public void grow(int food, int water) {
        if (food >= foodNeed && water >= waterNeed) {
            weight += growthRate;
        }
        daysGrowing++;
        updateStatus();
    }
}
