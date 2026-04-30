public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        int i = hash(key);
        HashNode<K, V> current = chainArray[i];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[i];
        chainArray[i] = newNode;
        size++;
    }

    public V get(K key) {
        int i = hash(key);
        HashNode<K, V> current = chainArray[i];

        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int i = hash(key);
        HashNode<K, V> current = chainArray[i];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) chainArray[i] = current.next;
                else prev.next = current.next;
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) return true;
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) return current.key;
                current = current.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int getM() {
        return M;
    }

    public int getBucketSize(int index) {
        int count = 0;
        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}