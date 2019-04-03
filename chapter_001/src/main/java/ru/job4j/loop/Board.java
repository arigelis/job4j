package ru.job4j.loop;

/**
 * chesssmate board
 */
public class Board {
    /**
     * @param width
     * @param height
     * @return
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0) {
                    if (i % 2 == 0) {
                        screen.append("X");
                    } else {
                        screen.append(" ");
                    }
                } else {
                    if (i % 2 != 0) {
                        screen.append("X");
                    } else {
                        screen.append(" ");
                    }
                }
            }
            screen.append(ln);
        }
        System.out.println(screen.toString());
        return screen.toString();
    }
}
