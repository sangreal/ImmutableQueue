import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImmutableQueueTest {

    @Test
    void testMultipleInsert() throws Exception {
        int num = 10;
        Queue<Integer> q = new ImmutableQueue.EmptyQueue<>();
        for (int i = 0; i < num; i++) {
            q = q.enQueue(i);
        }

        q = q.enQueue(null);
        for (int i = 0; i < num; i++) {
            q = q.deQueue();
            int elem = q.head();
            assertEquals(i, elem);
        }

    }

    @Test
    void testInsertNull() throws Exception {
        int num = 10;
        Queue<Integer> q = new ImmutableQueue.EmptyQueue<>();
        for (int i = 0; i < num; i++) {
            q = q.enQueue(null);
        }
        Queue<Integer> nq = q.deQueue();
        Exception exception = assertThrows(NullPointerException.class, () -> {
            int e = nq.head();
        });

    }
}
