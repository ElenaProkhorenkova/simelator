import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Herbivore extends Creature {


    int health = 10;
    int speed = 1;

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }


    public static List<Point> findGrass() {
        List<Point> pointsList = new ArrayList<>();
        for (Map.Entry<Point, Entity> entry : Field.getField().entrySet()) {
            if (entry.getValue() instanceof Grass) {
                pointsList.add(entry.getKey());
            }
        }

        return pointsList;
    }
    public static List<Point> findHerbivore() {
        List<Point> pointsList = new ArrayList<>();
        for (Map.Entry<Point, Entity> entry : Field.getField().entrySet()) {
            if (entry.getValue() instanceof Herbivore) {
                pointsList.add(entry.getKey());
            }
        }

        return pointsList;
    }


    public static void makeMove() {
        List<Point> rabbitsList = findHerbivore();
        for (Point pointRabbit : rabbitsList) {
            Point grass = findNearestPoint(findGrass(), pointRabbit);
            Herbivore rabbit = (Herbivore) Field.getField().get(pointRabbit);
            Field.getField().remove(pointRabbit);
            for (int i = 0; i < rabbit.getSpeed(); i++) {

                if(pointRabbit.getX() > grass.getX()) {
                    pointRabbit.setX(pointRabbit.getX() - 1);
                } else if (pointRabbit.getX() < grass.getX()) {
                    pointRabbit.setX(pointRabbit.getX() + 1);
                } else if(pointRabbit.getY() > grass.getY()) {
                    pointRabbit.setY(pointRabbit.getY() - 1);
                } else if (pointRabbit.getY() < grass.getY()) {
                    pointRabbit.setY(pointRabbit.getY() + 1);
                }
            }
            Field.getField().put(pointRabbit, rabbit);
            if (pointRabbit.getX() == grass.getX() && pointRabbit.getY() == grass.getY()) {
                rabbit.eatGrass();
                //Field.getField().remove(grass);
            }

        }
    }

    public static Point findNearestPoint(List<Point> points, Point target) {
        if (points.isEmpty()) {
            return null;
        }

        Point nearestPoint = points.get(0);
        double minDistance = distance(nearestPoint, target);

        for (Point point : points) {
            double distance = distance(point, target);
            if (distance < minDistance) {
                minDistance = distance;
                nearestPoint = point;
            }
        }

        return nearestPoint;
    }
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public void eatGrass() {
        health++;
    }

    @Override
    public String toString() {
        return Emoji.RABBIT.getSymbol();
    }


}