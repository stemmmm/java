package study.section05.hoyunjung;

// import 문을 통해 다른 패키지의 클래스 간결하게 사용 가능
// import study.week1.section5.hoyunjung.a.SameName;

public class Main {
    public static void main(String[] args) {
        // a, b 패키지가 다름 -> 서로 다른 namespace -> 클래스 이름 같아도 문제 없음
        // 대신 클래스 이름이 같으므로 서로 헷갈리지 않게 명시적으로 모든 경로를 표기함
        // import 문을 사용할 수 있지만 이름이 중복되는 경우 하나의 클래스에 대해서만 사용 가능
        new study.week1.section05.hoyunjung.a.SameName();
        new study.week1.section05.hoyunjung.b.SameName();
    }
}
