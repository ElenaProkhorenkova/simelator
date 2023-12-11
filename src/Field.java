import java.util.HashMap;
import java.util.Map;

public class Field {
    int height = 10;
    int width = 10;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    static Map<Point, Entity> field = new HashMap<Point, Entity>();

    public static Map<Point, Entity> getField() {
        return field;
    }
}
