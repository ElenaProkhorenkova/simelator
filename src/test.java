import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {
        FieldGenerator.placeRock();
        FieldGenerator.placeGrass();
        FieldGenerator.placeHerbivore();
        FieldGenerator.placeTree();
        FieldGenerator.placePredator();
        while (true) {
            for(int clear = 0; clear < 100; clear++)
            {
                System.out.println("\b") ;
            }
            Renderer.drawMap();
            Herbivore.makeMove();
            Thread.sleep(1000);
        }
        //System.out.println("\n");
        //Renderer.drawMap();

    }
}
