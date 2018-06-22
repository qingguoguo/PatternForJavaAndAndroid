package algorithm.innerclass;


public class InnerClassDemo {


    public static void main(String[] args) {
        InnerClassDemo innerClassDemo = new InnerClassDemo();
        innerClassDemo.show();
    }
    InnerClassDemo innerClassDemo ;
    public void show() {

        class TestDemo {
            public void showInner() {
                System.out.println(innerClassDemo);
            }

            TestDemo(int i) {
            }
        }

        TestDemo testDemo = new TestDemo(10);
        testDemo.showInner();
    }
}
