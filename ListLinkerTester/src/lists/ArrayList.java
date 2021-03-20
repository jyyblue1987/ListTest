package lists;

import java.util.*;

public class ArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private E[] items;

    public ArrayList() {
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
        int index = indexOf(o);
        return remove(index) != null;
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
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();

        return items[index];
    }

    public E set(int index, E newVal) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        E old = items[index];
        items[index] = newVal;
        return old;
    }

    public boolean add(int index, E e) {
        if( index > size )
            return false;

        if (items.length == size) ensureCapacity(size + 20);

        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = e;
        size++;

        return true;
    }

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

    public List<E> subList(int fromIndex, int toIndex)
    {
        List<E> sublist = new java.util.ArrayList<E>();
        for(int i = fromIndex; i < toIndex; i++)
        {
            sublist.add(items[i]);
        }

        return sublist;
    }

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

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) 
            return;

        E[] old = items;
        items = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            items[i] = old[i];
        }
    }
}