# 컬렉션 프레임워크 - 순회, 정렬
## 순회
- 자료 구조에 들어있는 데이터를 차례대로 접근해서 처리하는 것
- 자료 구조마다 순회하는 방법이 서로 다르기 때문에 너무 많은 내용을 알아야 함
- 자료 구조를 동일한 방법으로 순회할 수 있는 일관성 있는 방법 → `Iterable`과 `Iterator` 인터페이스 사용
- 컬렉션 프레임워크의 모든 자료 구조는 `Iterable`과 `Iterator`를 사용하여 편리하고 일관된 방법으로 순회 가능
- `Iterable`
```java
public interface Iterable<T> {
    Iterator<T> iterator();
}
```
- `Iterator`
  - 자료 구조에 다음 요소가 있는지 확인하고, 있으면 다음 요소를 꺼내는 과정 반복
```java
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
```
- 향상된 for문(`for-each`)
  - `Iterable` 인터페이스를 구현하는 객체에 대해 사용 가능
  - 모든 데이터를 순회해야할 시 사용 권장
## 정렬
- 데이터를 특정 기준에 따라 순서대로 배치하는 과정
- `Arrays.sort()`
```java
Integer[] array = {3, 2, 1};
System.out.println(Arrays.toString(array));
System.out.println("기본 정렬 후");
Arrays.sort(array);
System.out.println(Arrays.toString(array)); //[1, 2, 3]
```
## 사용자 객체 정렬
- `Comparator`
  - 두 값을 비교할 때 비교 기준을 직접 제공
  - 기본 정렬이 아니라 정렬 방식을 지정하고 싶다면 `Arrays.sort()`의 인수로 `Comparator`를 만들어서 넘겨주면 됨
    - `Arrays.sort(array, Comparator);`
```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```
- `Comparable`
  - 객체에 비교 기능을 추가하고, 기본 자연 순서(Natural Ordering)를 제공
```java
public interface Comparable<T> {
    public int compareTo(T o);
}
```