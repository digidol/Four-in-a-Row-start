package software.testing.fourinarow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Game Grid.
 *
 * This represents the initial version that is checked out
 * for the laboratory on the testing course.
 *
 * @author Neil Taylor (nst@aber.ac.uk)
 * @version 1.0
 */
public class GameGridTest {

    @Test
    public void shouldIntialiseGrid_withNull() throws FourInARowException {
        Game grid = new Game();
        assertNull(grid.getCellStatus(1, 1));
    }

    @Test
    public void shouldInitialiseGrid_withEmptyCell_AfterReset()
           throws FourInARowException {
        Game grid = new Game();
        grid.reset();
        assertEquals(CellStatus.EMPTY, grid.getCellStatus(0,0));
    }

    /**
     * NOTE: This is a different style of setting up a test. All of the other
     * tests we have looked at do not take a parameter. However, there is
     * the ParameterizedTest where we can specify a list of input values. The
     * test method is run several times, once for each of the input values.
     * Therefore, in this example, it will be executed 7 times. Run the tests
     * and see how they are reported in the output.
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    public void shouldInitialiseGrid_withEmptyCells_AfterReset(int column)
           throws FourInARowException {
        Game grid = new Game();
        grid.reset();
        assertEquals(6, grid.numberOfEmptyCellsInColumn(column));
    }

    @Test
    public void shouldCheckCellStatus_withRow_TooLow() {

        FourInARowException exception = assertThrows(FourInARowException.class, () -> {
            Game grid = new Game();
            CellStatus status = grid.getCellStatus(0, -1);
        });
        assertEquals("Row cannot be negative", exception.getMessage());
    }

    @Test
    public void shouldCheckCellStatus_withRow_TooHigh() {

        FourInARowException exception = assertThrows(FourInARowException.class, () -> {
            Game grid = new Game();
            CellStatus status = grid.getCellStatus(0, 6);
        });
        assertEquals("Row cannot be greater than the number of rows",
                     exception.getMessage());
    }

    @Test
    public void shouldCheckCellStatus_withColumn_TooLow() {

        FourInARowException exception = assertThrows(FourInARowException.class, () -> {
            Game grid = new Game();
            CellStatus status = grid.getCellStatus(-1, 0);
        });
        assertEquals("Column cannot be negative", exception.getMessage());
    }

    @Test
    public void shouldCheckCellStatus_withColumn_TooHigh() {

        FourInARowException exception = assertThrows(FourInARowException.class, () -> {
            Game grid = new Game();
            CellStatus status = grid.getCellStatus(7, 0);
        });
        assertEquals("Column cannot be greater than the number of columns",
                exception.getMessage());
    }

    @Test
    public void shouldCheckCellStatus_withRowAndColumn_Minimum() throws FourInARowException {
        Game grid = new Game();
        CellStatus status = grid.getCellStatus(0, 0);
        assertNull(status);
    }

    @Test
    public void shouldCheckCellStatus_withRowAndColumn_Maximum() throws FourInARowException {
        Game grid = new Game();
        CellStatus status = grid.getCellStatus(6, 5);
        assertNull(status);
    }

    
}
