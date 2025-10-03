/*
 * Commonly used operations of ArrayDeque in Java (as both Queue/FIFO and Stack/LIFO):
 *
 * 1. Creating a Queue:
 *    Queue<Integer> queue = new ArrayDeque<>();
 *
 * 2. Enqueue (add to tail/end):
 *    queue.add(10);
 *    queue.offer(20); // offer() is similar to add(), but returns false if it fails
 *
 * 3. Dequeue (remove from head/front):
 *    queue.remove(); // removes and returns the head, throws exception if empty
 *    queue.poll();   // removes and returns the head, returns null if empty
 *
 * 4. Peek at front:
 *    queue.element(); // retrieves, but does not remove, the head, throws exception if empty
 *    queue.peek();    // retrieves, but does not remove, the head, returns null if empty
 *
 * As a Stack (LIFO):
 * 1. Creating a Stack:
 *    ArrayDeque<Integer> stack = new ArrayDeque<>();
 *
 * 2. Push (add to top/front):
 *    stack.push(10);      // same as addFirst(10)
 *    stack.addFirst(20);
 *
 * 3. Pop (remove from top/front):
 *    stack.pop();         // same as removeFirst()
 *    stack.removeFirst();
 *
 * 4. Peek at top:
 *    stack.peek();        // same as peekFirst()
 *    stack.peekFirst();
 *
 * Common for both:
 * - Add to end: addLast(value)
 * - Remove from end: removeLast()
 * 
 * - Peek at end: peekLast()
 * - Check if empty: deque.isEmpty();
 * - Get size: deque.size();
 * - Clear: deque.clear();
 * - Iterate:
 *     for (Integer item : deque) {
 *         System.out.println(item);
 *     }
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class _4_1_queue_by_ArrayDeque {

    static void printQueue(Queue<Integer> queue){
        for(Integer item : queue){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        // Difference: 'ArrayDeque<Integer> queue' allows access to all ArrayDeque-specific methods (like addFirst, addLast), as it can use both stack(LIFO) and queue(FIFO) operations.
        // while 'Queue<Integer> queue1' restricts usage to only Queue interface methods (like add, remove, peek).
        ArrayDeque<Integer> dequeue = new ArrayDeque<>();

        Queue<Integer> queue = new ArrayDeque<>();


        queue.add(10); queue.add(20); queue.add(30); // Queue is [10, 20, 30], where 10 is the front(oldest) element
        System.out.println("Queue size: " + queue.size());
        printQueue(queue);

        dequeue.add(10); dequeue.add(20); dequeue.add(30);

        dequeue.addFirst(40); // 40, 10, 20, 30
        dequeue.addLast(50); // 40, 10, 20, 30, 50

        System.out.println("Dequeue size: " + dequeue.size());
        printQueue(dequeue);


        dequeue.removeFirst(); // 10, 20, 30, 50
        dequeue.removeLast(); // 10, 20, 30
        printQueue(dequeue);

    }
}
/*
 * Stack with Deque → use front only

addFirst(x) = push(x)

removeFirst() = pop()

Stack ==> addFirst, removeFirst(FrontStack) or addLast, removeLast (BackStack)


Queue with Deque → use back for add, front for remove

addLast(x) = enqueue(x)

removeFirst() = dequeue()

Queue ==> addLast, removeFirst(FrontQueue) or addFirst, removeLast (BackQueue)
 */

/*
 * ArrayDeque is NOT a doubly linked list.
 * 
 * ArrayDeque is a resizable array implementation of the Deque interface, which stands for double-ended queue. It allows elements to be added or removed from both ends efficiently. It can be used as a stack (LIFO) or a queue (FIFO)
 * 
 * Resizable-array implementation of the Deque interface. Array deques have no capacity restrictions; they grow as necessary to support usage. They are not thread-safe; in the absence of external synchronization, they do not support concurrent access by multiple threads. Null elements are prohibited. This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
 * 
 * ArrayDeque is implemented using a resizable circular array, not linked nodes.
 * - All elements are stored in a backing array.
 * - It provides O(1) time for adding/removing elements at both ends (front and back).
 * - It does NOT support random access by index (like ArrayList), but is much faster than LinkedList for queue/deque operations.
 * - It does NOT allow null elements.
 * 
 * In contrast, LinkedList is a doubly linked list:
 * - Each element is a node with pointers to the previous and next nodes.
 * - Uses more memory per element due to node objects and pointers.
 * - Allows null elements.
 * 
 * Summary: ArrayDeque is array-based (circular buffer), not a doubly linked list.
 
 * When to prefer ArrayDeque:
 * - When you need a queue or double-ended queue (deque) with fast O(1) insertion and removal at both ends.
 * - When you do not need thread safety (ArrayDeque is not synchronized).
 * - When you want better performance than LinkedList for queue/deque operations (ArrayDeque is generally faster and uses less memory).
 * - When you do not need to access elements by index (random access).
 * - When you want to avoid the overhead of node objects (as in LinkedList).
 *
 * When NOT to use ArrayDeque:
 * - When you need thread safety (use ConcurrentLinkedQueue or other concurrent collections).
 * - When you need to access elements by index (use ArrayList instead).
 * - When you need to store null elements (ArrayDeque does not allow nulls).
 * - When you need a queue with capacity restrictions (use ArrayBlockingQueue or LinkedBlockingQueue).
 * - When you need a priority queue (use PriorityQueue).
 * - When you need to frequently insert or remove elements in the middle of the collection (use LinkedList).
 */





