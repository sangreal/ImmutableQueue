public class ImmutableQueue<T> implements Queue<T> {
    final Stack<T> enqueueStack;
    final Stack<T> dequeueStack;

    public ImmutableQueue(Stack<T> ds, Stack<T> es) {
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
           throw new Exception(Constants.EMPTY_QUEUE_ERR);
       }
       if (!dequeueStack.isEmpty()) {
           return new ImmutableQueue<T>(dequeueStack.pop(), enqueueStack);
       } else if (!enqueueStack.isEmpty()) {
           return new ImmutableQueue<>(reverseStack(enqueueStack), new ImmutableStack.EmptyStack<>());
       } else {
           return new EmptyQueue<>();
       }
    }

    @Override
    public T head() throws Exception {
        if (dequeueStack.isEmpty()) {
            throw new Exception(Constants.EMPTY_QUEUE_ERR);
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
            resStack = resStack.push(stack.head());
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
            throw new Exception(Constants.EMPTY_QUEUE_ERR);
        }

        @Override
        public T head() throws Exception {
            throw new Exception(Constants.EMPTY_QUEUE_ERR);
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
