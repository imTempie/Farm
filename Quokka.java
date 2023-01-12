public class Quokka extends Animal {

    public Quokka() {
        super(1, 6, 6, name);
        type = "Quokka";
    }

    public void grow(int food, int water) {
        if (food >= foodNeed && water >= waterNeed) {
            if (status.equals("Seedling") && water > waterNeed) {
                weight += growthRate * 1.5;
            } else if (status.equals("Young") && water > waterNeed) {
                weight += growthRate * 1.25;
            } else {
                weight += growthRate;
            }
        }
        daysGrowing++;
        updateStatus();
    }

    public void updateStatus() {
        if (weight >= 15) {
            status = "Jacket Potato";
        } else if (weight >= 10) {
            status = "Normal Potato";
        } else if (weight >= 5) {
            status = "New Potato";
        } else if (weight > 0) {
            status = "Spudling";
        } else {
            status = "Spud";
        }
    }

}
