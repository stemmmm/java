package study.week1.section6.hoyunjung.a;

import lombok.Getter;

@Getter
public class PublicClass {
    public String publicField = "publicField";
    String packagePrivateField = "packagePrivateField";
    protected String protectedField = "protectedField";
    private String privateField = "privateField";
}
