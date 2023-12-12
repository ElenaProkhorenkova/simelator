public class FieldGenerator {
    static int herbCounter = 15;
    static int predCounter = 10;
    static int treeCounter = 15;
    static int rockCounter = 12;
    static int grassCounter = 15;

    public static Point generatePoint() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new Point(x, y);
    }

    public static void placePredator() {
        while (predCounter > 0) {
            Point point = FieldGenerator.generatePoint();
            if (Field.getField().containsKey(point)) {
                FieldGenerator.placePredator();
            } else {
                Field.getField().put(point, new Predator());
                predCounter--;
            }
            }
        }
    public static void placeHerbivore() {
        while (herbCounter > 0) {
            Point point = FieldGenerator.generatePoint();
            if(Field.getField().containsKey(point)){
                FieldGenerator.placeHerbivore();
            } else {
            Field.getField().put(point, new Herbivore());
            herbCounter--;
            }
        }
    }
    public static void placeRock() {
        while (rockCounter > 0) {
            Point point = FieldGenerator.generatePoint();
            if (Field.getField().containsKey(point)) {
                FieldGenerator.placeRock();
            } else {
                Field.getField().put(point, new Rock());
                rockCounter--;
            }
        }
    }
    public static void placeTree() {
        while (treeCounter > 0) {
            Point point = FieldGenerator.generatePoint();
            if (Field.getField().containsKey(point)) {
                FieldGenerator.placeTree();
            } else {
                Field.getField().put(point, new Tree());
                treeCounter--;
            }
        }
    }
    public static void placeGrass() {
        while (grassCounter > 0) {
            Point point = FieldGenerator.generatePoint();
            if (Field.getField().containsKey(point)) {
                FieldGenerator.placeGrass();
            } else {
                Field.getField().put(point, new Grass());
                grassCounter--;
            }
        }
    }
}
