/*
 * LinkedBlockingQueue - Thread-Safe Queue Implementation
 * 
 * Key Features:
 * 1. Thread-safe: Multiple threads can safely access it simultaneously
 * 2. Blocking operations: Threads wait when queue is empty (take()) or full (put())
 * 3. Bounded or unbounded: Can have capacity limit or grow indefinitely
 * 4. FIFO ordering: First-in, first-out like regular queues
 * 5. Part of java.util.concurrent package
 * 
 * When to Use:
 * - Producer-Consumer scenarios
 * - Multi-threaded applications
 * - Task queues in thread pools
 * - Communication between threads
 * 
 * Performance:
 * - Slightly slower than non-thread-safe queues due to synchronization
 * - Uses locks internally for thread safety
 * - Better than synchronized collections for concurrent access
 */



import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;



public class _4_linkedblocking_queue_threadsafe {
    
    public static void main(String[] args) {
        System.out.println("=== LinkedBlockingQueue Demo ===\n");
        
        // 1. Basic operations
        basicOperationsDemo();
        
        // 2. Producer-Consumer pattern
        producerConsumerDemo();
        
        // 3. Bounded vs Unbounded
        boundedQueueDemo();
        
        // 4. Timeout operations
        timeoutOperationsDemo();
    }
    
    // 1. Basic thread-safe operations
    public static void basicOperationsDemo() {
        System.out.println("1. Basic LinkedBlockingQueue Operations:");
        
        // Create unbounded queue
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        
        try {
            // Adding elements (non-blocking)
            queue.offer("Task 1");
            queue.offer("Task 2");
            queue.offer("Task 3");
            
            System.out.println("Queue: " + queue);
            System.out.println("Size: " + queue.size());
            
            // Removing elements (non-blocking)
            System.out.println("Poll: " + queue.poll());
            System.out.println("Take: " + queue.take()); // blocks if empty
            
            System.out.println("Remaining: " + queue);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }
    
    // 2. Producer-Consumer Pattern (Most Common Use Case)
    public static void producerConsumerDemo() {
        System.out.println("2. Producer-Consumer Pattern:");
        
        LinkedBlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(5); // bounded
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    sharedQueue.put(i); // blocks if queue is full
                    System.out.println("Produced: " + i + " | Queue size: " + sharedQueue.size());
                    Thread.sleep(100); // simulate work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int item = sharedQueue.take(); // blocks if queue is empty
                    System.out.println("  Consumed: " + item + " | Queue size: " + sharedQueue.size());
                    Thread.sleep(200); // simulate processing time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Start both threads
        producer.start();
        consumer.start();
        
        try {
            producer.join(); // wait for producer to finish
            consumer.join(); // wait for consumer to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println();
    }
    
    // 3. Bounded vs Unbounded queues
    public static void boundedQueueDemo() {
        System.out.println("3. Bounded vs Unbounded Queues:");
        
        // Bounded queue (capacity = 3)
        LinkedBlockingQueue<String> boundedQueue = new LinkedBlockingQueue<>(3);
        
        // Unbounded queue (no capacity limit)
        LinkedBlockingQueue<String> unboundedQueue = new LinkedBlockingQueue<>();
        
        System.out.println("Bounded Queue Capacity: " + boundedQueue.remainingCapacity());
        
        // Fill bounded queue
        boundedQueue.offer("Item 1");
        boundedQueue.offer("Item 2");
        boundedQueue.offer("Item 3");
        
        System.out.println("After filling bounded queue:");
        System.out.println("  Size: " + boundedQueue.size());
        System.out.println("  Remaining capacity: " + boundedQueue.remainingCapacity());
        
        // Try to add one more (will fail with offer, would block with put)
        boolean added = boundedQueue.offer("Item 4");
        System.out.println("  Adding 4th item with offer(): " + added);
        
        // Unbounded queue can grow indefinitely
        for (int i = 1; i <= 1000; i++) {
            unboundedQueue.offer("Item " + i);
        }
        System.out.println("Unbounded queue size after 1000 items: " + unboundedQueue.size());
        System.out.println();
    }
    
    // 4. Timeout operations
    public static void timeoutOperationsDemo() {
        System.out.println("4. Timeout Operations:");
        
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        
        try {
            // Fill the queue
            queue.put("Item 1");
            queue.put("Item 2");
            
            System.out.println("Queue is full: " + queue);
            
            // Try to add with timeout (will fail after 1 second)
            boolean added = queue.offer("Item 3", 1, TimeUnit.SECONDS);
            System.out.println("Added with 1s timeout: " + added);
            
            // Remove an item to make space
            String removed = queue.poll();
            System.out.println("Removed: " + removed);
            
            // Now try to add with timeout (should succeed)
            added = queue.offer("Item 3", 1, TimeUnit.SECONDS);
            System.out.println("Added with 1s timeout after making space: " + added);
            
            System.out.println("Final queue: " + queue);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }
}

/*
 * Key Methods Comparison:
 * 
 * Adding Elements:
 * - offer(e): Non-blocking, returns false if can't add (bounded queue full)
 * - add(e): Same as offer(), throws exception if can't add
 * - put(e): BLOCKING, waits until space available
 * - offer(e, timeout, unit): Waits for specified time, then gives up
 * 
 * Removing Elements:
 * - poll(): Non-blocking, returns null if empty
 * - remove(): Same as poll(), throws exception if empty
 * - take(): BLOCKING, waits until element available
 * - poll(timeout, unit): Waits for specified time, then returns null
 * 
 * Viewing Elements:
 * - peek(): Returns head without removing, null if empty
 * - element(): Same as peek(), throws exception if empty
 * 
 * Thread Safety:
 * - All operations are atomic and thread-safe
 * - No need for external synchronization
 * - Uses internal locks for coordination
 * 
 * Real-World Use Cases:
 * 1. Web server request queues
 * 2. Database connection pools
 * 3. Image/video processing pipelines
 * 4. Email sending queues
 * 5. Log processing systems
 * 6. Task scheduling in thread pools
 * 
 * Advantages:
 * - Thread-safe without external synchronization
 * - Blocking operations prevent busy waiting
 * - Configurable capacity limits
 * - Better performance than synchronized collections
 * 
 * Disadvantages:
 * - Slower than non-thread-safe alternatives
 * - Can cause thread blocking (might lead to deadlocks if misused)
 * - Uses more memory due to internal synchronization structures
 */
