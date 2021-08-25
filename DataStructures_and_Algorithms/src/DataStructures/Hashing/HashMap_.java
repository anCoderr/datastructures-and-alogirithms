package DataStructures.Hashing;

import java.util.LinkedList;
import java.util.Map;

class MapObject {
    int key, val;
    public MapObject(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class HashMap_ extends HashFunction{
    static class Runner {
        public static void main(String[] args) {
            HashMap_ hashMap = new HashMap_(20, 5);
            hashMap.insert(14, 14);
            hashMap.insert(2, 2);
            hashMap.insert(3, 3);
            hashMap.insert(15, 15);
            hashMap.insert(17, 17);
            hashMap.insert(7, 7);
            hashMap.insert(16, 16);
            hashMap.insert(13, 13);
            hashMap.insert(8, 8);
            hashMap.insert(1, 1);
            hashMap.insert(11, 11);
            hashMap.insert(0, 0);
            hashMap.insert(10, 10);
            hashMap.insert(12, 12);
            hashMap.insert(9, 9);
            hashMap.insert(19, 19);
            hashMap.insert(4, 4);
            hashMap.insert(6, 6);
            hashMap.insert(5, 5);
            hashMap.insert(18, 18);
            System.out.println(hashMap.contains(12, 12));
            System.out.println(hashMap.contains(14, 12));
            System.out.println(hashMap.containsKey(18));
            hashMap.deleteKey(18);
            System.out.println(hashMap.containsKey(18));
            System.out.println(hashMap.containsVal(9));
            hashMap.deleteVal(9);
            System.out.println(hashMap.containsVal(9));
            System.out.println(hashMap.containsVal(21));
            hashMap.printMap();
            hashMap.printMapCompact();
        }
    }
    LinkedList<MapObject>[] buckets;
    int maxSize, hSize;
    public HashMap_ (int maxSize, int hSize) {
        this.hSize = hSize;
        this.maxSize = maxSize;
        buckets = new LinkedList[maxSize];
        for(int i = 0; i<maxSize; i++)
            buckets[i] = new LinkedList<>();
    }

    public void insert(int key, int val) {
        int hash = hashFunction(key, hSize);
        if(searchKeyAt(key, hash))
            return;
        buckets[hash].add(new MapObject(key, val));
    }

    public boolean contains(int key, int val) {
        return searchAt(key, val, hashFunction(key, hSize));
    }
    public boolean searchAt(int key, int val, int hash) {
        for(MapObject mapObject : buckets[hash])
            if(mapObject.key == key && mapObject.val == val)
                return true;
        return false;
    }

    public boolean containsKey(int key) {
        return searchKeyAt(key, hashFunction(key, hSize));
    }
    public boolean searchKeyAt(int val, int hash) {
        for(MapObject mapObject : buckets[hash])
            if(mapObject.val == val)
                return true;
        return false;
    }

    public boolean containsVal(int val) {
        return searchValAt(val, hashFunction(val, hSize));
    }
    public boolean searchValAt(int key, int hash) {
        for(MapObject mapObject : buckets[hash])
            if(mapObject.key == key)
                return true;
        return false;
    }

    public boolean deleteVal(int val) {
        int hash = hashFunction(val, hSize);
        if(!searchValAt(val, hash))
            return false;
        buckets[hash].removeIf(mapObject -> mapObject.val == val);
        return true;
    }

    public boolean deleteKey(int key) {
        int hash = hashFunction(key, hSize);
        if(!searchValAt(key, hash))
            return false;
        buckets[hash].removeIf(mapObject -> mapObject.key == key);
        return true;
    }

    public void printMap() {
        for(int i = 0; i<maxSize; i++) {
            System.out.print("For hash " + i + " : -->");
            for(MapObject mapObject : buckets[i])
                System.out.print("[" + mapObject.key + "," + mapObject.val + "] -> ");
            System.out.print("null\n");
        }
    }
    public void printMapCompact() {
        for(int i = 0; i<maxSize; i++) {
            if(buckets[i].size() != 0)
                System.out.print("For hash " + i + " : -->");
            for(MapObject mapObject : buckets[i])
                System.out.print("[" + mapObject.key + "," + mapObject.val + "] -> ");
            if(buckets[i].size() != 0)
                System.out.print("null\n");
        }
    }
}