package xin.carryzheng.review;

/**
 * @author zhengxin
 * @date 2021-06-10 19:05:56
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        Object obj = new Object();

        System.out.println(obj.getClass().getClassLoader());


        DeadLockTest deadLockTest = new DeadLockTest();

        System.out.println(DeadLockTest.class.getClass().getClassLoader());

        System.out.println(deadLockTest.getClass().getClassLoader().getParent().getParent());
        System.out.println(deadLockTest.getClass().getClassLoader().getParent());
        System.out.println(deadLockTest.getClass().getClassLoader());
    }
}
