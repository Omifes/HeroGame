// HorseRideStrategy.java
public class HorseRideStrategy implements MovementStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Hero is riding a horse from " + from + " to " + to);
    }

    @Override
    public String getMovementType() {
        return "riding a horse";
    }
}