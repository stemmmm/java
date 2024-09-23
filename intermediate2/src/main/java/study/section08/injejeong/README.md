# 컬렉션 프레임워크 - Set
- 특징: 중복을 허용하지 않고 순서가 없는 데이터 집합을 표현
- 주요 구현 클래스
  - `HashSet`
    - 해시 테이블을 기반으로 하며, 가장 일반적으로 사용
    - 삽입, 삭제, 검색 모두 평균 O(1) 시간 복잡도를 가짐
    - 순서 보장되지 않음
    - 데이터의 유일성만 중요하고, 순서가 중요하지 않은 경우에 적합
  - `LinkedHashSet`
    - `HashSet`의 특징을 가지면서, 요소가 삽입된 순서 유지
    - 해시 테이블과 `LinkedHashSet`를 함께 사용하여 순서 유지
    - 데이터의 유일성과 함께 삽입 순서를 유지해야 할 때 적합
  - `TreeSet` 
    - 이진 검색 트리를 기반으로 하며, 자연 순서 또는 사용자 정의 정렬에 따라 요소 정렬
    - 성능은 O(log n)으로, 정렬된 순서로 요소를 저장하고 검색
    - 데이터들을 정렬된 순서로 유지하면서 집합의 특성을 유지해야 할 때 사용
```java
public class Set {
    public static void main(String[] args) {
        run(new HashSet<>());
        run(new LinkedHashSet<>());
        run(new TreeSet<>());
    }

    private static void run(Set<String> set) {
        System.out.println("set = " + set.getClass());
        set.add("C");
        set.add("B");
        set.add("A");
        set.add("1");
        set.add("2");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
```
## 트리 구조
- 계층적인 관계를 나타내는 데 사용
- 노드(node)로 구성되며, 각 노드는 데이터를 저장하고, 자식 노드를 가질 수 있음
- 이진 트리: 자식이 2개까지 올 수 있는 트리 
- 이진 탐색 트리: 노드의 왼쪽 자손은 더 작은 값을 가지고, 오른쪽 자손은 더 큰 값을 가지는 트리
  - 데이터의 값을 기준으로 정렬해서 보관하기 때문에 정렬된 순서로 데이터를 차례로 조회 가능
```java
class Node {
    int value;
    Node left, right;

    public Node(int item) {
        value = item;
        left = right = null;
    }
}
```