package dsa;

public interface Stack<T> {
    public T pop();
    public boolean push(T val);
    public int size();
    public boolean isEmpty();
}
