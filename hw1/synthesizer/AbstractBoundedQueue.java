package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>
{
    protected int fillCount;
    protected int capacity;

    /**
     * return size of buffer
     * @return capacity
     */
    @Override
    public int capacity()
    {
        return capacity;
    }

    /**
     * return number of items currently in the buffer
     * @return fillCount
     */
    @Override
    public int fillCount()
    {
        return fillCount;
    }

    /**
     * delete and return the item from the front
     * @return T
     */
    @Override
    public abstract T dequeue();

    /**
     * return(but not delete) the item from the front
     * @return T
     */
    @Override
    public abstract T peek();

    /**
     * add item x to the deque
     * @param x
     */
    @Override
    public abstract void enqueue(T x);
}
