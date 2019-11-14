package software.testing.fourinarow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void shouldHaveTwoValues() {
        assertEquals(2, Player.values().length);
    }
}
