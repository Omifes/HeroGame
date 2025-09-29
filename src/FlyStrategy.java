public class FlyStrategy implements MovementStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Hero is flying from " + from + " to " + to);
    }

    @Override
    public String getMovementType() {
        return "flying";
    }
}