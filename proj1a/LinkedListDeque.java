
public class LinkedListDeque<T>
{
    public int size;
    private Node First;
    private Node Last;

    private class Node<T>
    {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node p, Node n)
        {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque()
    {
        size = 0;
        First = new Node(null,null,null);
        Last = new Node(null,null,null);
        First.next = Last;
        Last.prev = First;
    }

    public void addFirst(T item)
    {
        Node node = new Node(item, First, First.next);
        First.next = node;
        size ++;
    }

    public void addLast(T item)
    {
        Node node = new Node(item, Last.prev, Last);
        Last.prev = node;
        size ++;
    }

    public boolean isEmpty()
    {
        if(size == 0) return true;
        else return false;
    }

    public int size()
    {
        return size;
    }

    public void printDeque()
    {
        Node node = First.next;
        while (node != Last)
        {
            System.out.println(node.item);
            System.out.println(' ');
            node = node.next;
        }
        System.out.println('\n');
    }

    public T removeFirst()
    {
        if(isEmpty()) return null;
        else
        {
            Node node = First.next;
            First.next = node.next;
            First.next.prev = First;
            size --;
            return  (T) node.item;
        }
    }

    public T removeLast()
    {
        if(isEmpty()) return null;
        else
        {
            Node node = Last.prev;
            Last.prev = node.prev;
            Last.prev.next = Last;
            size --;
            return  (T) node.item;
        }
    }

    public T get(int index)
    {
        if(index > size()) return null;
        Node node = First.next;
        while (index != 0)
        {
            node = node.next;
            index --;
        }
        return (T) node.item;
    }

    private T getRecursiveHelper(Node node,int index)
    {
        if(index == 0) return(T) node.item;
        else return (T) getRecursiveHelper(node.next, (index-1));
    }

    public T getRecursive(int index)
    {
        if(index > size()) return null;
        else
        {
            Node node = First.next;
            return getRecursiveHelper(node, index);
        }
    }
}