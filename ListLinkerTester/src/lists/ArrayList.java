package lists;

/**
 * a generic list collection that is backed by an Object array that stored in
 * contiguous memory locations
 *
 * @author YOUR NAME
 * @version 1.0
 * @since 2021-03-20
*/

import java.util.*;

public class ArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private E[] items;

    /**
     * Constructor
     *
     * @param
     * @return
     */
    public ArrayList() {
        clear();
    }

    /**
     * Check if list empty
     *
     * @param
     * @return  true: empty,
     *          false: non empty
    */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if object is contained in list
     *
     * @param   Object o:
     * @return  true: contained,
     *          false: not exist
     */

    public boolean contains(Object o)
    {
        return (indexOf(o) != -1);
    }

    /**
     * Generate Iterator
     *
     * @param
     * @return  Iterator
     */

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Add element to list
     *
     * @param e: inserted element
     * @return  true/false : success/fail
     */
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    /**
     * Remove element from list
     *
     * @param e: remove element
     * @return  true/false : success/fail
     */
    public boolean remove(Object o) {
        int index = indexOf(o);
        return remove(index) != null;
    }

    /**
     * add element list to last position of list
     *
     * @param c: element list
     * @return  true/false : success/fail
     */

    public boolean addAll(Collection<? extends E> c) {
        for (E e : c){
            if( add(e) == false )
                return false;
        }

        return true;
    }

    /**
     * add element list to last position of list
     *
     * @param   c: element list
     *          index: inserted position
     * @return  true/false : success/fail
     */

    public boolean addAll(int index, Collection<? extends E> c) {
        int i = index;
        for (E e : c){
            add(i, e);
            i++;
        }

        return true;
    }

    /**
     * clear list
     *
     * @param
     * @return
     */
    public void clear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }


    /**
     * Pick an element from list at position
     *
     * @param index: position
     * @return picked element
     */

    public E get(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();

        return items[index];
    }

    /**
     * set an element to list at position
     *
     * @param index: position
     * @return original element
     */

    public E set(int index, E newVal) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        E old = items[index];
        items[index] = newVal;
        return old;
    }

    /**
     * Add element to list
     *
     * @param   index: inserted position
     *          e: inserted element
     * @return
     */

    public void add(int index, E element) {
        if( index > size )
            return;

        if (items.length == size) ensureCapacity(size + 20);

        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = element;
        size++;
    }

    /**
     * Remove element from list
     *
     * @param   index: removed position
     *
     * @return Removed element
     */

    public E remove(int index) {
        if( index < 0 || index >= size )
            return null;

        E old = items[index];

        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return old;
    }

    /**
     * find index of object in list from left
     *
     * @param   o: object
     *
     * @return object position
     */

    public int indexOf(Object o)
    {
        int result = -1;

        for(int i = 0; i < size; i++)
        {
            if (o.equals(items[i]))
            {
                result = i;
                break;
            }         
        }

        return result;
    }

    /**
     * find index of object in list from right
     *
     * @param   o: object
     *
     * @return object position
     */

    public int lastIndexOf(Object o)
    {
        int result = -1;

        for(int i = size - 1; i >= 0; i--)
        {
            if (o.equals(items[i]))
            {
                result = i;
                break;
            }         
        }

        return result;
    }

    /**
     * get sub list from list
     *
     * @param   fromIndex: start index
     *          toIndex: end index
     *
     * @return collection of sublist
     */


    public List<E> subList(int fromIndex, int toIndex)
    {
        List<E> sublist = new java.util.ArrayList<E>();
        for(int i = fromIndex; i < toIndex; i++)
        {
            sublist.add(items[i]);
        }

        return sublist;
    }

    /**
     * get size of list
     *
     * @param
     *
     * @return size of list
     */


    public int size() {
        return size;
    }


    private class ArrayListIterator implements Iterator<E> {

        private int current = 0;

        public boolean hasNext() {
            return current < size;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[current++];
        }
    }

    /**
     * expand capacity of list
     *
     * @param newCapacity: new capacity of list
     *
     * @return
     */


    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) 
            return;

        E[] old = items;
        items = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            items[i] = old[i];
        }
    }


    public List<E> array() {
        List<E> result = new java.util.ArrayList<E>();
        for(int i = 0; i < size; i++)
            result.add(items[i]);

        return result;
    }

}