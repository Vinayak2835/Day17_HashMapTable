package hashmap;

public class LinkedList<K> {
    public MapNode head;
    public MapNode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(MapNode newNode) {
        if (head == null)
            head = newNode;

        if (tail == null)
            tail = newNode;
        else {
            MapNode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void append(MapNode newNode) {
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void insert(MapNode node, MapNode newNode) {
        MapNode tempNode = node.getNext();
        node.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public MapNode pop() {
        MapNode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public void popLast() {
        MapNode tempNode = this.head;
        while (!tempNode.getNext().equals(this.tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode.setNext(null);
    }

    public MapNode search(K key) {
        MapNode tempNode = this.head;
        while (tempNode != null ) {
            if (tempNode.getKey().equals(key))
                return tempNode;
            tempNode = tempNode.getNext();
        }
        return null;
    }

    public void insertAfterNode(MapNode insertNode, K key) {
        MapNode node = search(key);
        if(node != null) {
            insert(node, insertNode);
        } else
            System.out.println("No such node found");
    }

    public void searchDelete(K key) {
        MapNode node = search(key);
        MapNode tempNode = this.head;
        while (!tempNode.getNext().equals(node)) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(node.getNext());
        node.setNext(null);
    }

    public void size() {
        MapNode tempNode = head;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.getNext();
        }
        System.out.println(count);
    }

   @Override
   public String toString() {
        return "LinkedListNode{" + head + '}';
   }
}
