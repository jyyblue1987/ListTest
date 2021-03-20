package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import lists.DoublyLinkedList;

public class DoublyLinkedListTest {

	@Test
	public void add_ExpectListSizeToIncreaseBy1() {
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		int expectedSize = 1;

		list.add(5);

		assertEquals(expectedSize, list.size());
	}

	@Test
	public void add_addTwo_ExpectListSizeToIncreaseBy2() {
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		int expectedSize = 2;

		list.add(5);
		list.add(10);

		assertEquals(expectedSize, list.size());
	}

	@Test
	public void add_addThree_ExpectThemAddedToEnd() {
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		List expectedOrder = List.of(5, 10, 15);

		list.add(5);
		list.add(10);
		list.add(15);

		assertEquals(expectedOrder, list.array());
	}

	@Test
	public void add_atSpecificIndex_ExpectIndexToContainValue() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		int expectedSize = 3;

		list.add("Hello");
		list.add("World");
		list.add(1, ", ");

		assertEquals(expectedSize, list.size());
		assertEquals(", ", list.get(1));

	}

	@Test
	public void add_atIndex0_ExpectListInReverseOrder() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List expectedOrder = List.of("Geralt", "of", "Rivia");

		list.add(0, "Rivia");
		list.add(0, "of");
		list.add(0, "Geralt");

		assertEquals(expectedOrder, list.array());
	}

	@Test
	public void addAll_ShouldAddAllItemsToEnd() {
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		List toAdd = List.of(3, 4, 5, 6);
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
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		List toAdd = List.of(3, 4, 5, 6);
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
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		int expectedSize = 0;

		list.add(1);
		list.add(2);
		list.clear();

		assertEquals(expectedSize, list.size());
	}

	@Test
	public void contains_ItemIsInList_ShouldReturnTrue() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		String item = "42";

		list.add(String.valueOf(item));
		list.add("Hello World");

		assertTrue(list.contains(item));
	}

	@Test
	public void contains_ItemIsNotInList_ShouldReturnFalse() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		String item = "42";

		list.add("39");
		list.add("Hello World");

		assertFalse(list.contains(item));
	}

	@Test
	public void indexOf_ItemIsInList_ShouldReturnIndex() {
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
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
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
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
		DoublyLinkedList list = new DoublyLinkedList<String>();

		assertTrue(list.isEmpty());
	}

	@Test
	public void isEmpty_ListHasItems_ShouldReturnFalse() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		list.add("hello");
		list.add("world");

		assertFalse(list.isEmpty());
	}

	@Test
	public void lastIndexOf_ItemAppearsMultipleTimes_ShouldReturnIndex() {
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		int expectedIndex = 5;
		int value = 42;
		List toAdd = List.of(0, 1, value, value, 4, value, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	public void lastIndexOf_ItemDoesNotAppear_ShouldReturnIndex() {
		DoublyLinkedList list = new DoublyLinkedList<Integer>();
		int expectedIndex = -1;
		int value = 42;
		List toAdd = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		list.addAll(toAdd);

		assertEquals(expectedIndex, list.lastIndexOf(value));
	}

	@Test
	public void remove_Index_ShouldRemoveItemAtIndex() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		int removeAt = 0;
		String value = "hello";
		List toAdd = List.of(value, "world", "I'm", "java");
		list.addAll(toAdd);
		int sizeBeforeRemove = list.size();

		String valueBeforeRemove = list.get(removeAt);
		String removed = list.remove(removeAt);
		String valueAfterRemove = list.get(removeAt);

		assertEquals(value, removed);
		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}

	@Test
	public void remove_ObjectParam_ShouldReturnTrue() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		int removeAt = 0;
		String value = "hello";
		List toAdd = List.of(value, "world", "I'm", "java");
		list.addAll(toAdd);
		int sizeBeforeRemove = list.size();

		String valueBeforeRemove = list.get(removeAt);
		assertTrue(list.remove(value));
		String valueAfterRemove = list.get(removeAt);

		assertNotEquals(valueBeforeRemove, valueAfterRemove);
		assertEquals(sizeBeforeRemove - 1, list.size());
	}

	@Test
	public void iterator_EmptyListHasNext_ShouldReturnFalse() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		Iterator<String> itr = list.iterator();
		assertFalse(itr.hasNext());
	}

	@Test
	public void iterator_FullListHasNext_ShouldReturnTrue() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		Iterator<String> itr = list.iterator();
		assertTrue(itr.hasNext());
	}

	@Test
	public void iterator_FullListNext_ShouldGetItem() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		Iterator<String> itrToAdd = toAdd.iterator();
		for (String element : list)
			assertEquals(element, itrToAdd.next());
	}

	@Test
	public void iterator_FullListHasPrev_ShouldReturnFalse() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		ListIterator<String> itr = list.listIterator();
		assertFalse(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListHasPrev_ShouldReturnTrue() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		assertTrue(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListWithAddAllPrev_ShouldGetItem() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListWithAddIndexPrev_ShouldGetItem() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		list.add(0, "Sterling");
		list.add(0, "Goodfellow");
		list.add(0, "Iacas");
		list.add(0, "Tonwen");
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Sterling");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Tonwen");
		assertFalse(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListWithAddAllIndexPrev_ShouldGetItem() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		list.add(0, "Tonwen");
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas");
		list.addAll(0, toAdd);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListWithRemoveIndexHeadPrev_ShouldGetItem() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove(0);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertFalse(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListWithRemoveIndexPrev_ShouldGetItem() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove(1);
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListWithRemoveHeadPrev_ShouldGetItem() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove("Sterling");
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Tonwen");
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertFalse(itr.hasPrevious());
	}

	@Test
	public void iterator_FullListWithRemoveTailPrev_ShouldGetItem() {
		DoublyLinkedList list = new DoublyLinkedList<String>();
		List toAdd = List.of("Sterling", "Goodfellow", "Iacas", "Tonwen");
		list.addAll(toAdd);
		list.remove("Tonwen");
		ListIterator<String> itr = list.listIterator();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
		assertEquals(itr.previous(), "Iacas");
		assertEquals(itr.previous(), "Goodfellow");
		assertEquals(itr.previous(), "Sterling");
		assertFalse(itr.hasPrevious());
	}
}
