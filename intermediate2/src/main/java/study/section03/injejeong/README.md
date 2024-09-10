# 컬렉션 프레임워크 - ArrayList
## 빅오(O) 표기법
- 알고리즘의 성능을 분석할 때 사용하는 수학적 표현 방식
- 입력 크기에 따라 얼마나 빠르게 또는 느리게 실행되는지를 표현
- 핵심은 정확한 실행 시간 계산이 아닌 데이터 양 증가에 따라 성능의 변화 추세를 이해하는 것
- 예시
  - O(1) - 상수 시간: 데이터 크기와 상관없이 실행 시간 일정
    - 배열의 특정 인덱스 접근 시
  - O(n) - 선형 시간: 데이터 크기에 비례해서 실행 시간 증가
    - 배열의 모든 요소 순회 시
  - O(n²) - 제곱 시간: 데이터 크기의 제곱에 비례해서 실행 시간 증가
    - 중첩 반복문 사용 시
  - O(log n) - 로그 시간: 데이터 크기의 로그에 비례해서 실행 시간 증가
    - 이진 탐색
  - O(n log n) - 선형 로그 시간: 데이터 크기에 비례한 로그에 비례해서 실행 시간이 증가
    - 합병 정렬(merge sort)과 같은 정렬 알고리즘
## 배열리스트(`ArrayList`) 도입
- 필요성: 배열의 한계
  - 길이를 동적으로 변경 불가
  - 데이터 추가 시의 번거로움
- 요소가 추가되거나 제거될 때 자동으로 크기 조절
## `ArrayList` 구현
```java
import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private int size = 0;
    
    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }
    
    public MyArrayList(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }
    
    public int size() {
        return size;
    }
  
    public void add(E e) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = e;
        size++;
    }
  
    public void add(int index, E e) {
        if (size == elementData.length) {
            grow();
        }
        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }
  
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elementData[index];
    }
  
    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }
    
    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);
        size--;
        elementData[size] = null;
        return oldValue;
    }
    
    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }
    
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + 
                size + ", capacity=" + elementData.length;
    }
}
```