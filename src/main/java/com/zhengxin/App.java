package com.zhengxin;

import com.google.gson.Gson;
import com.zhengxin.j2se.containers.RandomBounds;
import com.zhengxin.j2se.enumerated.VendingMachine;
import com.zhengxin.j2se.holding.IterableClass;
import com.zhengxin.j2se.io.*;
import com.zhengxin.j2se.net.mindview.util.Null;
import com.zhengxin.j2se.typeinfo.ShowMethods;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.zhengxin.j2se.net.mindview.util.Print.print;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

//        Path listing = Paths.get("E:\\doc\\服务\\1-资源池建设\\服务者信息");
//        System.out.println("File name [" + listing.getFileName() + "]");
//        System.out.println("Number of Name Elements in the path [" + listing.getNameCount() + "]");
//        System.out.println("Parent Path [" + listing.getParent() + "]");
//        System.out.println("Root of Path [" + listing.getRoot() + "]");
//        System.out.println("Subpath from Root, 2 elements deep [" + listing.subpath(0,2) + "]");

//        Map<String, String> maps = new TreeMap<>();
//        maps.put("merNo", "101001");
//        maps.put("orderNo", "FW20160218000003_1455763579462");
//        maps.put("reason", "english");
//        maps.put("totalFee", null);
//
//        System.out.print(App.md5Sign(maps, "o1yeglvrgxxnrl4hdu3cwkuqekw6z078"));

//        int a = 2;
//        int result = 0;
//
//        switch (a){
//            case 1 : result = result + a;
//            case 2 : result = result + a * 2;
//            case 3 : result = result + a * 3;
//        }
//
//        System.out.println(result);


//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 100; i++){
//                    System.out.println(i);
//                }
//            }
//        };
//        t.run();
//
//
//        new Thread() {
//            @Override
//            public void run() {
//                for(int i = 0; i < 100; i++){
//                    System.out.println(i);
//                }
//            }
//        }.start();
//
//
//        try {
//
//        }catch (Exception e){
//            throw new Exception();
//        }

//        String s1 = "123";
//        System.out.println(s1.hashCode());
//
//        String s2 = "123";
//        System.out.println(s2.hashCode());
//
//        String s21 = "1234";
//        System.out.println(s21.hashCode());
//
//        String s3 = new String("123");
//        System.out.println(s3.hashCode());
//
//        String s4 = new String("123");
//        System.out.println(s4.hashCode());
//
//        System.out.println(s1 == s2);
//        System.out.println(s2 == s3);
//        System.out.println(s3 == s4);
//
//        A a1 = new A();
//        A a2 = new A();
//
//        System.out.println(a1.hashCode());
//        System.out.println(a2.hashCode());
//
//        System.out.println(a1 == a2);
//        System.out.println(a1.equals(a2));
//
//        System.out.println(System.currentTimeMillis());

//        List<String> a1 = new ArrayList<>();
//        a1.add("Program");
//        a1.add("Creek");
//        a1.add("Java");
//        a1.add("Java");
//        System.out.println("ArrayList Elements");
//        System.out.print("\t" + a1 + "\n");
//
//        List<String> l1 = new LinkedList<>();
//        l1.add("Program");
//        l1.add("Creek");
//        l1.add("Java");
//        l1.add("Java");
//        System.out.println("LinkedList Elements");
//        System.out.print("\t" + l1 + "\n");
//
//        Set<String> s1 = new HashSet<>(); // or new TreeSet() will order the elements;
//        s1.add("Program");
//        s1.add("Creek");
//        s1.add("Java");
//        s1.add("Java");
//        s1.add("tutorial");
//        System.out.println("Set Elements");
//        System.out.print("\t" + s1 + "\n");
//
//        Map<String, String> m1 = new HashMap<>(); // or new TreeMap() will order based on keys
//        m1.put("Windows", "2000");
//        m1.put("Windows", "XP");
//        m1.put("Language", "Java");
//        m1.put("Website", "programcreek.com");
//        System.out.println("Map Elements");
//        System.out.print("\t" + m1);

//       List<Integer> list = Arrays.asList(1, 2, 3);
////        list.set(4, 44);
////        list.add(45);

//        Collection<String> c = new ArrayList();
//        c.add("first");
//        c.add("second");
//
//        for (String s : c){
//            System.out.println(s);
//        }
//
//        System.out.println(c.toString());

//        A[] as = new A[]{new A("zhangsan"), new A("lisi"), new A("wangwu")};
//
//        for (A a : (ImplementIterable<A>)new ImplementIterable(as))
//            System.out.println(a.toString());

//        ShowMethods.main(new String[]{"com.zhengxin.j2se.typeinfo.ShowMethods"});

//        System.out.println(new ArrayList<Integer>().getClass() == new ArrayList<>().getClass());

//        RandomBounds.main(new String[]{"sdf"});

//        A a = new A();
//        a.setName("zhengxin");
//
//        Map map = BeanToMapUtil.convertBean(a);
//
//        Set<String> set = map.keySet();
//
//        System.out.print(set.size());

//        DirList.main(new String[]{"D.*\\.java"});
//        DirList2.main(new String[]{"D.*\\.java"});
//        DirList3.main(new String[]{"D.*\\.java"});

//        MakeDirectories.main(new String[]{"-r", "F:\\test\\test.txt", "F:\\test\\haha.txt"});

//        ChannelCopy.main(new String[]{"E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\ChannelCopy.java","E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\test.txt"});

//        TransferTo.main(new String[]{"E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\TransferTo.java", "E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\TransferTo.txt"});

//        GZIPcompress.main(new String[]{"E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\GZIPcompress.java"});

//        ZipCompress.main(new String[]{"E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\ZipCompress.java"});

//        VendingMachine.main(new String[]{"E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\enumerated\\VendingMachineInput.txt"});


//        HashMap e = new HashMap();
//        e.put("name", "zheng xin");
//        e.put("age", 23);
//        e.put("url", URLEncoder.encode("https://www.baidu.com", "utf-8"));
//        e.put("url", "https://www.baidu.com?a=1&b=2");




//        System.out.println(e.toString());
//
//        Gson gson = new Gson();
//
//        String json = gson.toJson(e);
//        System.out.println(json);
//
//        A a = (A)gson.fromJson(e.toString(), A.class);
//        A a = (A)gson.fromJson(json, A.class);
//
//        System.out.println(a);

//        A a = new A("zhengxin", 18, "www.baidu.com");
//
//        a.aMethod();

//        BigDecimal a = new BigDecimal("1.04");
//        BigDecimal b = new BigDecimal(1.04);
//        print(a.toString());
//        print(b.toString());


//        print(System.currentTimeMillis());
    }


    static void pong() {
        System.out.println("pong");
    }

    private static String fillStringByArgs(String str, String[] arr) {
        Matcher m = Pattern.compile("\\{(\\d)\\}").matcher(str);
        while (m.find()) {
            str = str.replace(m.group(), arr[Integer.parseInt(m.group(1))]);
        }
        return str;
    }

    public static String md5Sign(Map<String, String> params, String appSecret) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuilder strBuf = new StringBuilder();
        for (int i = 0, n = keys.size(); i < n; i++) {
            String tmp = keys.get(i);
            if (!"toonSign".equalsIgnoreCase(tmp)) {
                String value = params.get(tmp);
                if (value != null && value.length() > 0) {
                    strBuf.append(tmp).append("=").append(value).append("&");
                }
            }
        }
        int len = strBuf.length();
        strBuf.delete(len - 1, len);
        strBuf.append(appSecret);
        return strBuf.toString();
    }
}
