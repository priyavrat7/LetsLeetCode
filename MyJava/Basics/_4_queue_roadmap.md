# Java Queue Implementations

**1. `LinkedList` as Queue** _(Most Common)_  
*Implements the Queue interface*  
*Good for general-purpose queue operations*  
**Methods:** `offer()`, `poll()`, `peek()`, `element()`, `remove()`

---

**2. `ArrayDeque` as Queue** _(Recommended)_  
*Best performance for queue operations*  
*More efficient than LinkedList*  
*Resizable array implementation*

---

**3. `PriorityQueue` (Heap-based)**  
*Elements are ordered by priority* _(min-heap by default)_  
*Great for scheduling tasks or finding min/max elements*  
*Supports custom comparators for complex objects*

---

**4. `LinkedBlockingQueue` (Thread-safe)**  
*Safe for concurrent access*  
*Useful in multi-threaded applications*  
*Part of `java.util.concurrent` package*

---

**5. Deque Operations (Double-ended Queue)**  
*Can add/remove from both ends*  
*Can be used as both queue (FIFO) and stack (LIFO)*

---

## 🟢 **Key Queue Methods**

- **Adding:** `offer()` _(preferred)_, `add()`
- **Removing:** `poll()` _(returns null if empty)_, `remove()` _(throws exception if empty)_
- **Viewing:** `peek()` _(returns null if empty)_, `element()` _(throws exception if empty)_
- **Checking:** `isEmpty()`, `size()`

---

## 🟡 **When to Use Which**

- **ArrayDeque:** _Best general-purpose queue (recommended)_
- **LinkedList:** _When you need frequent insertions/deletions in middle_
- **PriorityQueue:** _When you need elements in priority order_
- **LinkedBlockingQueue:** _For thread-safe operations_

---

> **You can now run this code to see all the different queue implementations in action!**  
> The examples show practical usage patterns and demonstrate the differences between each type.
