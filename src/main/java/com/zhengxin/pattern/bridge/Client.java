package com.zhengxin.pattern.bridge;

/**
 * Created by 136931 on 2016/2/25.
 * 桥接模式
 */
public class Client {

    public static void main(String[] args){
        HandsetBrand handsetBrand = null;

        handsetBrand = new HandsetBrandM();
        handsetBrand.setHandsetSoft(new HandsetAddress());
        handsetBrand.run();
        handsetBrand.setHandsetSoft(new HandsetGame());
        handsetBrand.run();

        handsetBrand = new HandsetBrandN();
        handsetBrand.setHandsetSoft(new HandsetAddress());
        handsetBrand.run();
        handsetBrand.setHandsetSoft(new HandsetGame());
        handsetBrand.run();



    }



}
