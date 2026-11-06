# Hash Table & Binary Search Tree in Java

Custom implementations of two fundamental data structures,
written from scratch without using Java collections.

## Data structures
- **MyHashTable** – generic hash table with key-value pairs using separate
  chaining (a linked list in each bucket)
  - operations: `put`, `get`, `remove`, `contains`, `getKey`, `size`
  - updates the value if the key already exists
  - configurable number of buckets (default 11)
  - bucket index: `(hashCode & 0x7fffffff) % M` (always non-negative)
- **BST** – generic binary search tree with key-value pairs
  and an iterator for in-order traversal (keys in sorted order)

## Testing
- `MyTestingClass` – custom key class (id + name) with its own `hashCode()`
- Hash table test: 10,000 keys are inserted into a table with 101 buckets,
  then the size of each bucket is printed to check how evenly
  the hash function distributes elements
- BST test: several keys are inserted and printed with in-order traversal
- `TestHashTable` – additional tests for the hash table

## Tech stack
Java · Generics · Iterator · IntelliJ IDEA

## How to run
Open the project in IntelliJ IDEA and run `src/Main.java`.

## Author
Duisengaliyeva Adel, Astana IT University (ST-2502)
