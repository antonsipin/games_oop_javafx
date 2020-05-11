package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {
    @Test
    public void findBy() {
        Logic logic = new Logic();
        int cell = logic.findBy(C1);
        assertThat(cell,is(-1));
    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] dest = bishopBlack.way(C1, G5);
        assertThat(dest,is(new Cell[]{D2, E3, F4, G5}));
    }

    @Test
    public void copy() {
        Cell position = BishopBlack.getPosition();
        BishopBlack bishopBlack = new BishopBlack(position);
        Figure dest = bishopBlack.copy(position);
        assertThat(dest.position(),is(bishopBlack.position()));
    }

    @Test
    public void move() {
        Logic logic = new Logic();
        boolean rst = logic.move(C1, G5);
        assertThat(rst,is(false));
    }

    @Test
    public void isWayFree() {
        Logic logic = new Logic();
        boolean rst = logic.move(E5, F6);
        assertThat(rst,is(false));
    }
}
