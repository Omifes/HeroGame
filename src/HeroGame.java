// HeroGame.java
import java.util.HashMap;
import java.util.Map;

public class HeroGame {
    private Hero hero;
    private Map<Integer, MovementStrategy> movementStrategies;
    private final String[] locations = {"Castle", "Forest", "River", "Mountains", "Village", "Cave", "Temple"};

    public HeroGame() {
        initializeStrategies();
    }

    private void initializeStrategies() {
        movementStrategies = new HashMap<>();
        movementStrategies.put(1, new WalkStrategy());
        movementStrategies.put(2, new HorseRideStrategy());
        movementStrategies.put(3, new FlyStrategy());
        movementStrategies.put(4, new TeleportStrategy());
    }

    public void start() {
        System.out.println("=== GAME: HERO MOVEMENT CHOICE ===");
        System.out.println("Pattern: Strategy\n");

        String heroName = UserInput.getStringInput("Enter your hero's name: ");
        hero = new Hero(heroName);
        System.out.println("Hero " + heroName + " created! Default movement: walking\n");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = UserInput.getIntInput("Choose action: ", 1, 6);

            switch (choice) {
                case 1:
                    showCurrentStatus();
                    break;
                case 2:
                    changeMovementStrategy();
                    break;
                case 3:
                    moveHero();
                    break;
                case 4:
                    showAvailableLocations();
                    break;
                case 5:
                    showMovementOptions();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting game...");
                    break;
            }

            if (running) {
                System.out.println();
            }
        }

        UserInput.closeScanner();
    }

    private void printMenu() {
        System.out.println("=== MAIN MENU ===");
        System.out.println("1. Show current status");
        System.out.println("2. Change movement method");
        System.out.println("3. Move hero");
        System.out.println("4. Show available locations");
        System.out.println("5. Show movement options");
        System.out.println("6. Exit game");
        System.out.println("================");
    }

    private void showCurrentStatus() {
        System.out.println("\n=== CURRENT STATUS ===");
        System.out.println("Hero: " + hero.getName());
        System.out.println("Movement method: " + hero.getCurrentMovementType());
        System.out.println("=====================");
    }

    private void changeMovementStrategy() {
        System.out.println("\n=== MOVEMENT METHOD SELECTION ===");
        System.out.println("1. Walk");
        System.out.println("2. Ride horse");
        System.out.println("3. Fly");
        System.out.println("4. Teleport");
        System.out.println("0. Cancel");

        int choice = UserInput.getIntInput("Choose movement method: ", 0, 4);

        if (choice != 0) {
            MovementStrategy strategy = movementStrategies.get(choice);
            hero.setMovementStrategy(strategy);
            System.out.println("Movement method successfully changed!");
        } else {
            System.out.println("Change cancelled.");
        }
    }

    private void moveHero() {
        System.out.println("\n=== HERO MOVEMENT ===");

        System.out.println("Available locations:");
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }

        int fromIndex = UserInput.getIntInput("Select starting point (1-" + locations.length + "): ", 1, locations.length) - 1;
        String from = locations[fromIndex];

        int toIndex = UserInput.getIntInput("Select destination point (1-" + locations.length + "): ", 1, locations.length) - 1;

        if (fromIndex == toIndex) {
            System.out.println("Hero is already in this location!");
            return;
        }

        String to = locations[toIndex];

        System.out.println();
        hero.move(from, to);
    }

    private void showAvailableLocations() {
        System.out.println("\n=== AVAILABLE LOCATIONS ===");
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }
        System.out.println("==========================");
    }

    private void showMovementOptions() {
        System.out.println("\n=== MOVEMENT OPTIONS ===");
        System.out.println("1. Walk - slow, but free");
        System.out.println("2. Horse ride - faster, requires a horse");
        System.out.println("3. Flight - very fast, requires mana");
        System.out.println("4. Teleportation - instant, high mana cost");
        System.out.println("========================");
    }

    public static void main(String[] args) {
        HeroGame game = new HeroGame();
        game.start();
    }
}