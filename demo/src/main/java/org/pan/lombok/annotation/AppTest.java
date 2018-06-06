package org.pan.lombok.annotation;

/**
 * @author Qipan.G
 * @since 2018/6/6 14:13
 */
@Getter
public class AppTest {

    private String value;

    private String value2;

    public AppTest(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        AppTest app = new AppTest("it works");
//        System.out.println(app.getValue());
    }

}
