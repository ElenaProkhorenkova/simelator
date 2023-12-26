public class Renderer {
    public static void drawMap() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (Field.getField().containsKey(new Point(i, j))) {
                    System.out.print(Field.getField().get(new Point(i, j)).toString());

                } else {
                    System.out.print(Emoji.EMPTY.getSymbol());
                }

            }
            System.out.println();

        }
    }
}
