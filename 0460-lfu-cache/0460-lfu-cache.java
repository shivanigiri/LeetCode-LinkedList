class LFUCache {
    int capacity,minf;
    Map<Integer,Pair<Integer, Integer>> cache;
    Map<Integer,LinkedHashSet<Integer>> freqMap;

    private void insert(int key, int freq, int value){
        cache.put(key, new Pair<>(freq,value));
        freqMap.putIfAbsent(freq, new LinkedHashSet<>());
        freqMap.get(freq).add(key);
    }

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        minf = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Pair<Integer, Integer> freqVal= cache.get(key);
        if(freqVal == null){
            return -1;
        }
        final int freq=freqVal.getKey();
        final Set<Integer> keys =freqMap.get(freq);
        keys.remove(key);

        if(keys.isEmpty()){
            freqMap.remove(freq);

            if(minf==freq){
                minf+=1;
            }
        }
        final int value = freqVal.getValue();
        insert(key, (freq + 1),value );   
        return value;
    }
    
    public void put(int key, int value) {
        if(capacity<=0){
            return;
        }
        Pair<Integer, Integer> freqVal= cache.get(key);
        if(freqVal != null){
            cache.put(key, new Pair<>(freqVal.getKey(),value));
            get(key); //to increment freq and order in hashset
            return;
        }
         if (capacity == cache.size()) {
            final Set<Integer> keys = freqMap.get(minf); //get set of least freq visit
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if(keys.isEmpty())  {
                freqMap.remove(minf);
            }
         }
        //reset minf freq as 1 since adding new so first time used
        minf=1;
        insert(key,1,value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */