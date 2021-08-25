package DataStructures.Hashing;

import java.util.LinkedList;

public class HashMap_ extends HashFunction{
    static class Runner {
        public static void main(String[] args) {
            HashMap_ hashMap = new HashMap_(5);
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
            hashMap.insert(22, 22);
            hashMap.insert(20, 20);
            hashMap.insert(23, 23);
            hashMap.insert(25, 25);
            hashMap.insert(28, 28);
            hashMap.insert(24, 24);
            hashMap.insert(21, 21);
            hashMap.insert(26, 26);
            hashMap.insert(23, 23);
            hashMap.insert(27, 27);
            hashMap.insert(29, 29);
            hashMap.insert(30, 30);
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
    int hSize, size;

    public HashMap_ (int hSize) {
        this.hSize = hSize;
        size = 0;
        buckets = new LinkedList[hSize];
        for(int i = 0; i<hSize; i++)
            buckets[i] = new LinkedList<>();
    }

    public void handleOverflow() {
        HashMap_ newHashMap = new HashMap_(2*hSize);
        for(int i = 0; i<hSize; i++) {
            for(MapObject mapObj : buckets[i])
                newHashMap.insert(mapObj.key, mapObj.val);
        }
        buckets = newHashMap.buckets;
        hSize *= 2;
    }

    public void insert(int key, int val) {
        size++;
        if(size >= 5*hSize)
            handleOverflow();
        int hash = hashFunction(key, hSize);
        if(searchKeyAt(key, hash))
            return;
        buckets[hash].add(new MapObject(key, val));
    }

    public boolean contains(int key, int val) {
        return searchAt(key, val, hashFunction(key, hSize));
    }
    public boolean searchAt(int key, int val, int hash) {
        for(MapObject mapObj : buckets[hash])
            if(mapObj.key == key && mapObj.val == val)
                return true;
        return false;
    }

    public boolean containsKey(int key) {
        return searchKeyAt(key, hashFunction(key, hSize));
    }
    public boolean searchKeyAt(int val, int hash) {
        for(MapObject mapObj : buckets[hash])
            if(mapObj.val == val)
                return true;
        return false;
    }

    public boolean containsVal(int val) {
        return searchValAt(val, hashFunction(val, hSize));
    }
    public boolean searchValAt(int key, int hash) {
        for(MapObject mapObj : buckets[hash])
            if(mapObj.key == key)
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
        for(int i = 0; i<hSize; i++) {
            System.out.print("For hash " + i + " : -->");
            for(MapObject mapObj : buckets[i])
                System.out.print("[" + mapObj.key + "," + mapObj.val + "] -> ");
            System.out.print("null\n");
        }
    }
    public void printMapCompact() {
        for(int i = 0; i<hSize; i++) {
            if(buckets[i].size() != 0)
                System.out.print("For hash " + i + " : -->");
            for(MapObject mapObj : buckets[i])
                System.out.print("[" + mapObj.key + "," + mapObj.val + "] -> ");
            if(buckets[i].size() != 0)
                System.out.print("null\n");
        }
    }
}