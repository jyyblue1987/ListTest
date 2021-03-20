package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import lists.ArrayList;
import org.junit.Test;

public class ArrayListTest {

	@Test
	public void add_ExpectListSizeToIncreaseBy1() {
		ArrayList list = new ArrayList<Integer>();
		int expectedSize = 1;

		list.add(5);

		assertEquals(expectedSize, list.size());
	}

	@Test
	public void add_addTwo_ExpectListSizeToIncreaseBy2() {
		ArrayList list = new ArrayList<Integer>();
		int expectedSize = 2;

		list.add(5);
		list.add(10);

		assertEquals(expectedSize, list.size());
	}

	@Test
	public void add_addThree_ExpectThemAddedToEnd() {
		ArrayList list = new ArrayList<Integer>();
		List expectedOrder = Arrays.asList(5, 10, 15);

		list.add(5);
		list.add(10);
		list.add(15);

		assertEquals(expectedOrder, list);
	}

	@Test
	public void add_atSpecificIndex_ExpectIndexToContainValue() {
		ArrayList list = new ArrayList<String>();
		int expectedSize = 3;

		list.add("Hello");
		list.add("World");
		list.add(1, ", ");

		assertEquals(expectedSize, list.size());
		assertEquals(", ", list.get(1));

	}

	@Test
	public void add_atIndex0_ExpectListInReverseOrder() {
		ArrayList list = new ArrayList<String>();
		List expectedOrder = Arrays.asList("Geralt", "of", "Rivia");

		list.add(0, "Rivia");
		list.add(0, "of");
		list.add(0, "Geralt");

		assertEquals(expectedOrder, list);
	}

	@Test
	public void addAll_ShouldAddAllItemsToEnd() {
		ArrayList list = new ArrayList<Integer>();
		List toAdd = Arrays.asList(3, 4, 5, 6);
		int expectedSize = 6;

		list.add(1);
		list.add(2);
		list.addAll(toAdd);

		assertEquals(expectedSize, list.size());
		List added = list.subList(2, 6);

		assertEquals(toAdd, added);
	}

	@Test
	public void addAll_AtSpecificIndex_ShouldAddAllItemsAtIndex() {
		ArrayList list = new ArrayList<Integer>();
		List toAdd = Arrays.asList(3, 4, 5, 6);
		int expectedSize = 6;

		list.add(1);
		list.add(2);
		list.addAll(1, toAdd);

		assertEquals(expectedSize, list.size());
		List added = list.subList(1, 5);
		assertEquals(toAdd, added);
	}

	@Test
	public void clear_ShouldMakeListSizeZero() {
		ArrayList list = new ArrayList<Integer>();
		int expectedSize = 0;

		list.add(1);
		list.add(2);
		list.clear();

		assertEquals(expectedSize, list.size());
	}

	@Test
	public void contains_ItemIsInList_ShouldReturnTrue() {
		ArrayList list = new ArrayList<String>();
		String item = "42";

		list.add(String.valueOf(item));
		list.add("Hello World");

		assertTrue(list.contains(item));
	}

	@Test
	public void contains_ItemIsNotInList_ShouldReturnFalse() {
		ArrayList list = new ArrayList<String>();
		String item = "42";

		list.add("39");
		list.add("Hello World");

		assertFalse(list.contains(item));
	}

	@Test
	public void indexOf_ItemIsInList_ShouldReturnIndex() {
		ArrayList list = new ArrayList<Integer>();
		int expectedIndex = 4;
		int value = 42;
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(value);
		list.add(5);

		assertEquals(expectedIndex, list.indexOf(value));
	}

	@Test
	public void indexOf_ItemIsNotInList_ShouldReturnNegative1() {
		ArrayList list = new ArrayList<Integer>();
		int expectedIndex = -1;
		int value = 39;
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		assertEquals(expectedIndex, list.indexOf(value));
	}

	@Test
	public void isEmpty_EmptyList_ShouldReturnTrue() {
		ArrayList list = new ArrayList<String>();

		assertTrue(list.isEmpty());
	}

	@Test
	public void isEmpty_ListHasItems_ShouldReturnFalse() {
		ArrayList list = new ArrayList<String>();
		list.add("hello");
		list.add("world");

		assertFalse(list.isEmpty());
	}

	@Test
	public void lastIndexOf_ItemAppearsMultipleTimes_ShouldReturnIndex() {
		ArrayList list = new ArrayList<Integer>();
		int expectedIndex = 5;
		int value = 42;
		List toAdd = Arrays.asList(0, 1, value, value, 4, value, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	public void lastIndexOf_ItemDoesNotAppear_ShouldReturnIndex() {
		ArrayList list = new ArrayList<Integer>();
		int expectedIndex = -1;
		int value = 42;
		List toAdd = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	public void remove_Index_ShouldRemoveItemAtIndex() {
		ArrayList list = new ArrayList<String>();
		int removeAt = 0;
		String value = "hello";
		List toAdd = Arrays.asList(value, "world", "I'm", "java");
		list.addAll(toAdd);
		int sizeBeforeRemove = list.size();

		String valueBeforeRemove = (String) list.get(removeAt);
		String removed = (String)list.remove(removeAt);
		String valueAfterRemove = (String)list.get(removeAt);

		assertEquals(value, removed);
		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}

	@Test
	public void remove_IndexDoesNotExist_ShouldReturnNull() {
		ArrayList list = new ArrayList<String>();
		int removeAt = 42;
		String value = "hello";

		List toAdd = Arrays.asList(value, "world", "I'm", "java");
		list.addAll(toAdd);
		int sizeBeforeRemove = list.size();

		String removed = (String)list.remove(removeAt);

		assertNull(removed);
		assertEquals(sizeBeforeRemove, list.size());
	}

	@Test
	public void remove_ObjectParam_ShouldReturnTrue() {
		ArrayList list = new ArrayList<String>();
		int removeAt = 0;
		String value = "hello";
		List toAdd = Arrays.asList(value, "world", "I'm", "java");
		list.addAll(toAdd);
		int sizeBeforeRemove = list.size();

		String valueBeforeRemove = (String) list.get(removeAt);
		assertTrue(list.remove(value));
		String valueAfterRemove =(String) list.get(removeAt);

		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}

	@Test
	public void iterator_EmptyListHasNext_ShouldReturnFalse() {
		ArrayList list = new ArrayList<String>();
		Iterator<String> itr = list.iterator();
		assertEquals(itr.hasNext(), false);
	}

	@Test
	public void iterator_FullListHasNext_ShouldReturnTrue() {
		ArrayList list = new ArrayList<String>();
		List toAdd = Arrays.asList("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		Iterator<String> itr = list.iterator();
		assertEquals(itr.hasNext(), true);
	}

	@Test
	public void iterator_FullListNext_ShouldGetItem() {
		ArrayList list = new ArrayList<String>();
		List toAdd = Arrays.asList("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		Iterator<String> itrToAdd = toAdd.iterator();
		for (Object element : list)
			assertEquals(element, itrToAdd.next());
	}
}
