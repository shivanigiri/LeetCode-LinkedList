class LRUCache {
    HashMap<Integer, ListNode> map;
    ListNode head,tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new ListNode(-1,-1);
        tail=new ListNode(-1,-1);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
           return -1;
        }
        ListNode node=map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
         if(map.containsKey(key)){
            ListNode oldNode=map.get(key);
            remove(oldNode);
        }
        ListNode node=new ListNode(key, value);
        map.put(key,node);
        add(node);
        if(map.size()>capacity){
            ListNode delNode=head.next;
            map.remove(delNode.key);
            remove(delNode);
            }
    }
        public void remove(ListNode node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        public void add(ListNode node){
            ListNode prev=tail.prev;
            prev.next=node;
            node.prev=prev;
            node.next=tail;
            tail.prev=node;
            // node.next=tail.prev.next;
            // node.prev=tail.prev;
            // tail.prev.next=node;
            // tail.prev=node;
        }
        
}
public class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key){
        this.key=key;
    }
    public ListNode(int key, int val){
        this.key=key;
        this.val=val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 /* Using build in method. we will be using LinkedHashMap, which is a hash map that maintains insertion order. It essentially implements the linked list for us in the same data structure as the hash map, with the add and remove methods built into the hash map operations.
 
 class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> dic;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new LinkedHashMap<>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return dic.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        dic.put(key, value);
    }

}
 */