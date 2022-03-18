package DataStructures.Hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

public class Hashing extends  HashFunction {
    LinkedList<Objects>[] hashMap;
    int maxSize, bucket;
    Comparator<Objects> comparator;
    public Hashing(int maxSize, int bucket) {
        this.maxSize = maxSize;
        this.bucket = bucket;
        hashMap = new LinkedList[maxSize];
    }

}
