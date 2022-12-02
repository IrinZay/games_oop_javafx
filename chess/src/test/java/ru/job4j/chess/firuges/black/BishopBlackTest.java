package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {
    @Test
    public void whenCreated() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C1);
    }

    @Test
    public void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.copy(Cell.B2).position()).isEqualTo(Cell.B2);
    }

    @Test
    public void whenMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    public void whenWrongMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,()
                -> bishopBlack.way(Cell.C2));
        String expected = "Could not way by diagonal from C1 to C2";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}