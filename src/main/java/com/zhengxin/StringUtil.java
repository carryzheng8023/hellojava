package com.zhengxin;

/**
 * Created by 136931 on 2016/4/27.
 */
public class StringUtil {

    public static void main(String[] args){

        StringUtil stringUtil = new StringUtil();

//        char[] s = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] s = "abcdef".toCharArray();
        for (char t : s){
            System.out.printf(t + "\t");
        }
        System.out.println();
        stringUtil.leftRotateString(s, 6, 2);

        for (char t : s){
            System.out.printf(t + "\t");
        }

        System.out.println();
        System.out.println("-----------------------------------");


        char[] str = "I have a dream".toCharArray();
        for (char t : str){
            System.out.print(t);
        }
        System.out.println();
        stringUtil.removeBlank(str);
        for (char t : str){
            System.out.print(t);
        }



    }

    public void leftRotateString(char[] s, int n, int m){
        m %= n;
        reverseString(s, 0, m-1);
        reverseString(s, m, n - 1);
        reverseString(s, 0, n - 1);
    }

    private void reverseString(char[] s, int from, int to){

        while (from < to){
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;
        }

    }


    public void removeBlank(char[] str){
        int j = 0;

        for(int i=0; i<str.length; i++){
            if(str[i] != ' '){

                if(i != j){
                    str[j] = str[i];
                }

                j++;
            }

        }

    }

}
