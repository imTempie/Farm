import java.util.Scanner;

public class Main {

    public Main() {
        Crop potato = new Potato();
        Crop rice = new Rice();

        Animal quokka = new Quokka();
        Animal monkey = new Monkey();

        System.out.println('\u000C'); // clear terminal window

        showGrowables();

        int option = getMenuChoice();

        switch (option) {
            case 1:
                manageCrop(potato);
                break;
            case 2:
                manageCrop(rice);
                break;
            case 3:
                manageAnimal(quokka);
                break;
            case 4:
                manageAnimal(monkey);
                break;
        }
    }

    private void menu() {
        // System.out.println('\u000C'); // clear terminal window
        System.out.println("[1] Grow manually over 1 day");
        System.out.println("[2] Auto grow for 30 days");
        System.out.println("[3] Report Status");
        System.out.println("[4] Exit\n");
    }

    private void showGrowables() {
        System.out.println("What would you like to grow?");
        System.out.println("[1] Potato");
        System.out.println("[2] Rice");
        System.out.println("[3] Quokka");
        System.out.println("[4] Monkey");
    }

    private int getMenuChoice() {
        boolean optionValid = false;
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;
            while (!optionValid) {
                System.out.println("Option Selected:");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 0 && choice <= 4) {
                        optionValid = true;
                    } else {
                        System.out.println("Please enter a valid option");
                    }
                } else {
                    System.out.println("Please enter a valid option");
                }

                scanner.nextLine();
            }
            return choice;
        }
    }

    private void manageCrop(Crop crop) {
        System.out.println("\nThis is the Farm Management Program");
        System.out.println();
        boolean noExit = true;
        while (noExit) {
            menu();
            int option = getMenuChoice();

            switch (option) {
                case 1:
                    manualGrow(crop);
                    System.out.println();
                    break;
                case 2:
                    autoGrow(crop, 30);
                    System.out.println();
                    break;
                case 3:
                    System.out.println(crop.getReport());
                    break;
                case 4:
                    noExit = false;
                    break;
            }
        }
    }

    private void manageAnimal(Animal animal) {
        System.out.println("\nThis is the Farm Management Program");
        System.out.println();
        boolean noExit = true;
        while (noExit) {
            menu();
            int option = getMenuChoice();

            switch (option) {
                case 1:
                    manualGrowAnimal(animal);
                    System.out.println();
                    break;
                case 2:
                    autoGrowAnimal(animal, 30);
                    System.out.println();
                    break;
                case 3:
                    System.out.println(animal.getReport());
                    break;
                case 4:
                    noExit = false;
                    break;
            }
        }
    }

    private void manualGrow(Crop crop) {
        boolean valid = false;
        try (Scanner scanner = new Scanner(System.in)) {
            int water = 0;
            int light = 0;

            while (!valid) {
                System.out.println("Please enter a light value (1-10): ");
                if (scanner.hasNextInt()) {
                    light = scanner.nextInt();
                    if (light >= 1 && light <= 10) {
                        valid = true;
                    } else {
                        System.out.println("Value entered not valid = please enter a value between (1-10)");
                    }
                } else {
                    System.out.println("Value entered not valid, please enter a value between (1-10)");
                }
                scanner.nextLine(); // clearing scanner
            }

            valid = false;
            while (!valid) {
                System.out.println("Please enter a water value (1-10): ");
                if (scanner.hasNextInt()) {
                    water = scanner.nextInt();
                    if (water >= 1 && water <= 10) {
                        valid = true;
                    } else {
                        System.out.println("Value entered not valid = please enter a value between (1-10)");
                    }
                } else {
                    System.out.println("Value entered not valid, please enter a value between (1-10)");
                }
                scanner.nextLine(); // clearing scanner
            }
            crop.grow(light, water);
        }
    }

    private void manualGrowAnimal(Animal animal) {
        boolean valid = false;
        try (Scanner scanner = new Scanner(System.in)) {
            int water = 0;
            int food = 0;

            while (!valid) {
                System.out.println("Please enter a food value (1-10): ");
                if (scanner.hasNextInt()) {
                    food = scanner.nextInt();
                    if (food >= 1 && food <= 10) {
                        valid = true;
                    } else {
                        System.out.println("Value entered not valid = please enter a value between (1-10)");
                    }
                } else {
                    System.out.println("Value entered not valid, please enter a value between (1-10)");
                }
                scanner.nextLine(); // clearing scanner
            }

            valid = false;
            while (!valid) {
                System.out.println("Please enter a water value (1-10): ");
                if (scanner.hasNextInt()) {
                    water = scanner.nextInt();
                    if (water >= 1 && water <= 10) {
                        valid = true;
                    } else {
                        System.out.println("Value entered not valid = please enter a value between (1-10)");
                    }
                } else {
                    System.out.println("Value entered not valid, please enter a value between (1-10)");
                }
                scanner.nextLine(); // clearing scanner
            }
            animal.grow(food, water);
        }
    }

    private void autoGrow(Crop crop, int days) {
        for (int day = 0; day < days; day++) {
            int light = (int) (Math.random() * 10) + 1;
            int water = (int) (Math.random() * 10) + 1;
            crop.grow(light, water);
        }
    }

    private void autoGrowAnimal(Animal crop, int days) {
        for (int day = 0; day < days; day++) {
            int food = (int) (Math.random() * 10) + 1;
            int water = (int) (Math.random() * 10) + 1;
            crop.grow(food, water);
        }
    }

}
