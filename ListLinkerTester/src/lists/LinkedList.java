package lists;

/**
 * a generic list collection that is backed by an Object array that stored in
 * contiguous memory locations
 *
 * @author YOUR NAME
 * @version 1.0
 * @since 2021-03-20
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LinkedList <E> implements Iterable<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    /**
     * Constructor
     *
     * @param
     * @return
     */

    public LinkedList() {
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
        Node cur = head;
        if( head == null )
            return false;

        boolean result = false;

        if( o.equals(head.e) )
        {
            head = head.next;
            result = true;
        }
        else {
            while (cur != null) {
                Node next = cur.next;

                if (o.equals(next.e)) {
                    if (next != null)
                        cur.next = next.next;
                    else
                        cur.next = null;

                    result = true;
                    break;
                }
                cur = cur.next;
            }
        }

        size--;
        return result;
    }

    /**
     * add element list to last position of list
     *
     * @param c: element list
     * @return  true/false : success/fail
     */

    public boolean addAll(Collection<? extends E> c) {
        for (E e : c){
            add(e);
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
        head = null;
        tail = null;
    }

    /**
     * Pick an element from list at position
     *
     * @param index: position
     * @return picked element
     */

    public E get(int index) {
        Node cur = head;
        int i = 0;
        while(cur != null) {
            if( i == index )
                return (E)cur.e;

            cur = cur.next;

            i++;
        }

        return null;
    }

    /**
     * set an element to list at position
     *
     * @param index: position
     * @return original element
     */

    public E set(int index, E newVal) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();

        Node cur = head;
        int i = 0;
        E old = null;
        while(cur != null) {
            if( i == index ) {
                old = (E)cur.e;
                cur.e = newVal;
                break;
            }
            cur = cur.next;

            i++;
        }

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

        boolean result = false;

        Node node = new Node();
        node.e = element;
        node.next = null;


        if( index == 0 )
        {
            node.next = head;
            head = node;
            result = true;
        }
        else {

            int i = 0;
            Node cur = head;
            while(cur != null)
            {
                if( i == index - 1 )
                {
                    node.next = cur.next;
                    cur.next = node;
                    result = true;
                    break;
                }
                cur = cur.next;

                i++;
            }
        }

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

        Node cur = head;
        E old = null;
        if( index == 0 )
        {
            head = head.next;
            old = (E)cur.e;
        }
        else {
            int i = 0;
            while (cur != null) {
                Node next = cur.next;

                if (i == index - 1) {
                    if (next != null)
                        cur.next = next.next;
                    else
                        cur.next = null;

                    old = (E)cur.e;

                    break;
                }
                cur = cur.next;
                i++;
            }
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

        Node cur = head;
        int i = 0;
        while(cur != null)
        {
            if( o.equals(cur.e) ) {
                result = i;
                break;
            }
            cur = cur.next;
            i++;
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

        Node cur = head;
        int i = 0;
        while(cur != null)
        {
            if( o.equals(cur.e) ) {
                result = i;
            }
            cur = cur.next;
            i++;
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
        Node cur = head;
        int i = 0;
        while(cur != null)
        {
            if( fromIndex <= i && i < toIndex )
                sublist.add((E)cur.e);

            cur = cur.next;
            i++;
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

        private Node current = head;

        public boolean hasNext() {
            if( current == null )
                return false;

            return current.next != null;
        }

        public E next() {
            if( current == null )
                return null;

            E e = (E)current.e;
            current = current.next;
            return e;
        }
    }

    public List<E> array() {
        Node<E> cur = head;
        List<E> result = new java.util.ArrayList<E>();
        while(cur != null) {
            result.add(cur.e);
            cur = cur.next;

        }

        return result;
    }
}