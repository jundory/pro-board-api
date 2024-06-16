package com.example.board_api;

public class Test1 {

    public static void main(String[] args) {
//        String test = "hello";
//        String test2 = test;
        int[] arrData = {1,2,3};
        int[] arrData2 = arrData;

        arrData2[0] = 10;
        System.out.println(arrData[0]); // 10
//        System.out.println(arrData.equals(arrData2));
    }
}
