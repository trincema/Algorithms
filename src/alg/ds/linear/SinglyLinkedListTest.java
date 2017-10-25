package alg.ds.linear;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Emanuel TRÎNC
 */
public class SinglyLinkedListTest {
	private SinglyLinkedList<String> list;
	
	@Before
	public void setUp() {
		list = new SinglyLinkedList<>();
	}
	
	@Test
	public void shouldBeEmptyAtTheBeginning() {
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void shouldHaveSizeZeroAtBeginning() {
		assertEquals(list.size(), 0);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerByAddingNullElement() {
        list.add(null);
    }
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerByAddingNullElementAtIndex() {
		list.add(1, null);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowIndexOutOfBoundsAddIndexOutOfRange() {
		list.add(1, "John");
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void shouldThrowIndexOutOfBoundsGetIndexOutOfRange() {
		list.get(0);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerIfElementNull() {
		list.contains(null);
	}
	
	@Test
	public void containsShouldWorkCorrectlyIfListEmpty() {
		assertFalse(list.contains(new String("")));
	}
	
	@Test
	public void removeAtIndexShouldWorkCorrectlyIfListEmpty() {
		assertNull(list.remove(0));
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerByRemovingNullElement() {
		list.remove(null);
	}

}
