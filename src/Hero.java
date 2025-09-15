// Hero.java
public class Hero {
    private String name;
    private MovementStrategy movementStrategy;

    public Hero(String name) {
        this.name = name;
        this.movementStrategy = new WalkStrategy(); // способ по умолчанию
    }

    public Hero(String name, MovementStrategy movementStrategy) {
        this.name = name;
        this.movementStrategy = movementStrategy;
    }

    public void move(String from, String to) {
        System.out.print(name + " ");
        movementStrategy.move(from, to);
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
        System.out.println(name + " changet movement strategy to " + movementStrategy.getMovementType());
    }

    public String getCurrentMovementType() {
        return movementStrategy.getMovementType();
    }

    public String getName() {
        return name;
    }
}