public interface Stack<T> {
    Stack<T> push(T t);

    Stack<T> pop() throws Exception;

    T head() throws Exception;

    boolean isEmpty();
}
