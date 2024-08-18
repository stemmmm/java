package study.week4.section08.hoyunjung.question;

public class Question1 {
    public static void main(String[] args) {
        OuterClass.NestedClass nestedClass = new OuterClass.NestedClass();
        nestedClass.hello();

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.hello();

        outerClass.localClassHello();

        outerClass.anonymousClassHello();
        outerClass.lambdaHello();
    }
}

class OuterClass {
    static class NestedClass {
        void hello() {
            System.out.println("NestedClass.hello");
        }
    }

    class InnerClass {
        void hello() {
            System.out.println("InnerClass.hello");
        }
    }

    void localClassHello() {
        class LocalClass {
            void hello() {
                System.out.println("LocalClass.hello");
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.hello();
    }

    void anonymousClassHello() {
        Hello hello = new Hello() {
            @Override
            public void hello() {
                System.out.println("AnonymousClass.hello");
            }
        };

        hello.hello();
    }

    void lambdaHello() {
        Hello hello = (() -> System.out.println("lambda.hello"));
        hello.hello();
    }
}

interface Hello {
    void hello();
}
