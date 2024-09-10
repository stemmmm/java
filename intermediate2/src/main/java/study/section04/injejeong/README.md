# 컬렉션 프레임워크 - LinkedList
## 배열 리스트의 단점
- 사용할 공간을 미리 할당해 놓기 때문에 그 공간을 사용하지 않으면 메모리가 낭비됨
- 앞이나 중간에 새로운 데이터를 추가할 시 새 데이터의 공간 마련을 위해 그 뒤의 데이터들을 한 칸씩 옆으로 밀어야 함
- 삭제할 시에는 왼쪽으로 당겨야 함
- 이 때 배열의 크기가 크면 클수록 더 많은 데이터를 이동해야 하므로 비효율적이며 성능이 떨어짐
## 연결 리스트(Linked List)
- 낭비되는 메모리 없이 필요한 만큼만 공간 할당
- 노드를 생성하고 각 노드 연결
```java
public class Node {
    Object item;    // 저장할 데이터
    Node next;      // 다음으로 연결할 노드의 참조

    public Node(Object item) {
        this.item = item;
    }
}
```
```java
public class NodeMain {
    public static void main(String[] args) {
        Node first = new Node("A");     // 노드 A 생성
        first.next = new Node("B");     // 노드 B 생성 후 A와 연결
        first.next.next = new Node("C");// 노드 C 생성 후 B와 연결
    }
}
```
## 연결 리스트 구현
```java
public class MyLinkedList<E> { 
    private Node<E> first;
    private int size = 0;
    
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
    
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }  
        size++;
    }
 
    private Node<E> getLastNode() {
        Node<E> x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }
    
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }
 
    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }
 
    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removedItem = removeNode.item;
        if (index == 0) {
            first = removeNode.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removedItem;
    }
    
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.item;
    }
 
    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
 
    public int indexOf(E o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) 
                return index;
            index++;
        }
        return -1;
    }
 
    public int size() {
        return size;
    }
 
    @Override
    public String toString() {
        return "MyLinkedListV3{" + 
                "first=" + first + 
                ", size=" + size + '}';
    }
 
    private static class Node<E> {
        E item;
        Node<E> next;
        
        public Node(E item) {
            this.item = item;
        }
 
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> temp = this;
            sb.append("[");
            while (temp != null) {
                sb.append(temp.item);
                if (temp.next != null) {
                    sb.append("->");
                }
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
```