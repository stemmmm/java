# 컬렉션 프레임워크 - Map, Stack, Queue
## `Map`
- 키-값 쌍을 저장하는 데이터 구조
- 키는 중복될 수 없지만, 값은 중복될 수 있으며, 순서를 유지하지 않는다.
- 주요 메서드
  - `put(K key, V value)`: 키와 값을 추가
  - `get(Object key)`: 키에 해당하는 값 반환
  - `remove(Object key)`: 키에 해당하는 엔트리 제거
  - `containsKey(Object key)`: 특정 키가 존재하는지 확인
  - `keySet()`: 모든 키 반환
  - `values()`: 모든 값 반환
- `Entry`: 키-값의 쌍으로 이루어진 간단한 객체
  - `Map` 내부에서 키와 값을 함께 묶어서 저장하기 때문에 `Map`의 내용을 반복할 때 유용
  - 주요 메서드
    - `getKey()`: 엔트리의 키 반환
    - `getValue()`: 엔트리의 값 반환
    - `setValue(V value)`: 엔트리의 값 설정, 이전 값을 반환
## `HashMap`
- 해시 테이블 기반의 구현으로, 키의 순서가 보장되지 않음
- 평균적으로 O(1)의 시간 복잡도로 삽입, 삭제, 검색 가능
- - 마찬가지로 `Map` 의 `Key` 로 사용되는 객체는 `hashCode()` , `equals()` 반드시 구현
## `LinkedHashMap`
- 순서를 유지해야 하는 경우 사용
## `TreeMap`
- Red-Black Tree 기반으로, 키의 순서가 자연 정렬 순서에 따라 유지
- O(log n)의 시간 복잡도로 삽입, 삭제, 검색 가능
```java
public class Map {
    public static void main(String[] args) {
        run(new HashMap<>());
        run(new LinkedHashMap<>());
        run(new TreeMap<>());
    }

    private static void run(Map<String, Integer> map) {
        System.out.println("map = " + map.getClass());
        map.put("C", 10);
        map.put("B", 20);
        map.put("A", 30);
        map.put("1", 40);
        map.put("2", 50);
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.print(key + "=" + map.get(key) + " ");
        }
        System.out.println();
    }
}
```
## `Stack`
- 후입 선출(LIFO, Last In First Out): 나중에 넣은 것이 가장 먼저 나오는 것
- `push`로 스택에 값을 넣고, `pop`으로 값을 꺼낸다.
- `Stack` 클래스는 현재 사용되지 않고 하위 호환을 위해 존재하기 때문에 사용하지 않는 것을 권장
## `Queue`
- 선입 선출(FIFO, First In First Out): 가장 먼저 넣은 것이 가장 먼저 나오는 것
- `offer`로 스택에 값을 넣고, `poll`로 값을 꺼낸다.
- `Queue`의 대표적인 구현체는 `ArrayDeque`, `LinkedList`가 있다.
- 성능과 메모리 효율성을 중시하는 경우 `LinkedList`보다 `ArrayDeque` 사용 권장
## `Deque`
- "Double Ended Queue"의 약자로, 양쪽 끝에서 요소를 추가하거나 제거 가능
- 큐와 스택의 기능을 모두 포함