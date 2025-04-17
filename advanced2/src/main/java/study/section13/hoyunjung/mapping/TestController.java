package study.section13.hoyunjung.mapping;

public class TestController {

    @SimpleMapping(value = "/")
    public void home() {
        System.out.println("TestController.home");
    }

    @SimpleMapping(value = "/site1")
    public void site1() {
        System.out.println("TestController.page1");
    }
}
