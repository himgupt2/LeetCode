/*
 Author: Himanshu Gupta, himgupt2@gmail.com
----
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

*/

class LRUCache {
    private int cap;
    private Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(this.cap);
        
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Integer value = this.map.get(key);
            this.map.remove(key);
            this.map.put(key,value);
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            this.map.remove(key);
        } else if (this.map.size() == this.cap) {
            Iterator<Integer> itr = this.map.keySet().iterator();
            itr.next();
            itr.remove();
        }
        this.map.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
