import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Predator extends Creature {
    int attackPower = 1;
    int health = 10;
    int speed = 2;

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void attackHerbivore() {

    }

    public static List<Point> findRabbit() {
        List<Point> pointsList = new ArrayList<>();
        for (Map.Entry<Point, Entity> entry : Field.getField().entrySet()) {
            if (entry.getValue() instanceof Herbivore) {
                pointsList.add(entry.getKey());
            }
        }

        return pointsList;
    }
    public static List<Point> findPredator() {
        List<Point> pointsList = new ArrayList<>();
        for (Map.Entry<Point, Entity> entry : Field.getField().entrySet()) {
            if (entry.getValue() instanceof Predator) {
                pointsList.add(entry.getKey());
            }
        }

        return pointsList;
    }


    public static void sfdsfsdf() {
        List<Point> wolfList = findPredator();
        for (Point wolf : wolfList) {
            Point rabbit = Herbivore.findNearestPoint(findRabbit(), wolf);
            Predator wol = (Predator) Field.getField().get(wolf);
            wol.makeMove();
        }
    }

    public static void makeMove() {
        List<Point> wolfList = findPredator();
        for (Point pointWolf : wolfList) {
            Point rabbit = Herbivore.findNearestPoint(findRabbit(), pointWolf);
            Predator wolf = (Predator) Field.getField().get(pointWolf);
            Field.getField().remove(pointWolf);
            for (int i = 0; i < wolf.getSpeed(); i++) {

                if(pointWolf.getX() > rabbit.getX()) {
                    pointWolf.setX(pointWolf.getX() - 1);
                } else if (pointWolf.getX() < rabbit.getX()) {
                    pointWolf.setX(pointWolf.getX() + 1);
                } else if(pointWolf.getY() > rabbit.getY()) {
                    pointWolf.setY(pointWolf.getY() - 1);
                } else if (pointWolf.getY() < rabbit.getY()) {
                    pointWolf.setY(pointWolf.getY() + 1);
                }
            }
            Field.getField().put(pointWolf, wolf);
            if (pointWolf.getX() == rabbit.getX() && pointWolf.getY() == rabbit.getY()) {
                Herbivore thisRab = (Herbivore) Field.getField().get(rabbit);
                thisRab.health--;
                //Field.getField().remove(grass);
            }

        }
    }

    @Override
    public String toString() {
        return Emoji.WOLF.getSymbol();
    }

}