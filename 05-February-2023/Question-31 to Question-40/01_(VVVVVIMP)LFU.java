class LFUCache {
    int capacity;
    int cursize;
    int minfreq;
    Map<Integer,Node> cache;
    Map<Integer,DoublyLinkedlist> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.cursize=0;
        this.minfreq=0;
        this.cache=new HashMap<>();
        this.frequencyMap=new HashMap<>();
    }
    
    public int get(int key) {
        Node node=cache.get(key);
        if(node==null){
            return -1;
        }
        updateNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            Node curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        }
        else {
            cursize++;
            if (cursize > capacity) {
                DoublyLinkedlist minFreqList = frequencyMap.get(minfreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                cursize--;
            }
            
            minfreq = 1;
            Node newNode = new Node(key, value);

            
            DoublyLinkedlist curList = frequencyMap.getOrDefault(1, new DoublyLinkedlist());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }


        public void updateNode(Node node){
        int curFreq = node.freq;
        DoublyLinkedlist curlist = frequencyMap.get(curFreq);
        curlist.removeNode(node);

        if(curFreq==minfreq && curlist.listsize==0){
            minfreq++;
        }
        node.freq++;

        DoublyLinkedlist newlist=frequencyMap.getOrDefault(node.freq, new DoublyLinkedlist());
        newlist.addNode(node);
        frequencyMap.put(node.freq,newlist);

    }
}


class Node{
    int key;
    int value;
    int freq;
    Node next;
    Node prev;

    Node(int key,int value){
        this.key=key;
        this.value=value;
        this.freq=1;
    }
}


class DoublyLinkedlist{
    int listsize;
    Node head;
    Node tail;
    DoublyLinkedlist(){
        this.listsize=0;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public void addNode(Node node){
        Node headnext=head.next;
        head.next=node;
        node.prev=head;
        node.next=headnext;
        headnext.prev=node;
        listsize++;
    }

    public void removeNode(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
        listsize--;
    }
}
