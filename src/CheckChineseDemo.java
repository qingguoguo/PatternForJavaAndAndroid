
public class CheckChineseDemo {


    public static void main(String args[]) {

        boolean isChinese = "A".matches("^[\\u4e00-\\u9fa5a-zA-Z]+$");

        System.out.println("全为中文：" + isChinese);
    }
}
