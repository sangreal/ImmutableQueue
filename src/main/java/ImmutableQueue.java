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
       } else if (enqueueStack.isEmpty()) {
           return new EmptyQueue<>();
       } else {
           return new ImmutableQueue<>(reverseStack(enqueueStack), new ImmutableStack.EmptyStack<>());
       }
    }

    @Override
    public T head() throws Exception {
        if (dequeueStack.isEmpty()) {
            throw new Exception("This is a empty queue");
        }
        return dequeueStack.head();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    private Stack<T> reverseStack(Stack<T> stack) throws Exception {
        Stack<T> resStack = new ImmutableStack.EmptyStack<>();
        while (!stack.isEmpty()) {
            resStack.push(stack.head());
            stack = stack.pop();
        }
        return resStack;
    }


    public static class EmptyQueue<T> implements Queue<T> {
        @Override
        public Queue<T> enQueue(T t) {
            return new ImmutableQueue<T>(new ImmutableStack.EmptyStack<>(), new ImmutableStack<>(t, new ImmutableStack.EmptyStack<>()));
        }

        @Override
        public Queue<T> deQueue() throws Exception {
            throw new Exception("This is a empty queue");
        }

        @Override
        public T head() throws Exception {
            throw new Exception("This is a empty queue");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
