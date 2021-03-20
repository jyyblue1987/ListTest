package lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LinkedList <E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        clear();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o)
    {
        return (indexOf(o) != -1);
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    public boolean add(E e) {
        return add(size, e);
    }

    public boolean remove(Object o) {
        Node cur = head;
        if( o.equals(head) )
        {
            head = head.next;
        }
        else {
            while (cur != null) {
                Node next = cur.next;

                if (o.equals(next.e)) {
                    if (next != null)
                        cur.next = next.next;
                    else
                        cur.next = null;
                    break;
                }
                cur = cur.next;
            }
        }

        size--;
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        for (E e : c){
            if( add(e) == false )
                return false;
        }

        return true;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        int i = index;
        for (E e : c){
            if( add(i, e) == false )
                return false;
            i++;
        }

        return true;
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    public E get(int index) {
        Node cur = head;
        int i = 0;
        while(cur != null) {
            if( i == index )
                return (E)cur.e;

            i++;
        }

        return null;
    }

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

    public boolean add(int index, E e) {
        if( index > size )
            return false;

        boolean result = false;

        Node node = new Node();
        node.e = e;
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

        return result;
    }


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

    public int size() {
        return size;
    }


    private class ArrayListIterator implements Iterator<E> {

        private Node current = head;

        public boolean hasNext() {
            return current.next != null;
        }

        public E next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            current = current.next;
            return (E)current.e;
        }
    }
}