import lists.ArrayList;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class Main {

    public static void main(String[] args) {
        add_ExpectListSizeToIncreaseBy1();
        add_addTwo_ExpectListSizeToIncreaseBy2();
        add_addThree_ExpectThemAddedToEnd();
    }

//
    private static void add_ExpectListSizeToIncreaseBy1() {
        ArrayList list = new ArrayList<Integer>();
        int expectedSize = 1;

        list.add(5);

        assertEquals(expectedSize, list.size());
    }

    private static
    void add_addTwo_ExpectListSizeToIncreaseBy2() {
        ArrayList list = new ArrayList<Integer>();
        int expectedSize = 2;

        list.add(5);
        list.add(10);

        assertEquals(expectedSize, list.size());
    }

    private static
    void add_addThree_ExpectThemAddedToEnd() {
        ArrayList list = new ArrayList<Integer>();
        List expectedOrder = Arrays.asList(5, 10, 15);

        list.add(5);
        list.add(10);
        list.add(15);

        assertEquals(expectedOrder, list);
    }

    private static
    void add_atSpecificIndex_ExpectIndexToContainValue() {
        ArrayList list = new ArrayList<String>();
        int expectedSize = 3;

        list.add("Hello");
        list.add("World");
        list.add(1, ", ");

        assertEquals(expectedSize, list.size());
        assertEquals(", ", list.get(1));

    }

    private static
    void add_atIndex0_ExpectListInReverseOrder() {
        ArrayList list = new ArrayList<String>();
        List expectedOrder = Arrays.asList("Geralt", "of", "Rivia");

        list.add(0, "Rivia");
        list.add(0, "of");
        list.add(0, "Geralt");

        assertEquals(expectedOrder, list);
    }

    private static
    void addAll_ShouldAddAllItemsToEnd() {
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

    private static
    void addAll_AtSpecificIndex_ShouldAddAllItemsAtIndex() {
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

    private static
    void clear_ShouldMakeListSizeZero() {
        ArrayList list = new ArrayList<Integer>();
        int expectedSize = 0;

        list.add(1);
        list.add(2);
        list.clear();

        assertEquals(expectedSize, list.size());
    }

    private static
    void contains_ItemIsInList_ShouldReturnTrue() {
        ArrayList list = new ArrayList<String>();
        String item = "42";

        list.add(String.valueOf(item));
        list.add("Hello World");

        assertTrue(list.contains(item));
    }

    private static
    void contains_ItemIsNotInList_ShouldReturnFalse() {
        ArrayList list = new ArrayList<String>();
        String item = "42";

        list.add("39");
        list.add("Hello World");

        assertFalse(list.contains(item));
    }

    private static
    void indexOf_ItemIsInList_ShouldReturnIndex() {
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

    private static
    void indexOf_ItemIsNotInList_ShouldReturnNegative1() {
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

    private static
    void isEmpty_EmptyList_ShouldReturnTrue() {
        ArrayList list = new ArrayList<String>();

        assertTrue(list.isEmpty());
    }

    private static
    void isEmpty_ListHasItems_ShouldReturnFalse() {
        ArrayList list = new ArrayList<String>();
        list.add("hello");
        list.add("world");

        assertFalse(list.isEmpty());
    }

    private static
    void lastIndexOf_ItemAppearsMultipleTimes_ShouldReturnIndex() {
        ArrayList list = new ArrayList<Integer>();
        int expectedIndex = 5;
        int value = 42;
        List toAdd = Arrays.asList(0, 1, value, value, 4, value, 6, 7, 8, 9, 10);

        list.addAll(toAdd);

        assertEquals(expectedIndex, list.lastIndexOf(value));
    }

    private static
    void lastIndexOf_ItemDoesNotAppear_ShouldReturnIndex() {
        ArrayList list = new ArrayList<Integer>();
        int expectedIndex = -1;
        int value = 42;
        List toAdd = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.addAll(toAdd);

        assertEquals(expectedIndex, list.lastIndexOf(value));
    }

    private static
    void remove_Index_ShouldRemoveItemAtIndex() {
        ArrayList list = new ArrayList<String>();
        int removeAt = 0;
        String value = "hello";
        List toAdd = Arrays.asList(value, "world", "I'm", "java");
        list.addAll(toAdd);
        int sizeBeforeRemove = list.size();

        String valueBeforeRemove = (String) list.get(removeAt);
        boolean removed = list.remove(removeAt);
        String valueAfterRemove = (String)list.get(removeAt);

        assertEquals(value, removed);
        assertNotEquals(valueBeforeRemove, valueAfterRemove);
        assertEquals(sizeBeforeRemove - 1, list.size());
    }

    private static
    void remove_IndexDoesNotExist_ShouldReturnNull() {
        ArrayList list = new ArrayList<String>();
        int removeAt = 42;
        String value = "hello";

        List toAdd = Arrays.asList(value, "world", "I'm", "java");
        list.addAll(toAdd);
        int sizeBeforeRemove = list.size();

        boolean removed = list.remove(removeAt);

        assertNull(removed);
        assertEquals(sizeBeforeRemove, list.size());
    }

    private static
    void remove_ObjectParam_ShouldReturnTrue() {
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

    private static
    void iterator_EmptyListHasNext_ShouldReturnFalse() {
        ArrayList list = new ArrayList<String>();
        Iterator<String> itr = list.iterator();
        assertEquals(itr.hasNext(), false);
    }

    private static
    void iterator_FullListHasNext_ShouldReturnTrue() {
        ArrayList list = new ArrayList<String>();
        List toAdd = Arrays.asList("Sterling", "Goodfellow", "Iacas", "Tonwen");
        list.addAll(toAdd);
        Iterator<String> itr = list.iterator();
        assertEquals(itr.hasNext(), true);
    }

    private static
    void iterator_FullListNext_ShouldGetItem() {
        ArrayList list = new ArrayList<String>();
        List toAdd = Arrays.asList("Sterling", "Goodfellow", "Iacas", "Tonwen");
        list.addAll(toAdd);
        Iterator<String> itrToAdd = toAdd.iterator();
        for (Object element : list)
            assertEquals(element, itrToAdd.next());
    }
}
