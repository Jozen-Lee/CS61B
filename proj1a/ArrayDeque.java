public class ArrayDeque<T>
{
    /**
     * the initial size
     */
    private final int INITIAL_SIZE = 8;
    /**
     *The items of the Array Deque
     */
    private T[] items;

    /**
     * The size of the Array Deque
     */
    private int size;

    /**
     * The first and last item of the deque
     */
    private int nextFirst;
    private int nextLast;

    /**
     * Creat an empty Array Deque
     */
    public ArrayDeque()
    {
        items = (T[]) new Object[INITIAL_SIZE];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private int minusOne(int index)
    {
        return Math.floorMod(index-1, items.length);
    }

    private int plusOne(int index)
    {
        return Math.floorMod(index+1, items.length);
    }

    private int plusOne(int index, int length) {
        return Math.floorMod(index+1, length);
    }

    /**
     * Resize the underlying array to the target capacity
     */
    private void resize()
    {
        if(size == items.length)
        {
            expand();
        }
        if(size < items.length / 4 && items.length > 8)
        {
            reduce();
        }
    }

    private void expand()
    {
        resizeHelper(items.length * 2);
    }

    private  void reduce()
    {
        resizeHelper(items.length / 2);
    }

    private  void resizeHelper(int capacity)
    {
        T[] temp = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for(int i = begin; i != end; i = plusOne(i, temp.length))
        {
            items[nextLast] = temp[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = temp[end];
        nextLast = plusOne(nextLast);
    }

    /**
     * Add an item of type T to the back of the deque
     * @param item
     */
    public void addLast(T item)
    {
        resize();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size ++;
    }

    /**
     * 返回items中最后一个元素
     * @return item[last]
     */
    private T getlast()
    {
        return items[minusOne(nextLast)];
    }

    /**
     * 删除并返回items中最后一个元素
     * @return items[last]
     */
    public T removeLast()
    {
        if(isEmpty()) return null;
        resize();
        T res = getlast();
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size --;
        return res;
    }

    /**
     * Add an item of type T to the front of the deque
     * @param item
     */
    public void addFirst(T item)
    {
        resize();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size ++;
    }

    /**
     * 返回items中第一个元素
     * @return item[first]
     */
    private T getFirst()
    {
        return items[plusOne(nextFirst)];
    }

    /**
     * 删除并返回items中第一个元素
     * @return item[first]
     */
    public T removeFirst()
    {
        if(isEmpty()) return null;
        resize();
        T res = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size --;
        return res;
    }

    /**
     * Check if the deque is empty.
     * @return bool
     */
    public boolean isEmpty()
    {
        return (size == 0 ? true : false);
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, return null.
     * Must not alter the deque!
     * @param index
     * @return  items[index] or null
     */
    public T get(int index)
    {
        if(index >= size || index < 0) return  null;
        else
        {
            index = Math.floorMod(plusOne(nextFirst) + index, items.length);
            return items[index];
        }
    }

    /**
     * 打印deque序列.
     */
    public void printDeque()
    {
        for(int index = plusOne(nextFirst); index != nextLast; index = plusOne(index))
        {
            System.out.println(items[index]);
            System.out.println(' ');
        }
        System.out.println('\n');
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

//public class ArrayDeque<T> {
//    private T[] items;
//    private int size;
//    private int nextFirst;
//    private int nextLast;
//    private final int INITIAL_CAPACITY = 8;
//
//    public ArrayDeque() {
//        items = (T[]) new Object[INITIAL_CAPACITY];
//        size = 0;
//        nextFirst = 0;
//        nextLast = 1;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return (size == 0 ? true : false);
//    }
//
//    public int minusOne(int index) {
//        return Math.floorMod(index-1, items.length);
//    }
//
//
//    public int plusOne(int index) {
//        return Math.floorMod(index+1, items.length);
//    }
//
//    public int plusOne(int index, int length) {
//        return Math.floorMod(index+1, length);
//    }
//
//    /**
//     *  invariants:
//     *      设计resize()方法，将在增加ArrayDeaue实例内存的方法中调用
//     *      内部判断内存满则调用expand()增加内存
//     *        如果内存过小则调用reduce()减小内存
//     **/
//
//    private void resize() {
//        if (size == items.length) {
//            expand();
//        }
//        if (size < items.length / 4 && items.length > 8) {
//            reduce();
//        }
//    }
//
//    private void expand() {
//        resizeHelper(items.length * 2);
//    }
//
//    private void reduce() {
//        resizeHelper(items.length / 2);
//    }
//
//    private void resizeHelper(int capacity) {
//        T[] temp = items;
//        int begin = plusOne(nextFirst);
//        int end = minusOne(nextLast);
//        items = (T[]) new Object[capacity];
//        nextFirst = 0;
//        nextLast = 1;
//        for (int i=begin; i != end; i = plusOne(i, temp.length)) {
//            items[nextLast] = temp[i];
//            nextLast = plusOne(nextLast);
//        }
//        items[nextLast] = temp[end];
//        nextLast = plusOne(nextLast);
//    }
//
//    /**
//     *  invariants:
//     *      通过minusOne()方法确定nextFirst，(nextFirst-1)%items.length
//     *      即nextFirst的下一个位置
//     *      eg. (0 - 1) % 8 = 7
//     *
//     * */
//    public void addFirst(T item) {
//        resize();
//        items[nextFirst] = item;
//        nextFirst = minusOne(nextFirst);
//        size++;
//    }
//
//    public T getFirst() {
//        return items[plusOne(nextFirst)];
//    }
//
//    public T removeFirst() {
//        resize();
//        T res = getFirst();
//        nextFirst = plusOne(nextFirst);
//        items[nextFirst] = null;
//        size--;
//        return res;
//    }
//
//    public void addLast(T item) {
//        resize();
//        items[nextLast] = item;
//        nextLast = plusOne(nextLast);
//        size++;
//    }
//
//    public T getLast() {
//        return items[minusOne(nextLast)];
//    }
//
//    public T removeLast() {
//        resize();
//        T res = getLast();
//        nextLast = minusOne(nextLast);
//        items[nextLast] = null;
//        size--;
//        return res;
//    }
//
//    public void printDeque() {
//        for (int index = plusOne(nextFirst); index != nextLast; index = plusOne(index)) {
//            System.out.print(items[index]);
//            System.out.print(" ");
//        }
//        System.out.println();
//    }
//
//    public T get(int index) {
//        if (index < 0 || index >= size) {
//            return null;
//        }
//        index = Math.floorMod(plusOne(nextFirst) + index, items.length);
//        return items[index];
//    }
//
//
//
//    /*
//    public static void main(String[] args) {
//        ArrayDeque<Integer> aq = new ArrayDeque<Integer>();
//        for (int i = 0; i < 100; i++) {
//            aq.addLast(i);
//        }
//        aq.printDeque();
//        for (int i = 0; i < 98; i++) {
//            aq.removeFirst();
//        }
//        aq.printDeque();
//        System.out.println(aq.get(0));
//    }
//    */
//}