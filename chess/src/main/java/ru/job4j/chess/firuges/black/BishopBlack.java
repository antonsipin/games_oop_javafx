package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {

    public static Cell getPosition() {
        return position;
    }

    private static Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = dest.x - source.x;
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x)/size;
        int deltaY = (dest.y - source.y)/size;
        for (int index = 0; index < size; index++) {
            int x = index + deltaX + source.x;
            int y = index + deltaY + source.y;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (deltaX != 0 && deltaY != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
