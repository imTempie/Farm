public class Rice extends Crop {

    public Rice() {
        super(1, 3, 6);
        type = "Rice";
    }

    public void grow(int light, int water) {
        if (light >= lightNeed && water >= waterNeed) {
            if (status.equals("Seedling") && water > waterNeed) {
                growth += growthRate * 1.5;
            } else if (status.equals("Young") && water > waterNeed) {
                growth += growthRate * 1.25;
            } else {
                growth += growthRate;
            }
        }
        daysGrowing++;
        updateStatus();
    }

    public void updateStatus() {
        if (growth >= 15) {
            status = "Fully Grown Rice Plant";
        } else if (growth >= 10) {
            status = "Maturing Rice Plant";
        } else if (growth >= 5) {
            status = "Young Rice Plant";
        } else if (growth > 0) {
            status = "Seedling";
        } else {
            status = "Rice Grain";
        }
    }

}
