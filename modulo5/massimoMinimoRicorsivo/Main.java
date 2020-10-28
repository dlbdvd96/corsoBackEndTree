package com.delby;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {40,-90,130,2000,60,2,1900,20};
        int[] MM = new int[2];
        int i = 0;
        System.out.println(Arrays.toString(maxmin(array,MM, i)));

    }

    static int[] maxmin(int[] array, int[] MM, int i) {

        if(i==array.length-1){
            return MM;
        }

        if(i==0){
            MM[0] = array[i];
            MM[1] = array[i];
        }

        if(array[i]<MM[0])
            MM[0] = array[i];

        if(array[i]>MM[1]){
            MM[1] = array[i];
        }

        i++;
        MM = maxmin(array, MM, i);

        return MM;
    }


}
