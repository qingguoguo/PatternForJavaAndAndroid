package objectpool;

public class ObjectPoolDemo {
    public static void main(String[] args) {
        TestObject[] array = new TestObject[32];
        for (int i = 0; i < 32; i++) {
            array[i] = new TestObject();
        }
        final ObjectPool<TestObject> objectPool = new ObjectPool<>(array);

        for (int i = 0; i < 50; i++) {
            new Thread("Thread:" + i) {
                @Override
                public void run() {
                    for (int j = 0; j < 50; j++) {
                        TestObject testObject = objectPool.obtain();
                        testObject.print(getName(), "--index:" + j);
                        objectPool.recycle(testObject);
                    }
                }
            }.start();
        }
    }

    static class TestObject extends ObjectPool.RecyclableObject {

        public void print(String thread, String index) {
            System.out.println(thread + index);
        }

        @Override
        public ObjectPool.RecyclableObject create() {
            return new TestObject();
        }
    }
}
