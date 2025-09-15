// WalkStrategy.java
public class WalkStrategy implements MovementStrategy {
    @Override
    public void move(String from, String to) {
        System.out.println("Hero is walking from " + from + " to " + to);
    }

    @Override
    public String getMovementType() {
        return "walking";
    }
}
