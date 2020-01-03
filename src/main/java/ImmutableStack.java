public class ImmutableStack<T> implements Stack<T> {
    private final T val;
    private final Stack<T> store;


    public ImmutableStack(T v, Stack<T> s) {
        val = v;
        store = s;
    }

    @Override
    public Stack<T> push(T t) {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public Stack<T> pop() {
        return this.store;
    }

    @Override
    public T head() {
        return val;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    public static class EmptyStack<T> implements Stack<T> {
        @Override
        public Stack<T> push(T t) {
            return new ImmutableStack<>(t, this);
        }

        @Override
        public Stack<T> pop() throws Exception {
            throw new Exception("This is a empty Stack");
        }

        @Override
        public T head() throws Exception {
            throw new Exception("This is a empty Stack");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }
}
