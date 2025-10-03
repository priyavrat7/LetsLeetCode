/*
 * Queue as LinkedList is most commonly used in Java.
 * It is a doubly linked list, so it is efficient for adding/removing elements at both ends (O(1)).
 * However, it is NOT efficient for random access (getting or setting an element at a specific index), which is O(n).
 * Compared to ArrayDeque, LinkedList uses more memory due to storing extra pointers for each node.
 * For queue operations (add/remove from ends), LinkedList and ArrayDeque are similar in efficiency.
 * For iteration and cache locality, ArrayDeque is usually faster than LinkedList.
 * LinkedList is less efficient than ArrayList for indexed access and less efficient than HashSet/HashMap for lookups.
 * Use LinkedList as a queue when you need frequent insertions/removals at both ends, but not for random access or high-performance iteration.
 */

import java.util.LinkedList;
import java.util.Queue;
public class _4_queue_by_linkedList {
    public static void main(String[] args){
        // We cast LinkedList to Queue<Integer> to use only queue operations and follow the Queue interface, not LinkedList-specific methods.
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Queue size: " + queue.size());

        queue.add(10); queue.add(20); queue.add(30); // Queue is [10, 20, 30], where 10 is the front(oldest) element

        System.out.println("Removed element: " + queue.remove());
        System.out.println("Latest element: " + queue.element()); // 20

        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}
// Commonly used operations of Queue using LinkedList in Java:
//
// 1. Creating a Queue:
//    Queue<Integer> queue = new LinkedList<>();
//
// 2. Adding elements to the queue (enqueue):
//    queue.add(10);
//    queue.offer(20); // offer() is similar to add(), but returns false if it fails
//
// 3. Removing elements from the queue (dequeue):
//    queue.remove(); // removes and returns the head of the queue, throws exception if empty
//    queue.poll();   // removes and returns the head, returns null if empty
//
// 4. Accessing the front element (peek):
//    queue.element(); // retrieves, but does not remove, the head, throws exception if empty
//    queue.peek();    // retrieves, but does not remove, the head, returns null if empty
//
// 5. Checking if the queue is empty:
//    queue.isEmpty();
//
// 6. Getting the size of the queue:
//    queue.size();
//
// 7. Clearing the queue:
//    queue.clear();
//
// 8. Iterating through the queue:
//    for(Integer item : queue) {
//        System.out.println(item);
//    }
