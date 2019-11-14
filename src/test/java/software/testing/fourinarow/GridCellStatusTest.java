package software.testing.fourinarow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridCellStatusTest {

    @Test
    public void shouldHaveThreeValues() {
        assertEquals(3, CellStatus.values().length);
    }

}
