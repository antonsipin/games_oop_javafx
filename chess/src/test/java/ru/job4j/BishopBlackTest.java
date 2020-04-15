package ru.job4j;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {
    @Test
    public void positionCheck() {
        Cell position = BishopBlack.getPosition();
        BishopBlack bishopBlack = new BishopBlack(position);
        assertThat(bishopBlack.position(),is(position));
    }

    @Test
    public void copyCheck() {
        Cell position = BishopBlack.getPosition();
        BishopBlack bishopBlack = new BishopBlack(position);
        Figure dest = bishopBlack.copy(position);
        assertThat(dest.position(),is(bishopBlack.position()));
    }

    @Test
    public void wayCheck() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] dest = bishopBlack.way(C1, G5);
        assertThat(dest,is(new Cell[]{D2, E3, F4, G5}));
    }
}
