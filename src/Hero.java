public class Hero {
    private MovementStrategy movementStrategy;

    public Hero() {
        this.movementStrategy = new WalkStrategy();
    }

    public Hero(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void move(String from, String to) {
        movementStrategy.move(from, to);
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
        System.out.println("Hero changet movement strategy to " + movementStrategy.getMovementType());
    }

    public String getCurrentMovementType() {
        return movementStrategy.getMovementType();
    }
}