public interface Queue<T> {
    Queue<T> enQueue(T t);

    /**
     *
     * @return the new queue after removing the element from the beginning of the queue
     */
    public Queue<T> deQueue() throws Exception;

    /**
     *
     * @return the head element of the queue
     * @throws Exception when queue is empty
     */
    public T head() throws Exception;

    /**
     *
     * @return true when queue is empty, false otherwise
     */
    public boolean isEmpty();
}
