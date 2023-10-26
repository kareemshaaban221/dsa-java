package dsa;

public interface Queue<T> {
    public boolean enqueue(T val);
    public T dequeue();
    public int size();
    public boolean isEmpty();
}
