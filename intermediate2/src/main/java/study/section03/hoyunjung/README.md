# 컬렉션 프레임워크 - ArrayList

## 배열 vs ArrayList
| **특성**   | **배열 (Array)**               | **ArrayList**             |
|----------|------------------------------|---------------------------|
| **크기**   | 고정(초기화시 지정된 크기)              | 가변                        |
| **타입**   | 기본 타입, 객체 타입 모두 저장 가능        | 객체 타입만 저장 가능              |
| **사용 예** | 메모리 효율이 중요할 때, 데이터 크기가 고정일 때 | 크기가 가변적이고 삽입/삭제가 자주 발생할 때 |

## ArrayList 구현
- `List`: 순서가 있고 중복을 허용하는 ADT
- `ArrayList`는 내부적으로 배열을 사용해서 구현됨

```java
import java.util.Arrays;

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
        for (int i = size; i > index ; i--) {
            elementData[i] = elementData[i - 1];  
        }
    }
    
    // ...
}
```