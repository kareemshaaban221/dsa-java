package dsa;

public class ListNode<T> {
    private T val;
    private ListNode<T> next;

    public ListNode(T val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public boolean setVal(T val) {
        this.val = val;
        return true;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public boolean setNext(ListNode<T> next) {
        this.next = next;
        return true;
    }

    public boolean destroy() {
        this.next = null;
        return true;
    }
}
