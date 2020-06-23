package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>
{
    int capacity(); //return size of buffer
    int fillCount(); // return number of items currently in the buffer
    void enqueue(T x); // add item x to the deque
    T dequeue(); // delete and return the item from the front
    T peek(); // return(but not delete) the item from the front

    default boolean isEmpty()
    {
        return (fillCount() == 0);
    }
    default boolean isFull()
    {
        return (capacity() == fillCount());
    }
}
