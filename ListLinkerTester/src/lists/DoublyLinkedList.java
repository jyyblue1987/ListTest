package lists;

import java.util.*;

public class DoublyLinkedList <E> implements Iterable<E> {
    private int size;
    private DoublyLinkedNode<E> head;

    public DoublyLinkedList() {
        clear();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o)
    {
        return (indexOf(o) != -1);
    }

    public ListIterator<E> iterator() {
        return new ArrayListIterator();
    }
    public ListIterator<E> listIterator() {
        return new ArrayListIterator();
    }

    public boolean add(E e) {
        return add(size, e);
    }

    public boolean remove(Object o) {
        DoublyLinkedNode cur = head;
        if( o.equals(head.e) )
        {
            head = head.next;
            head.prev = null;
        }
        else {
            while (cur != null) {
                DoublyLinkedNode next = cur.next;

                if (o.equals(next.e)) {
                    if (next != null)
                        cur.next = next.next;
                    else
                        cur.next = null;

                    if( cur.next != null )
                        cur.next.prev = cur;

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
    }

    public E get(int index) {
        DoublyLinkedNode cur = head;
        int i = 0;
        while(cur != null) {
            if( i == index )
                return (E)cur.e;

            cur = cur.next;
            i++;
        }

        return null;
    }

    public E set(int index, E newVal) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();

        DoublyLinkedNode cur = head;
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

        DoublyLinkedNode node = new DoublyLinkedNode();
        node.e = e;
        node.next = null;
        node.prev = null;


        if( index == 0 )
        {
            node.next = head;

            if( head != null )
                head.prev = node;

            head = node;
            result = true;
        }
        else {

            int i = 0;
            DoublyLinkedNode cur = head;
            while(cur != null)
            {
                if( i == index - 1 )
                {
                    node.next = cur.next;
                    node.prev = cur;
                    cur.next = node;

                    if( node.next != null )
                        node.next.prev = node;

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

    public E remove(int index) {
        DoublyLinkedNode cur = head;
        E old = null;
        if( index == 0 )
        {
            head = head.next;
            head.prev = null;
            old = (E)cur.e;
        }
        else {
            int i = 0;

            while (cur != null) {
                DoublyLinkedNode next = cur.next;

                if (i == index - 1) {
                    if (next != null)
                        cur.next = next.next;
                    else
                        cur.next = null;

                    if( cur.next != null )
                        cur.next.prev = cur;

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


    public int indexOf(Object o)
    {
        int result = -1;

        DoublyLinkedNode cur = head;
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

        DoublyLinkedNode cur = head;
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
        DoublyLinkedNode cur = head;
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


    private class ArrayListIterator implements ListIterator<E> {

        private DoublyLinkedNode current = head;

        public boolean hasNext() {
            if( current == null )
                return false;

            return current.next != null;
        }

        public E next() {
            if( current == null ) {
                return null;
            }

            E e = (E)current.e;
            current = current.next;
            return e;
        }

        public boolean hasPrevious() {
            if( current == null )
                return false;

            return current.prev != null;
        }

        public E previous() {
            if( current == null ) {
                DoublyLinkedNode cur = head;
                while(cur != null)
                {
                    current = cur;
                    cur = cur.next;
                }

                if( current == null )
                    return null;
                return (E)current.e;
            }

            current = current.prev;
            E e = (E)current.e;
            return e;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }
}