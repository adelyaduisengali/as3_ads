public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(101);

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(i, "name" + (i % 1000));
            table.put(key, i);
        }

        for (int i = 0; i < table.getM(); i++) {
            System.out.println("Bucket " + i + ": " + table.getBucketSize(i));
        }
    }
}