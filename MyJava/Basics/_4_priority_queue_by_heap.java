import java.util.Collections;
import java.util.PriorityQueue;

public class _4_priority_queue_by_heap {

    static void printQueue(PriorityQueue<Integer> pq){
        /*
         * Note: Iterating over a PriorityQueue using a for-each loop
         * does NOT print the elements in sorted (priority) order.
         * The internal structure is a heap, so the iteration order is arbitrary.
         * To print elements in sorted order, you must repeatedly poll() the queue,
         * which will remove and return elements in priority order.
         */
        for(Integer item : pq){
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap by default
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        pq.add(10); pq.add(30); pq.add(40); pq.add(7);
        pq1.add(10); pq1.add(30); pq1.add(40); pq1.add(7);

        printQueue(pq);
        printQueue(pq1);

    }
}
/*
 * Commonly used operations of PriorityQueue in Java:
 *
 * 1. Creating a PriorityQueue (min-heap by default):
 *    PriorityQueue<Integer> pq = new PriorityQueue<>();
 *
 * 2. Creating a max-heap PriorityQueue:
 *    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
 *
 * 3. Adding elements:
 *    pq.add(10);
 *    pq.offer(20); // offer() is similar to add(), but returns false if it fails
 *
 * 4. Removing elements:
 *    pq.remove(); // removes and returns the head (smallest/largest), throws exception if empty
 *    pq.poll();   // removes and returns the head, returns null if empty
 *
 * 5. Accessing the head element (peek):
 *    pq.element(); // retrieves, but does not remove, the head, throws exception if empty
 *    pq.peek();    // retrieves, but does not remove, the head, returns null if empty
 *
 * 6. Checking if the queue is empty:
 *    pq.isEmpty();
 *
 * 7. Getting the size of the queue:
 *    pq.size();
 *
 * 8. Clearing the queue:
 *    pq.clear();
 *
 * 9. Iterating through the queue (order is not sorted!):
 *    for (Integer item : pq) {
 *        System.out.println(item);
 *    }
 *
 * Note:
 * - PriorityQueue does not allow null elements.
 * - The head of the queue is always the smallest (or largest, for max-heap) element according to the comparator.
 * - Iteration order is not guaranteed to be sorted.
 * - For custom objects, implement Comparable or provide a Comparator.
 */

