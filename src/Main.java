public class Main {
    public static void main(String[] args) {

        // ===== HASH TABLE TEST =====
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(101);

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i, "name" + (i % 1000));
            table.put(key, i);
        }

        System.out.println("HashTable size: " + table.size());

        for (int i = 0; i < table.getM(); i++) {
            System.out.println("Bucket " + i + ": " + table.getBucketSize(i));
        }

        // ===== BST TEST =====
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "A");
        tree.put(3, "B");
        tree.put(7, "C");
        tree.put(1, "D");
        tree.put(4, "E");

        System.out.println("\nBST in-order traversal:");
        for (var elem : tree) {
            System.out.println("key = " + elem.getKey() +
                    ", value = " + elem.getValue());
        }
    }
}