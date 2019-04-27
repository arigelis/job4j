package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.KnightBlack;
import ru.job4j.chess.firuges.white.KnightWhite;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        int destIndex = this.findBy(dest);
        if (index != -1 && destIndex == -1) {//проверка на занятость ячейки.
            if (!this.figures[index].getClass().equals(KnightBlack.class) || !this.figures[index].getClass().equals(KnightWhite.class)) {
                rst = checkWay(source, dest);
            }
            if (rst) {
                try {
                    throw new OccupiedWayException();
                } catch (OccupiedWayException e) {
                    e.printStackTrace();
                }
                rst = false;
            } else {
                Cell[] steps = new Cell[0];
                try {
                    steps = this.figures[index].way(source, dest);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    rst = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        } else {
            try {
                throw new ImpossibleMoveException();
            } catch (ImpossibleMoveException e) {
                e.printStackTrace();
            }
        }
        return rst;
    }

    private boolean intervalCheckX(int minX, int maxX, int staticY) {
        boolean result = false;
        for (int i = minX + 1; i < maxX; i++) {
            for (int j = 0; j < this.figures.length; j++) {
                if (i == this.figures[j].position().x && staticY == this.figures[j].position().y) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean intervalCheckY(int minY, int maxY, int staticX) {
        boolean result = false;
        for (int i = minY + 1; i < maxY; i++) {
            for (int j = 0; j < this.figures.length; j++) {
                if (i == this.figures[j].position().y && staticX == this.figures[j].position().x) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean intervalCheckXY(int sourceX, int sourceY, int destX, int destY) {
        boolean result = false;
        int counterX = 0;
        int counterY = 0;
        for (int i = 0; i < Math.abs(sourceX - destX); i++) {
            counterX = (sourceX > destX) ? --counterX : ++counterX;
            counterY = (sourceY > destY) ? --counterY : ++counterY;
            for (int j = 0; j < this.figures.length; j++) {
                if (sourceX + counterX == this.figures[j].position().x && sourceY + counterY == this.figures[j].position().y) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean checkWay(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        int destIndex = this.findBy(dest);
        if (source.x != dest.x && source.y != dest.y) {//если движение было по диагонали
            if (Math.abs((source.x - dest.x)) == Math.abs((source.y - dest.y))) {//((source.x - dest.x) == (source.y - dest.y)) {//(Math.abs((source.x - dest.x)) == Math.abs((source.y - dest.y)))
                rst = intervalCheckXY(source.x, source.y, dest.x, dest.y);
            } else {
                rst = true;
            }
        } else if (source.x != dest.x && source.y == dest.y) {//если движение было по горизонтали
            if (source.x > dest.x) {
                rst = intervalCheckX(dest.x, source.x, dest.y);
            } else {
                rst = intervalCheckX(source.x, dest.x, dest.y);
            }
        } else if (source.x == dest.x && source.y != dest.y) {//если движение было по вертикали
            if (source.y > dest.y) {
                rst = intervalCheckY(dest.y, source.y, source.x);
            } else {
                rst = intervalCheckY(source.y, dest.y, source.x);
            }
        }

        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
