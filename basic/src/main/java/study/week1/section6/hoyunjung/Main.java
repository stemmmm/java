package study.week1.section6.hoyunjung;

import study.week1.section6.hoyunjung.a.PublicClass;

public class Main extends PublicClass {
    public static void main(String[] args) {
        // public 클래스는 다른 패키지에서 접근 가능
        PublicClass publicClass = new PublicClass();

        // public 필드 및 public 메서드는 다른 패키지에서 접근 가능
        System.out.println(publicClass.publicField);
        System.out.println(publicClass.getPublicField());

        // package-private 필드는 다른 패키지에서 접근 불가하므로 public getter를 정의해 접근
        System.out.println(publicClass.getPackagePrivateField());

        // protected 필드는 다른 패키지에서 접근 불가하므로 상속 혹은 public getter를 정의해 접근
        // main 함수는 static 메서드이므로 Main이 PublicClass를 상속받아도 main 함수 내부에서는 접근 불가
        System.out.println(publicClass.getProtectedField());

        // private 필드는 다른 패키지에서 접근 불가하므로 public getter를 정의해 접근
        System.out.println(publicClass.getPrivateField());
    }

    // 인스턴스 메서드에서는 protected 필드에 접근 가능
    public void printProtectedField() {
        System.out.println(protectedField);
    }
}
