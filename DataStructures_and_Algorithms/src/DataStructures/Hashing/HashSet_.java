package DataStructures.Hashing;

import java.util.LinkedList;

public class HashSet_ extends HashFunction{
    static class Runner {
        public static void main(String[] args) {
            HashSet_ hashSet = new HashSet_(20, 5);
            hashSet.insert(10);
            hashSet.insert(12);
            hashSet.insert(7);
            hashSet.insert(16);
            hashSet.insert(9);
            hashSet.insert(19);
            hashSet.insert(4);
            hashSet.insert(11);
            hashSet.insert(0);
            hashSet.insert(6);
            hashSet.insert(1);
            hashSet.insert(5);
            hashSet.insert(18);
            hashSet.insert(14);
            hashSet.insert(2);
            hashSet.insert(3);
            hashSet.insert(17);
            hashSet.insert(13);
            hashSet.insert(8);
            hashSet.insert(15);
            System.out.println(hashSet.contains(12));
            System.out.println(hashSet.contains(14));
            hashSet.delete(14);
            System.out.println(hashSet.contains(14));
            hashSet.printSet();
            hashSet.printSetCompact();
        }
    }
    LinkedList<Integer>[] buckets;
    int maxSize, hSize;
    public HashSet_ (int maxSize, int hSize) {
        this.hSize = hSize;
        this.maxSize = maxSize;
        buckets = new LinkedList[maxSize];
        for(int i = 0; i<maxSize; i++)
            buckets[i] = new LinkedList<>();
    }

    public void insert(int val) {
        int hash = hashFunction(val, hSize);
        if(searchAt(val, hash))
            return;
        buckets[hash].add(val);
    }

    public boolean contains(int val) {
        int hash = hashFunction(val, hSize);
        return searchAt(val, hash);
    }
    public boolean searchAt(int target, int hash) {
        for(Integer i : buckets[hash])
            if(i == target)
                return true;
        return false;
    }

    public boolean delete(int val) {
        int hash = hashFunction(val, hSize);
        if(!searchAt(val, hash))
            return false;
        buckets[hash].remove((Integer)val);
        return true;
    }

    public void printSet() {
        for(int i = 0; i<maxSize; i++) {
            System.out.print("For hash " + i + " : --> ");
            for(int j : buckets[i])
                System.out.print(j + " -> ");
            System.out.print("null\n");
        }
    }
    public void printSetCompact() {
        for(int i = 0; i<maxSize; i++) {
            if(buckets[i].size() != 0)
                System.out.print("For hash " + i + " : --> ");
            for(int j : buckets[i])
                System.out.print(j + " -> ");
            if(buckets[i].size() != 0)
                System.out.print("null\n");
        }
    }
}
