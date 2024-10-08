# 컬렉션 프레임워크 - 순회, 정렬, 전체 정리

## 순회
- 자료 구조의 구현과 관계 없이 모든 자료 구조를 동일한 방법으로 순회하기 위해 자바는 `Iterator`와 `Iterable` 인터페이스를 제공함
- 자료 구조가 순회 가능하려면 해당 자료 구조는 `Iterable`을 구현해야 하며, `iterator()` 메서드를 통해 `Iterator`를 구현체를 리턴해야 함

### `Iterator`
- `hasNext()` 메서드로 자료 구조에 다음 요소가 있는지 확인하고, 있다면 `next()` 메서드로 이동 후 해당 요소를 리턴함

```java
public interface Iterator<E> {
    boolean hasNext();  // 다음 요소가 있는지 확인
    E next();           // 다음 요소 리턴 및 이동
}
```

### `Iterable`
- `Iterable`을 구현한 클래스는 for-each 문을 사용할 수 있음

```java
public interface Iterable<T> {
    Iterator<T> iterator();
}
```

<br>

## 정렬
### `Comparable`
- 객체를 정렬하려면 `Comparable` 인터페이스를 구현해야 함
- 객체의 기본 정렬 방법을 정의함

```java
public interface Comparable<T> {
    public int compareTo(T o);
}

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return this.age - other.age;  // 나이 기준 오름차순 정렬
    }
}
```

### `Comparator`
- 커스텀 정렬을 하고싶다면 `Comparator` 인터페이스를 구현해야 함
- 정렬 기준을 외부에서 정의할 수 있음

```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());  // 이름 기준 오름차순 정렬
    }
}

public class ReverseAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p2.getAge() - p1.getAge();  // 나이 기준 내림차순 정렬
    }
}
```

### 정렬법
- `Comparable`의 `compareTo()`나 `Comparator`의 `compare()` 메서드의 리턴 값에 따라 객체의 순서가 결정됨
- 현재 객체(`o1`)와 대상 객체(`o2`)를 비교하여:
  - `o1 - o2 > 0`: 순서 변경
  - `o1 - o2 = 0`: 순서 변경하지 않음
  - `o1 - o2 < 0`: 순서 변경하지 않음
- 결론: `o1 - o2`은 오름차순 정렬, `o2 - o1`는 내림차순 정렬

> **Tip**  
> `o1`, `o2`에 임의의 정수를 넣어서 어떤 순서로 정렬되는지 이해할 수 있음  
> 예를 들어, `o1 = 1, o2 = 2`인 경우 `o1 - o2 < 0`이므로 순서 변경하지 않아 오름차순 정렬됨    
> `o2 - o1 > 0`이므로 `o2`과 `o1`의 순서를 변경하여 내림차순 정렬됨 

<br>

## `Collection`
- 자바 컬렉션 프레임워크의 최상위 인터페이스
- `List`, `Set`, `Queue` 등의 부모(`Map`은 제외)
