package com.zhengxin;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.zhengxin.j2se.net.mindview.util.Print.print;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {



        print();

//        App a = new App();

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
        Gson gson = new Gson();
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
//
//        try {
//            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-06-05");
//            print(date.getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String iloveyou = "ILOVEYOU";
//        char[] chars = iloveyou.toCharArray();
//
//        for (char c : chars){
//            print(Integer.toBinaryString(c));
//            print((int)c);
//        }

//        JsonBean jsonBean = new JsonBean();
//        jsonBean.setName("zhengxin");
//        LinkedList<String> hobbies = new LinkedList<>();
//        hobbies.add("羽毛球");
//        hobbies.add("篮球");
//        hobbies.add(0,"游泳");
//        jsonBean.setHobbies(hobbies);
//
//        String json = gson.toJson(jsonBean);
//
//        print(json);
//
//        JsonBean jb = gson.fromJson(json,JsonBean.class);
//
//        hobbies = jb.getHobbies();
//
//        print(hobbies.getClass());

//        Long msgId = UUID.randomUUID().getLeastSignificantBits();
//        print(msgId);
//        if (msgId < 0) {
//            msgId = msgId & 0X7FFFFFFFFFFFFFFFL;
//        }
//
//        print(msgId);
//
//
//        print(hexString2binaryString("7FFFFFFFFFFFFFFF"));


//        CommentContentBean c1 = new CommentContentBean("c_1", "内容1", null);
//        CommentContentBean c2 = new CommentContentBean("c_2", "内容2", c1);
//
//        String json1 = gson.toJson(c1);
//        String json2 = gson.toJson(c2);
//        print(json1);
//        print(json2);
//
//        CommentContentBean fromC1 = gson.fromJson(json1, CommentContentBean.class);
//        CommentContentBean fromC2 = gson.fromJson(json2, CommentContentBean.class);
//        print(fromC1);
//        print(fromC2);


//        Integer[] a = new Integer[]{1, 6, 4, 7, 23, 5};
//        String[] a = new String[]{"S", "O", "R", "T","E","X","A","M","P","L","E"};
//
//        for (String i : a)
//            printnb(i + "\t");
//
//        Insertion.sort(a);
//        print();
//
//        for (String i : a)
//            printnb(i + "\t");


//        Integer i1 = 127;
//        Integer i2 = 127;
//        Integer i3 = 128;
//        Integer i4 = 128;
//        Integer i5 = -128;
//        Integer i6 = -128;
//        Integer i7 = -129;
//        Integer i8 = -129;
//        print("127" + (i1 == i2));
//        print("128" + (i3 == i4));
//        print("-128" + (i5 == i6));
//        print("-129" + (i7 == i8));

//        List<Integer> arrayList = new ArrayList<>();
//        List<Integer> linkedList = new LinkedList<>();
//
//        for(int i=0; i<1000; i++){
//            arrayList.add(i);
//            linkedList.add(i);
//        }
//
//        Long beginTime = System.currentTimeMillis();
//        arrayList.add(0,-8);
//        Long endTime = System.currentTimeMillis();
//        print(endTime - beginTime);
//
//        beginTime = System.currentTimeMillis();
//        linkedList.add(0,-8);
//        endTime = System.currentTimeMillis();
//        print(endTime - beginTime);

//        A a1 = new A();
//        A a2 = new A();
//        a1.setAge(1);
//        a2.setAge(129);
//
//        print(a1.getAge() == Constant.CARD_TRANSFER1);
//        print(a1.getAge().equals(Constant.CARD_TRANSFER1));
//        print(a2.getAge() == Constant.CARD_TRANSFER129);
//        print(a2.getAge() == 129);
//        print(a2.getAge().equals(Constant.CARD_TRANSFER129));


//        Set<String> set = new HashSet<>();
//        set.add(123456 + "");
//        set.add(123456 + "");
//
//        print(set);

//        print(f());

//        try {
//            throw new RuntimeException();
//        }catch (Exception e){
//            throw new RuntimeException();
//        }

//        A a = new A();
//
//        if(null != a)
//            print("a != null");

//        print(App.class.getResource("/").getPath());


//        double showCount = 2l;
//        double count = 5l;
//
//        double num = count/showCount;
//        System.out.println(Math.ceil(num));
//        int intNum = (int)Math.ceil(num);
//        System.out.println(intNum);

//        for(int i=0; i<10; i++){
//            System.out.println(System.currentTimeMillis());
//            Thread.sleep(1000);
//        }

//        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        String str = null;
//
//        str = "2018-11-18";
//        try {
//            date = format1.parse(str);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(date.getTime());

//        System.out.println(new java.util.Date(1505491100000L));
//        System.out.println(new java.util.Date(1504967543000L));
//        System.out.println(System.currentTimeMillis());
//
//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list = list.subList(list.size(), list.size());
//
//        System.out.println(list.toString());

//        System.out.println(CheckUtil.checkIdNum("11010719930522002X"));
//        System.out.println(CheckUtil.isChinaPhoneLegal("17600207522"));
//        System.out.println(CheckUtil.checkEmail("17600207522@q.com"));

        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMdd");
//        String datetime = sdf.format(new Date());
//        System.out.println(datetime);
//
//        String datetime2 = sdf.format(new Date(1513218166721L));
//        System.out.println(datetime2);


//        Date date = new Date();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        calendar.add(calendar.DATE,5);
//        date = calendar.getTime();
//        String datetime3 = sdf.format(date);
//        System.out.println(datetime3);//使用时间
//
//
//        Date date1 = new Date(1513218166721L);
//        Date date2 = new Date(1513857193782L);
//
//        System.out.println(date1);
//        System.out.println(date2);
//        System.out.println(sdf.format(date1));
//
//        System.out.println(App.differentDays(date1, date2));
//
//        String inDatetime = "20171220";
//        String outDatetime = "20171225";
//
//        List<String> dates = new ArrayList<>();
//        dates.add(inDatetime);
//
//        Date inDate = sdf.parse(inDatetime);
//        Date outDate = sdf.parse(outDatetime);
//        System.out.println(App.differentDays(inDate, outDate));
//        int days = App.differentDays(inDate, outDate);
//
//        calendar.setTime(inDate);
//
//
//        Date varDate = null;
//
//        for (int i=1; i<days; i++){
//            calendar.add(calendar.DATE,1);
//            varDate = calendar.getTime();
//            String varDatetime = sdf.format(varDate);
//            dates.add(varDatetime);
//
//        }
//
//        for (String s : dates){
//            System.out.println(s);
//        }

//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(new Date());
//        calendar.add(calendar.HOUR,1);
//        calendar.add(calendar.DATE,-1);
//        long expireTime = calendar.getTimeInMillis();
//        System.out.println(new Date(expireTime));


//        A a = new A();
//        Class c1 = A.class;
//        Class c2 = a.getClass();
//        Class c3 = Class.forName("com.zhengxin.A");
//        System.out.println(c1 == c2);
//        System.out.println(c2 == c3);




//        int a = -143;
//        int b = 2;
//        System.out.println("a = " + a  + ", b = " + b);
//
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//
////        a = a + b;
////        b = a - b;
////        a = a - b;
//
//        System.out.println("a = " + a  + ", b = " + b);


//        System.out.println(isPrime(51));


//        System.out.println(Math.abs(-2147483648));
//        System.out.println(Math.abs(Long.MIN_VALUE));
//        System.out.println(Double.POSITIVE_INFINITY);
//        System.out.println(1.0 / 0.0);
//        System.out.println(Double.NEGATIVE_INFINITY);
//
//        Integer.valueOf("1");
//        Integer.parseInt("1");
//
//
//        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE == Integer.MIN_VALUE - 1);

//        Integer i1 = new Integer(122);
//        Integer i2 = new Integer(122);
//        Integer i3 = 128;
//        Integer i4 = 128;
//
//        int i5 = 128;
//        int i6 = 128;

//        System.out.println(i1 == i2);
//        System.out.println(i2 == i3);

//        System.out.println(i3 == i5);
//        System.out.println(i4 == i5);
//
//        System.out.println(i3 == i4);
//
//        System.out.println(i5 == i6);
//
//        Integer i = Integer.valueOf(-129);
//        Integer j = Integer.valueOf(-129);
//        if(i==j){
//            System.out.println("i==j is equal");
//        }else {
//            System.out.println("i==j is not equal");
//        }

//        final A a = new A("zhangsan", 12, "carryzheng.xin");
//
//       System.out.println(a);
//
//       a.setName("lisi");
//
//       System.out.println(a);

//        A a1 = new A("zhangsan", 12, "carryzheng.xin", new B("BJUT", "平乐园100号"));
//
//        A a2 = a1.clone();
//
////        a1.setName("李四");
//
//        String result = a1.getName() == a2.getName()
//                ? "clone是浅拷贝的" : "clone是深拷贝的";
//
//        System.out.println(result);
//
//        a1.getB().setAddress("西大望路27号");
//
//        System.out.println(a1);
//        System.out.println(a2);




//        System.out.println(f());

//        a.test(2);

//        B b1 = new B("bjut","100号");
//        B b2 = new B("cnu","101号");
//        B b3 = new B("pku","102号");
//
//        List<B> list = new ArrayList<>();
//        list.add(b1);
//        list.add(b2);
//        list.add(b3);
//
//        Iterator<B> iterator = list.iterator();
//
//        while(iterator.hasNext()){
//            B b = iterator.next().clone();
//            b.setSchool("哈哈");
//        }
//
//        for (B b : list){
//            System.out.println(b);
//        }
//
//        MyList<String> myList = new MyList<>();
//        for (String s : myList){
//
//        }

//        A a1 = new A();
//        System.out.println(a1.hashCode());

//        for (int i=0; i>0; i++){
//            System.out.println(i);
//        }

//        Integer[] integers = {1,9,8,5};
//        List<Integer> list = new ArrayList<>(Arrays.asList(integers));
////        Sort.mergeSort(list);
//
////        Collections.sort(list);
//
//        for (Integer integer : list){
//            System.out.println(integer);
//        }


//        String s1 = "hello";
//        String s2 = "hello";
//        String s3 = new String("hello");
//
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s2 == s3);
//
//        System.out.println("s1: " + s1);
//        System.out.println("s2: " + s2);
//        System.out.println("s3: " + s3);
//
//        System.out.println("s1.hashcode: " + s1.hashCode());
//        System.out.println("s2.hashcode: " + s2.hashCode());
//        System.out.println("s3.hashcode: " + s3.hashCode());
//
//        System.out.println("s1.hash: " + hash(s1));
//        System.out.println("s2.hash: " + hash(s2));
//        System.out.println("s3.hash: " + hash(s3));


//        String gdejicbegh = "gdejicbegh";
//        String hgebcijedg = "hgebcijedg";
//
//
//        System.out.println(gdejicbegh == hgebcijedg);
//        System.out.println(gdejicbegh.equals(hgebcijedg));
//
//
//        System.out.println("gdejicbegh:      " + Integer.toBinaryString(gdejicbegh.hashCode()));
//        System.out.println("hgebcijedg:      " + Integer.toBinaryString(hgebcijedg.hashCode()));
//
//        System.out.println("gdejicbegh.hash: " + Integer.toBinaryString(hash(gdejicbegh)));
//        System.out.println("hgebcijedg.hash: " + Integer.toBinaryString(hash(hgebcijedg)));
//
//
//
//        Map<String,String> map = new HashMap<>();
//
//
//        map.put(gdejicbegh,"56");
//        map.put(gdejicbegh,"12");
//        map.put(hgebcijedg,"56");
//
//        System.out.println(map.get("gdejicbegh"));
//        System.out.println(map.get("hgebcijedg"));

//        String E1 = "E";
//        String E2 = "E";
//
//        System.out.println(E1.compareTo(E2) < 0);

//        B b1 = new B("BJUT","平乐园");
//        B b2 = new B("PKU","北大");
//
//        List<B> bs = new ArrayList<>();
//
//        bs.add(b2);
//        bs.add(b1);
//
//
//        System.out.println(bs);
//
//        Collections.sort(bs, new Comparator<B>() {
//            @Override
//            public int compare(B o1, B o2) {
//
//                return o1.getSchool().compareTo(o2.getSchool());
//            }
//        });
//
//        System.out.println(bs);


//        List<Integer> integerList = new ArrayList<>();
//
//        integerList.add(1);
//        integerList.add(2);
//        integerList.add(3);
//
//        Object[] integers = integerList.toArray();
//
//        for (Object i : integers)
//            System.out.println(i);

//        Map<String, Integer> map = new HashMap<>();
//        String name = new String("张三");
//        map.put(name,18);
//        name = new String("李四");
//
//        System.out.println(map.get("张三"));
//        System.out.println(map.get(new String("张三")));
//        System.out.println(map.get(name));


//        int[] a = {4, 8, -59, 9, 6, -18, 7};
//
//        print(maxSubSequencSum(a));



//            print(climbStairs(40));
//            print(climbStairs2(40));

        Integer[] ints = new Integer[]{1,2,2,1,3,4,2,2,5};
//
//        forEachPrint(ints);
//
//        insertSort(ints);
//
//        forEachPrint(ints);

//        int[] a = {3,-1,2,5,-3,4,-6,-7,1,8,-3,5,9};
//
//        print(maxSubSequencSum(a));

//        Integer[] ints2 = new Integer[]{1,2,2,3,4,2,5,2};
//
//        System.out.println(majority(ints));

//        int[] aa = {2, 5, 3, 0, 2, 3, 0, 3};
//
//        int[] bb = countSort(aa, 6);
//
//        forEachPrint(bb);

//        double[] dd = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
//
//        List<Double> A = new ArrayList<>();
//
//        for (double d : dd)
//            A.add(d);
//
//        barrelSort(A);
//
//        forEachPrint(A);

//        print(func(9999));

//        RBTree rbTree = new RBTree(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        RBNode rbNode1 = new RBNode("C");
//        RBNode rbNode2 = new RBNode("A");
//        RBNode rbNode3 = new RBNode("F");
//        RBNode rbNode4 = new RBNode("E");
//
//        rbTree.insertNode(rbNode1);
//        rbTree.insertNode(rbNode2);
//        rbTree.insertNode(rbNode3);
//        rbTree.insertNode(rbNode4);
//
//        rbTree.deleteNode(rbNode1);
//
//        print(rbTree.getRoot().getData());

//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.forEach(System.out::println);

//        String str = "-1.36975357954895";
//
//        System.out.println("".equals(str) ? null : Double.parseDouble(str));


//        System.out.println(System.getProperty("java.library.path"));

//        System.out.println(formatFloatNumber(Double.MAX_VALUE));
//        System.out.println(Double.MAX_VALUE);
//        System.out.println(Float.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Short.MAX_VALUE);
//        System.out.println(Double.valueOf(Integer.MAX_VALUE));

        int i = 1; //i=1
        int j = i++; //j=1 i=2
        if ((i==(++j)) && (i++==j)){
            i += j;
        }
        System.out.println(i);

        int num = 50;
        num = num++ * 2;
        System.out.println(num);
    }

    public static String formatFloatNumber(double value) {
        if(value != 0.00){
            java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
            return df.format(value);
        }else{
            return "0.00";
        }

    }

    static int func(int x){
        int count=0;
        while (x>0)
        {
            count++;
            x=x&(x-1);//与运算
        }
        return count;
    }

    public static void barrelSort(List<Double> A){
        List<List<Double>> B = new ArrayList<>(A.size());
        for (List<Double> b : B)
            b = new ArrayList<>();
        for(double x : A)
            B.get((int)Math.floor(A.size() * x)).add(x);

        for (int i=0; i<B.size(); ++i)
            Collections.sort(B.get(i));

        A.removeAll(A);

        int j = 0;
        for (int i=0; i<B.size(); ++i)
            for(double x : B.get(i))
                A.add(j++, x);


    }

    public static int[] countSort(int[] a, int k){

        int[] c = new int[k+1];

        int[] b = new int[a.length];

        for (int x : a)
            ++c[x+1];

        for (int i=1; i<c.length; ++i)
            c[i] += c[i-1];

        for (int x : a)
            b[c[x]++] = x;

        return b;

    }

    public static <T> T majority(T[] v){

        int c = 0;
        T m = null;

        for (T x : v){
            if(c == 0){
                m = x;
                ++c;
            }
            else if(m == x)
                ++c;
            else
                --c;
        }

        if(c == 0)
            return null;
        else{
            c = 0;
            for (T x : v)
                if(m == x)
                    ++c;
            if( c << 1 > v.length){
                return m;
            }

            else
                return null;
        }


    }

    public static void insertSort(Comparable[] v){

        for(int i=1; i<v.length; i++){

            Comparable key = v[i];

            int j = i - 1;

            while (key.compareTo(v[j]) < 0){

                v[j+1] = v[j];
                if((j--) == 0) break;
            }

            v[j+1] = key;

        }

    }



    public static int climbStairs2(int n) {
        int[] dp = new int[10000];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int climbStairs(int n) {
        int a = 1, b = 1;
        while (--n > 0) {
            b += a;
            a = b - a;
        }
        return b;
    }

    public int climbStairs3(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        return climbStairs3(n-1)+climbStairs3(n-2);
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static int maxSubSequencSum(int[] a){

        int maxSum = Integer.MIN_VALUE;
        int thisSum = 0;

        for(int i=0; i< a.length; i++){
            thisSum += a[i];
            if(thisSum > maxSum){
                maxSum = thisSum;
            }else if(thisSum < 0){
                thisSum = 0;
            }
        }

        return maxSum;

    }


    public void test(int b) {
        int a = 10;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(){
            public void run() {


                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }


    static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2; i*i<n; i++)
            if(n % i == 0) return false;
        return true;
    }





    static int f(){
        try{
            throw new RuntimeException();

        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }

    public static String hexString2binaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000"
                    + Integer.toBinaryString(Integer.parseInt(hexString
                    .substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
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

    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
//            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

    public static void forEachPrint(Comparable[] s){

        for (Comparable c : s){
            System.out.print(c + "\t");
        }

        print();

    }

    public static void forEachPrint(int[] s){

        for (int c : s){
            System.out.print(c + "\t");
        }

        print();

    }

    public static void forEachPrint(double[] s){

        for (double c : s){
            System.out.print(c + "\t");
        }

        print();

    }

    public static <E> void forEachPrint(List<E> list){

        for (E c : list){
            System.out.print(c.toString() + "\t");
        }

        print();

    }


}
