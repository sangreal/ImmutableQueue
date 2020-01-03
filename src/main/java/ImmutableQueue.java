public class ImmutableQueue<T> implements Queue<T> {
    final Stack<T> enqueueStack;
    final Stack<T> dequeueStack;

    public ImmutableQueue(Stack<T> es, Stack<T> ds) {
        enqueueStack = es;
        dequeueStack = ds;
    }

    @Override
    public Queue<T> enQueue(T t) {
        return new ImmutableQueue<T>(dequeueStack, enqueueStack.push(t));
    }

    @Override
    public Queue<T> deQueue() throws Exception {
       if (isEmpty()) {
           throw new Exception("This is a empty queue");
       }
       if (!dequeueStack.isEmpty()) {
           return new ImmutableQueue<T>(dequeueStack.pop(), enqueueStack);
       }
    }

    @Override
    public T head() throws Exception {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
