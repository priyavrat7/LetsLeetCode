## 🟦 HashMap — buckets, collisions, and chaining

**Idea:** A HashMap is an array of buckets. Each bucket holds a reference to the head `Node`. New keys are placed using a hash → index mapping. When two keys map to the same index, a **collision** happens and entries in that bucket form a **chain** (linked list, or tree in modern JDKs under certain conditions).

---

### 🗂️ The internal table

- Internal array: `table[0], table[1], table[2], ... table[n-1]`
- Each `table[i]` is a bucket that stores either `null` or the head of a chain.

```text
Capacity = 4 buckets → array of 4 slots
table[0] → Node(key=5, value="Five", next=null)             🟢 no collision
table[1] → Node(key=6, value="Six", next=Node(21,"TwentyOne"))  🔴 collision
table[2] → null
table[3] → null
```

Legend: 🟢 no collision, 🔴 collision → chaining via `next`

---

### 🔍 What a bucket stores during collision

- `table[1]` stores the head node’s reference.
- Other nodes are linked through the `next` field (like a linked list).

---

### 🧩 Step-by-step example (default capacity 16)

```text
At creation:
Index: 0   1   2   3   4   5   6   7   ...  15
       |   |   |   |   |   |   |   |        |
Value: null null null null null null null null ... null
```

1) Put(5, "Five")
- Compute hash → index = 1
- `table[1]` is empty → store new Node there

```text
Index: 0   1                                2   3   4 ...
       |   |                                |   |   |
Value: null [Node(5,"Five")]                null null null ...
```

2) Put(8, "Eight")
- Compute hash → index = 3
- `table[3]` is empty → store new Node there

```text
Index: 0   1                     2   3                      4 ...
       |   |                     |   |                      |
Value: null [Node(5,"Five")]     null [Node(8,"Eight")]     null ...
```

3) Put(21, "TwentyOne")  🔴 Collision at index 1
- Suppose `hash(21)` → index = 1 (same as key 5)
- Collision! A linked list is created/extended in that bucket

```text
Index: 0   1                                               2   3
       |   |                                               |   |
Value: null [Node(5,"Five")] → [Node(21,"TwentyOne")]      null [Node(8,"Eight")]
```

---

### 🎯 How does `hashCode()` determine the table index in a HashMap?

Let's break it down visually:

1. **Every key** in Java has a `hashCode()` value (an integer, can be positive or negative).

2. **HashMap** uses this value to find the right bucket (index) in its internal array (`table`).

#### 🧮 The process (step by step):

Suppose we have a key `"cat"`:

1. **Get the hash code**  
   ```java
   int hash = "cat".hashCode(); // e.g., 99333
   ```
   (The actual value depends on the string.)

2. **Spread the hash (improves distribution)**  
   Java 8+ HashMap applies a "hash spread" to reduce collisions:
   ```java
   int spreadHash = hash ^ (hash >>> 16);
   ```

3. **Map to a valid index**  
   The table size is always a power of two (e.g., 16).  
   The index is calculated as:
   ```java
   int index = spreadHash & (table.length - 1);
   ```
   This ensures the index is always between 0 and (table.length - 1).

**Visual summary:**

---

### 🏗️ When does a HashMap resize?

- **Resizing** happens when the number of entries exceeds the *capacity × load factor* (default load factor is 0.75).
- For example, if the table size is 16, resizing happens after 12 entries (16 × 0.75 = 12).
- **What happens during resize?**
  - The internal array size doubles (e.g., from 16 to 32).
  - All existing entries are *rehashed* and redistributed into the new array.
  - This is a costly operation, so frequent resizing should be avoided by choosing an appropriate initial capacity.

---

### 🌳 When does HashMap use treeification (Red-Black Tree)?

- **Treeification** occurs when too many keys hash to the same bucket (i.e., a long linked list forms in a single bucket).
- In Java 8+, if a single bucket (that is, a single index in the table) contains a linked list with **more than 8 nodes** (`TREEIFY_THRESHOLD`), and the table size/capacity is at least 64 (`MIN_TREEIFY_CAPACITY`), that linked list is converted to a **red-black tree**.  
  - (This means: if more than 8 entries hash to the same bucket and are stored as a linked list, the structure is upgraded to a tree for faster lookups.)
- **Why?**  
  - Lookup time in a linked list is O(n), but in a red-black tree it's O(log n), improving worst-case performance.
- If the table is too small, instead of treeifying, the HashMap will resize to reduce collisions.

**Summary Table:**

| Condition                                 | Action                |
|--------------------------------------------|-----------------------|
| Entries > capacity × load factor           | Resize (double size)  |
| Bucket size > 8 and table size ≥ 64        | Treeify (red-black)   |
| Bucket size > 8 and table size < 64        | Resize (no treeify)   |

---

**What is "capacity" in HashMap? Is it the same as table size?**

- **Capacity** in a HashMap is exactly the same as the current size of the internal array (sometimes called the "table").  
  - So, *capacity = table size* (i.e., the number of buckets available for storing entries).
- The default initial capacity (table size) is **16**.
- Capacity (table size) is always a power of two (e.g., 16, 32, 64, ...).
- When you create a HashMap, you can specify the initial capacity:
  ```java
  HashMap<String, Integer> map = new HashMap<>(32); // capacity (table size) = 32
  ```
- As you add entries, if the number of elements exceeds `capacity × load factor`, the capacity (table size) is doubled (resize).

**Summary:**  
*Capacity* and *table size* mean the same thing in HashMap: the number of buckets available for storing entries. More capacity means fewer collisions (but uses more memory).


---

### ⏱️ Why is HashMap time complexity O(1) on average, but O(n) in the worst case?

#### **Average Case: O(1) Time Complexity**

- **Put (insert), get (lookup), and remove** operations in a HashMap are *on average* O(1) — constant time.
- This is because:
  - The key's `hashCode()` is computed, and the bucket index is found in O(1).
  - If the hash function distributes keys well, most buckets have at most one or a few entries.
  - So, finding the right bucket and traversing a very short list (or tree) is very fast.

#### **Worst Case: O(n) Time Complexity**

- In the *worst case*, all keys hash to the same bucket (i.e., a "bad" hash function or many hash collisions).
- Then, all entries are stored in a single linked list (or tree, in Java 8+).
- **If it's a linked list:**  
  - Lookup, insert, or delete may require scanning all n entries ⇒ O(n) time.
- **If it's a red-black tree (Java 8+):**  
  - Operations are O(log n) in that bucket, so worst-case is O(log n).
- But, *theoretically*, with a very poor hash function or a deliberate attack, O(n) is possible.

#### **Summary Table**

| Scenario                | Time Complexity |
|-------------------------|----------------|
| Average (good hash)     | O(1)           |
| Worst (all collide)     | O(n)           |
| Treeified bucket (Java8+)| O(log n)      |

#### **Key Points**

- **O(1) average**: Good hash function, low collisions, short chains.
- **O(n) worst**: All keys in one bucket (bad hash or attack).
- **Java 8+**: Treeification improves worst-case to O(log n) for large buckets.

**In practice:**  
HashMap is *very fast* (O(1)) for most workloads, but you should be aware of the theoretical worst case!




---

### 💡 Notes

- Good hash functions reduce collisions (spread keys uniformly).
- Load factor and resizing policy affect performance (typical default load factor = 0.75).
- In newer Java versions, very long chains may be treeified for better worst-case lookups.