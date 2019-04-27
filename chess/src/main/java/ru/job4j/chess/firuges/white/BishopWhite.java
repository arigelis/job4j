package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        boolean isDiagonal = (Math.abs((source.x - dest.x)) == Math.abs((source.y - dest.y)));//((source.x - dest.x) == (source.y - dest.y));
        if (!isDiagonal) {
            throw new ImpossibleMoveException();
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
