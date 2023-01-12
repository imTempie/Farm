public class Potato extends Crop {

    public Potato() {
        super(1, 3, 6);
        type = "Potato";
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
            status = "Jacket Potato";
        } else if (growth >= 10) {
            status = "Normal Potato";
        } else if (growth >= 5) {
            status = "New Potato";
        } else if (growth > 0) {
            status = "Spudling";
        } else {
            status = "Spud";
        }
    }

}
