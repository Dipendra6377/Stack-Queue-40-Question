// Brute force approach

class LRUCache {
    int capacity;
    Queue<Integer> q=new ArrayDeque<>();
    HashMap<Integer,Integer> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            q.remove(key);
            q.offer(key);
            return map.get(key);
        }
        else
            return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            q.remove(key);
            q.offer(key);
            map.put(key,value);
        }
        else{
            if(q.size()<capacity) q.offer(key);
            else{
                map.remove(q.poll());
                q.offer(key);
            }
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

////////////////////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;

public class LRU {
    static Node head=new Node(0,0);
    static Node tail=new Node(0,0);
    static Map<Integer,Node> map=new HashMap<>();
    static int capacity=3;
    public static void main(String[] args) {
        LRUcache(capacity);
        Node node =new Node(1,1);
        put(node.key,node.value);
        Node node1=new Node(2,2);
        put(node1.key,node1.value);
        Node node2=new Node(3,3);
        put(node2.key,node2.value);
        Node node3=new Node(4,4);
        put(node3.key,node3.value);
        System.out.println(get(1));


        //System.out.println(map);
    }
    
    /////////////////////////////////////////////////////////////
    // MAIN FUNCTION
    public static int get(int key){
        if(map.containsKey(key)){
            Node node =map.get(key);
            //System.out.println(map.get(key));
            remove(node);
            insert(node);
            return node.value;
        }
        else
            return -1;
    }
    public static void LRUcache(int _capacity){
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }
    public static void put(int key,int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    public static void remove(Node node){
        map.remove(node.key);
        //System.out.println(node);
        //System.out.println(node.key);
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public static void insert(Node node){
        map.put(node.key,node);
        Node headnext=head.next;
        head.next=node;
        node.prev=head;
        node.next=headnext;
        headnext.prev=node;
    }

}

class Node{
    Node prev,next;
    int key, value;
    Node (int _key,int _value){
        key=_key;
        value=_value;
    }
}
