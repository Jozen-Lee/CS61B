public class ArrayDeque<T>
{
    /**
     *The items of the Array Deque
     */
    T[] items;

    /**
     * The size of the Array Deque
     */
    int size;

    /**
     * The index of the last item
     */
    int Index;

    /**
     * Creat an empty Array Deque
     */
    public ArrayDeque()
    {
        items = (T[]) new Object[8];
        Index = 0;
        size = 8;
    }

    /**
     * Resize the underlying array to the target capacity
     * @param capacity
     */
    public void resize(int capacity)
    {
        if(Index > capacity) Index = capacity - 1;
        size = capacity;
        T[] newItems = (T[]) new Object[capacity];
        System.arraycopy(items,0, newItems, 0, size());
        items = newItems;
    }

    /**
     * Add an item of type T to the back of the deque
     * @param item
     */
    public void add(T item)
    {
        if(Index == size) resize(size() * 2);
        items[Index] = item;
        Index ++;
    }

    /**
     * Remove and return the item at the back of the deque
     * If no such item exists, return null
     * @return <T>
     */
    public T remove()
    {
        if(Index == 0) return null;
        if(Index / items.length < 0.25) resize(size() / 2);
        T item = items[Index - 1];
        items[size - 1] = null;
        Index --;
        return  item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, return null.
     * Must not alter the deque!
     * @param index
     * @return  <T>
     */
    public T get(int index)
    {
        if(index >= size) return  null;
        else return items[index];
    }

    /**
     * Return the size of Array Deque.
     * @return size
     */
    public int size()
    {
        return size;
    }
}