package software.testing.fourinarow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GridPositionTest {

	@Test
	public void shouldCreateGridPositionWithPositiveValues() {
		GridPosition position = new GridPosition();
		assertEquals(Integer.valueOf(0), position.getRow());
		assertEquals(Integer.valueOf(0), position.getColumn());
	}
	
	@Test
	public void shouldSetRowWithPositiveValue() { 
		GridPosition position = new GridPosition(); 
		position.setRow(10);
		assertEquals(Integer.valueOf(10), position.getRow());
	}
	
	@Test
	public void shouldSetRowWithValueOne() { 
		GridPosition position = new GridPosition(); 
		position.setRow(1);
		assertEquals(Integer.valueOf(1), position.getRow());
	}
	
	@Test
	public void shouldSetRowWithZeroValue() { 
		GridPosition position = new GridPosition(); 
		position.setRow(0); 
		assertEquals(Integer.valueOf(0), position.getRow());
	}
	
    @Test
    public void shouldSetRowWithNullValue() { 
    	GridPosition position = new GridPosition(); 
    	position.setRow(null); 
		assertEquals(Integer.valueOf(0), position.getRow());
    }
    
    @Test
    public void shouldThrowExceptionIfRowIsNegative() {

	    assertThrows(IllegalArgumentException.class, () -> {
            GridPosition position = new GridPosition();
            position.setRow(-1);
        });
    }
    
    @Test
	public void shouldSetColumnWithPositiveValue() { 
		GridPosition position = new GridPosition(); 
		position.setColumn(10);
		assertEquals(Integer.valueOf(10), position.getColumn());
	}
	
	@Test
	public void shouldSetColumnWithValueOne() { 
		GridPosition position = new GridPosition(); 
		position.setColumn(1);
		assertEquals(Integer.valueOf(1), position.getColumn());
	}
	
	@Test
	public void shouldSetColumnWithZeroValue() { 
		GridPosition position = new GridPosition(); 
		position.setColumn(0); 
		assertEquals(Integer.valueOf(0), position.getColumn());
	}
	
    @Test
    public void shouldSetColumnWithNullValue() { 
    	GridPosition position = new GridPosition(); 
    	position.setColumn(null); 
		assertEquals(Integer.valueOf(0), position.getColumn());
    }
    
    @Test
    public void shouldThrowExceptionIfColumnIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            GridPosition position = new GridPosition();
            position.setColumn(-1);
        });
    }

}
