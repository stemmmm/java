# 컬렉션 프레임워크 - HashSet
## HashSet
- 중복을 허용하지 않고 순서가 없는 컬렉션
- 내부적으로 해시 테이블을 사용하여 요소를 저장
- 따라서 요소의 추가, 삭제, 검색이 평균적으로 O(1) 소요
- 주요 메서드
  - `add(E e)`: 요소 추가
  - `remove(Object o)`: 요소 제거
  - `contains(Object o)`: 요소가 포함되어 있는지 확인
  - `size()`: 요소의 개수 반환
  - `isEmpty()`: HashSet이 비어있는지 확인
  - `clear()`: 모든 요소 제거
- 해시 함수에 따라 성능이 달라지므로 사용자 정의 객체 사용 시 `hashCode()`와 `equals()` 메서드 오버라이드
  - 해시 충돌 방지, 성능 최적화, 중복 체크를 올바르게 하기 위함
- 제네릭 사용 가능
```java
public class HashSet<E> {
  static final int DEFAULT_INITIAL_CAPACITY = 16;
  private LinkedList<E>[] buckets;
  private int size = 0;
  private int capacity = DEFAULT_INITIAL_CAPACITY;

  public MyHashSetV3() {
    initBuckets();
  }

  public MyHashSetV3(int capacity) {
    this.capacity = capacity;
    initBuckets();
  }

  private void initBuckets() {
    buckets = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      buckets[i] = new LinkedList<>();
    }
  }

  @Override
  public boolean add(E value) {
    int hashIndex = hashIndex(value);
    LinkedList<E> bucket = buckets[hashIndex];
    if (bucket.contains(value)) {
      return false;
    }
    bucket.add(value);
    size++;
    return true;
  }

  @Override
  public boolean contains(E searchValue) {
    int hashIndex = hashIndex(searchValue);
    LinkedList<E> bucket = buckets[hashIndex];
    return bucket.contains(searchValue);
  }

  @Override
  public boolean remove(E value) {
    int hashIndex = hashIndex(value);
    LinkedList<E> bucket = buckets[hashIndex];
    boolean result = bucket.remove(value);
    if (result) {
      size--;
      return true;
    } else {
      return false;
    }
  }

  private int hashIndex(Object value) {
    return Math.abs(value.hashCode()) % capacity;
  }

  public int getSize() {
    return size;
  }
  
  @Override
  public String toString() {
    return "MyHashSet{" + 
            "buckets=" + Arrays.toString(buckets) + 
            ", size=" + size + 
            ", capacity=" + capacity + 
            '}';
  }
}
```