package patternsingleton.singleton06;

public class VolatileTest {
    public static void main(String[] args) {
        MyRunnable td = new MyRunnable();
        new Thread(td).start();
        while (true) {
            if (td.isFlag()) {
                System.out.println("------------------");
                break;
            }
        }
        // 执行结果？ flag= true  ------------------
    }
}

class MyRunnable implements Runnable {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        flag = true;
        System.out.println("flag = " + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }
}
