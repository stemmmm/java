# 컬렉션 프레임워크 - `ArrayList`

## `ArrayList`
- 내부적으로 배열(`Object[]`)을 사용해 구현됨
- 기본 `CAPACITY`는 10이며, `CAPACITY`를 넘어가면 50%씩 크기를 증가시킴
- 메모리 고속 복사 연산(`System.arraycopy()`)을 사용해 데이터 이동을 최적화함

## 배열 vs `ArrayList`
| **특성**   | **배열 (Array)**               | **`ArrayList`**             |
|----------|------------------------------|---------------------------|
| **크기**   | 고정(초기화시 지정된 크기)              | 가변                        |
| **타입**   | 기본 타입, 객체 타입 모두 저장 가능        | 객체 타입만 저장 가능              |
| **사용 예** | 메모리 효율이 중요할 때, 데이터 크기가 고정일 때 | 크기가 가변적이고 삽입/삭제가 자주 발생할 때 |

## `ArrayList` 구현
```java
public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size = 0;

    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(int index, E e) {
        if (size == elementData.length) {
            grow();
        }

        shiftRightFrom(index);

        elementData[index] = e;
        size++;
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    // ...
}
```