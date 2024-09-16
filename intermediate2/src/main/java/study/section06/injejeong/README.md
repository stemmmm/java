# 컬렉션 프레임워크 - 해시(Hash)
## 리스트(`List`) vs 세트(`Set`)
- 공통점: 컬렉션 프레임워크의 인터페이스로, 데이터를 저장하고 관리하는 데 사용되며, 제네릭 사용 가능
- 차이점
  - `List`는 중복 요소를 허용하지만, `Set`는 중복을 허용하지 않는다.
  - `List`는 요소가 추가된 순서를 유지하지만, `Set`는 순서를 보장하지 않는다.
## 해시(hash) 알고리즘
- `Set`에서 데이터 추가, 검색 시 성능은 O(n) 으로 좋지 않다.
- 해시 알고리즘을 적용하여 데이터의 값 자체를 배열의 인덱스로 사용
- 배열에서 인덱스를 찾는 연산은 O(1)이므로 성능 향상
```java
Integer[] inputArray = new Integer[10];
inputArray[1] = 1;
inputArray[2] = 2;
inputArray[5] = 5;
inputArray[8] = 8;
```
- 입력 값의 범위가 커지면 메모리 낭비가 심해짐
- 이를 방지하기 위해 나머지 연산 사용
- 값을 배열의 인덱스로 사용할 수 있도록 원래의 값을 계산한 인덱스를 해시 인덱스(hash index)라 한다.
```java
Integer[] inputArray = new Integer[10];
add(inputArray, 1);     // hash index = 1
add(inputArray, 2);     // hash index = 2
add(inputArray, 5);     // hash index = 5
add(inputArray, 8);     // hash index = 8
add(inputArray, 14);    // hash index = 4
add(inputArray, 99);    // hash index = 9
// inputArray = [null, 1, 2, null, 14, 5, null, null, 8, 99]
```
- 하지만 1과 11의 값이 동시에 들어온다면 충돌이 일어날 수 있음(해시 충돌)
- 배열 안에 배열을 만들어 같은 인덱스에 저장(`LinkedList` 사용)
```java
public class HashStart5 {
    static final int CAPACITY = 10;
    public static void main(String[] args) {
        // {1, 2, 5, 8, 14, 99 ,9}
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        
        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9); //중복
        System.out.println("buckets = " + Arrays.toString(buckets));
        
        //검색
        int searchValue = 9;
        boolean contains = contains(buckets, searchValue);
        System.out.println("buckets.contains(" + searchValue + ") = " +
                contains);
    }
    
    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        if (!bucket.contains(value)) { // O(n)
            bucket.add(value);
        }
    }
    
    private static boolean contains(LinkedList<Integer>[] buckets, int
            searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        return bucket.contains(searchValue); // O(n)
    }
    
    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
```