package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        this.fillCount = 0;
        first = 0;
        last = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * create a iterator
     * @return Iterator<T>
     */
    @Override
    public Iterator<T> iterator() {
        return new DataIterator();
    }

    private class DataIterator implements Iterator<T>
    {
        int ptr;
        int time;
        public DataIterator()
        {
            ptr = first;
            time = 0;
        }

        @Override
        public boolean hasNext()
        {
            if(time < fillCount) return true;
            else return false;
        }

        @Override
        public T next()
        {
            T res = rb[ptr];
            if(ptr == capacity - 1) ptr = 0;
            else ptr ++;
            time ++;
            return res;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
       if(isFull()) throw new RuntimeException("Ring buffer overflow");
       rb[last] = x;
       fillCount ++;
       last = (last + 1 == capacity ? 0 : last + 1);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if(isEmpty()) throw new RuntimeException("Ring buffer underflow");
        T res = rb[first];
        rb[first] = null;
        fillCount --;
        first = (first + 1 == capacity ? 0 : first + 1);
        return res;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if(isEmpty()) throw new RuntimeException("Ring buffer underflow");
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
