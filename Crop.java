public abstract class Crop {
    // instance variables
    protected int daysGrowing;
    protected int growth;
    protected int growthRate;
    protected int lightNeed;
    protected int waterNeed;
    protected String status;
    protected String type;

    /**
     * Constructor for objects of class Crop
     */
    public Crop(int growthRate, int lightNeed, int waterNeed) {
        // initialise instance variables
        this.growthRate = growthRate;
        this.lightNeed = lightNeed;
        this.waterNeed = waterNeed;
        this.status = "Seed";
        this.type = "Generic";
    }

    // Methods below

    public String getNeeds() {
        return "Light need: " + lightNeed + ", Water Need: " + waterNeed + "\n";
    }

    public String getReport() {
        return "Type: " + type + ", Status: " + status + ", Growth: " + growth
                + ", daysGrowing: " + daysGrowing + "\n" + getNeeds();
    }

    public void updateStatus() {
        if (growth >= 15) {
            status = "Old";
        } else if (growth >= 10) {
            status = "Mature";
        } else if (growth >= 5) {
            status = "Young";
        } else if (growth > 0) {
            status = "Seedling";
        } else {
            status = "Seed";
        }
    }

    public void grow(int light, int water) {
        if (light >= lightNeed && water >= waterNeed) {
            growth += growthRate;
        }
        daysGrowing++;
        updateStatus();
    }

}
