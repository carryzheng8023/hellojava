package xin.carryzheng.review;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhengxin
 * @date 2021-05-28 14:40:05
 */

class User {
    String username;
    String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class AtomicReferenceTest {

    public static void main(String[] args) {

        User zhangsan = new User("zhangsan", "zhangsan");
        User lisi = new User("lisi", "lisi");

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zhangsan);

        System.out.println(atomicReference.compareAndSet(zhangsan, lisi) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zhangsan, lisi) + "\t" + atomicReference.get().toString());
    }
}
