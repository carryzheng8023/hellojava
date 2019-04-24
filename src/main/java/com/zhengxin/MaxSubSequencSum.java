package com.zhengxin;

/**
 * @author zhengxin
 * @date 2018-03-20 16:15:25
 */
public class MaxSubSequencSum {


    static int cross_middle(int[] a,int l,int m,int r){
        int i, sum=0, l_max=Integer.MIN_VALUE, r_max=Integer.MIN_VALUE;
        for(i=m;i>=l;i--){
            sum+=a[i];
            if(sum > l_max) l_max=sum;
        }
        sum=0;
        for(i=m+1;i<=r;i++){//最早i=m,出现BUG
            sum+=a[i];
            if(sum>r_max) r_max=sum;
        }
        return (l_max+r_max);
    }

    static int maxsubset(int[] a,int l,int r){
        if(l == r) return a[l];
        //if(l>r) return 0;

        int m = (l+r) >> 1, l_max=Integer.MIN_VALUE, r_max=Integer.MIN_VALUE, c_max=Integer.MIN_VALUE;
        l_max=maxsubset(a,l,m);
        r_max=maxsubset(a,m+1,r);
        c_max=cross_middle(a,l,m,r);
        if(l_max >= r_max&&l_max >= c_max) return l_max;
        else if(r_max >= l_max&&r_max >= c_max) return r_max;
        else return c_max;
    }

    public static void main(String[] args){

        int[] a = {3,-1,2,5,-3,4,-6,-7,1,8,-3,5,9};

        System.out.println(maxsubset(a,0,12));

    }

}
