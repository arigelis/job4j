package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int counter = 1;
        if (source.y != dest.y && source.x != dest.x) {
            steps = new Cell[]{source};
        } else {
            while (source.y != dest.y) {
                if (source.y == dest.y + counter && source.x == dest.x) {
                    steps = new Cell[]{dest};
                    break;
                }
                if (source.y < dest.y) {
                    counter--;
                } else {
                    counter++;
                }
            }
            while (source.x != dest.x) {
                if (source.x == dest.x + counter && source.y == dest.y) {
                    steps = new Cell[]{dest};
                    break;
                }
                if (source.x < dest.x) {
                    counter--;
                } else {
                    counter++;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}
