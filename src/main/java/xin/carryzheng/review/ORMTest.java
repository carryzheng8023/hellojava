package xin.carryzheng.review;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author zhengxin
 * @date 2021-07-16 13:56:27
 */
public class ORMTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class clazz = Class.forName("xin.carryzheng.review.Student");

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        TableTest tableTest = (TableTest)clazz.getAnnotation(TableTest.class);
        System.out.println(tableTest.value());

        Field f = clazz.getDeclaredField("id");
        FieldTest annotation = f.getAnnotation(FieldTest.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.columnType());
        System.out.println(annotation.columnLength());

    }


}


@TableTest("student")
class Student{

    @FieldTest(columnName = "id", columnType = "int", columnLength = "10")
    private int id;
    @FieldTest(columnName = "name", columnType = "varchar", columnLength = "20")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableTest {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldTest {
    String columnName();
    String columnType();
    String columnLength();
}