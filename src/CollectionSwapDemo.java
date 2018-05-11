import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSwapDemo {

    public static void main(String args[]) {
        int fromPosition = 3;
        int targetPosition = 10;
        List<Integer> mData = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            mData.add(i);
        }
        System.out.println("交换前：" + mData);
        //Collections.swap(mData, fromPosition, targetPosition);
        //Collections 工具类
        if (fromPosition > targetPosition) {
            for (int i = fromPosition; i > targetPosition; i--) {
                Collections.swap(mData, i, i-1);
            }
        } else {
            for (int i = fromPosition; i < targetPosition; i++) {
                Collections.swap(mData, i, i+1);
            }
        }

        System.out.println("交换后：" + mData);
    }
}
