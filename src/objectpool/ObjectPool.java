package objectpool;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObjectPool<T extends ObjectPool.RecyclableObject> {
    private T[] mTable;
    private AtomicInteger mOrderNumber;
    public static int RESET_NUM = 1000;

    public ObjectPool(T[] inputArray) {
        mOrderNumber = new AtomicInteger(0);
        mTable = inputArray;
        if (mTable == null) {
            throw new NullPointerException("The input array is null.");
        }
        int length = inputArray.length;
        if ((length & length - 1) != 0) {
            throw new RuntimeException("The length of input array is not 2^n.");
        }
    }

    public void recycle(T t) {
        t.isIdle.set(true);
    }

    public T obtain() {
        return obtain(0);
    }

    public T obtain(int retryTime) {
        int index = mOrderNumber.getAndIncrement();
        if (index > RESET_NUM) {
            mOrderNumber.compareAndSet(index, 0);
            if (index > RESET_NUM * 2) {
                mOrderNumber.set(0);
            }
        }

        int num = index & (mTable.length - 1);
        T target = mTable[num];
        if (target.isIdle.compareAndSet(true, false)) {
            return target;
        } else {

            // 注意：此处可能会因为OBJECT回收不及时，而导致栈溢出。
            // 请增加retryTime参数，以及retryTime过多后的判断。
            // 具体思路请参考
            // https://github.com/SpinyTech/ModularizationArchitecture/blob/master/macore/src/main/java/com/spinytech/macore/router/RouterRequest.java
            // 中的obtain()及obtain(int retryTime);方法

            if (retryTime < 5) {
                return obtain(++retryTime);
            } else {
                return (T) target.create();
            }
        }
    }

    public abstract static class RecyclableObject {
        AtomicBoolean isIdle = new AtomicBoolean(true);

        public abstract RecyclableObject create();
    }
}
