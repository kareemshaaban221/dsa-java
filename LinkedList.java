package dsa;

public class LinkedList<T> implements Stack<T>, Queue<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public ListNode<T> getLastNode() {
        return tail;
    }

    // there is a better way to do this using tail and head together
    public ListNode<T> getNodeAtIndexOf(int pos) {
        ListNode<T> ptr = head;
        int i = 0;
        while (ptr != null) {
            if (i++ == pos)   return ptr;
            ptr = ptr.getNext();
        }
        return ptr;
    }

    public T pop() {
        ListNode<T> toBeDeleted = head;
        if (head == null) return null;
        head = head.getNext();
        toBeDeleted.destroy();
        size--;
        return toBeDeleted == null ? null : toBeDeleted.getVal();
    }

    public T remove(int pos) throws IndexOutOfBoundsException {
        if (pos == 0)           return pop();
        if (pos == size - 1)    return dequeue();

        ListNode<T> pre = getNodeAtIndexOf(pos - 1);
        if (pre == null)
            throw new IndexOutOfBoundsException(pos);
        ListNode<T> target = pre.getNext();
        pre.setNext(target.getNext());
        target.destroy();
        size--;

        return target.getVal();
    }

    public boolean push(T val) {
        if (head == null)
            head = tail = new ListNode<T>(val);
        else
            head = new ListNode<T>(val, head);
        size++;
        return true;
    }

    public boolean insert(T val, int pos) throws IndexOutOfBoundsException {
        if (pos == 0)           return push(val);
        if (pos == size - 1)    return enqueue(val);

        ListNode<T> pre = getNodeAtIndexOf(pos - 1);
        if (pre == null)
            throw new IndexOutOfBoundsException(pos);
        pre.setNext(new ListNode<T>(val, pre.getNext()));
        size++;

        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(T val) {
        ListNode<T> toBeAdded = new ListNode<T>(val);
        if (head == null)
            head = tail = toBeAdded;
        else {
            tail.setNext(toBeAdded);
            tail = toBeAdded;
        }
        size++;
        return true;
    }

    public T dequeue() {
        ListNode<T> toBeDeleted = tail;
        tail = getNodeAtIndexOf(size - 2);
        if (tail == null)
            head = null;
        toBeDeleted.destroy();
        return toBeDeleted == null ? null : toBeDeleted.getVal();
    }

    public String toString() {
        ListNode<T> ptr = head;
        if (ptr == null)    return "{}";
        String res = "{\n";
        int i = 0;
        while (ptr.getNext() != null) {
            res += String.format("\t%d => %s,\n", i++, ptr.getVal());
            ptr = ptr.getNext();
        }
        res += String.format("\t%d => %s\n}", i++, ptr.getVal());
        return res;
    }

}
