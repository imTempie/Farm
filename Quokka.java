public class Quokka extends Animal {

    public Quokka() {
        super(1, 6, 6, "Bob");
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
            status = "Old Quokka";
        } else if (weight >= 10) {
            status = "Mature Quokka";
        } else if (weight >= 5) {
            status = "Young Quokka";
        } else if (weight > 0) {
            status = "Tollder Quokka";
        } else {
            status = "Baby Quokka";
        }
    }

}
