import java.util.LinkedHashMap;
class LRUCache {
    HashMap<Integer, Integer> LRUCacheStorage = new LinkedHashMap<Integer, Integer>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(LRUCacheStorage.containsKey(key))
        {
            int value = LRUCacheStorage.remove(key);
            LRUCacheStorage.put(key, value);
            return value;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (LRUCacheStorage.size() >= capacity && !LRUCacheStorage.containsKey(key)) {
            for (Integer k : LRUCacheStorage.keySet()) {
                LRUCacheStorage.remove(k);
                break;
            }
        }
        if (LRUCacheStorage.size() < capacity || LRUCacheStorage.containsKey(key)) {
            if(LRUCacheStorage.containsKey(key))
            {
                int temp = LRUCacheStorage.remove(key);
            }
             LRUCacheStorage.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */