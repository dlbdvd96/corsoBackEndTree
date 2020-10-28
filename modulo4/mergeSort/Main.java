package com.delby;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            int[] array = {4,2,54};

            System.out.println("Array ordinato: "+ Arrays.toString(trova(array)));
        }

        static int[] trova (int[] array) {

            if(array.length == 1)
                return array;

                int centro = array.length/2;

                int[] sinistra = split(array, 0, centro);
                int[] destra = split(array, centro, array.length);
                sinistra = trova(sinistra);
                destra = trova(destra);


            return merge(destra, sinistra);
        }

        static int[] split(int[] arr, int inizio, int fine){
            int[] splittato = new int[fine-inizio];
            int j = 0;
            for(int i=inizio; i<fine; i++){
                splittato[j] = arr[i];
                j++;
            }
            return splittato;
        }

        static int[] merge(int[] destra, int[] sinistra){
            int[] array = new int[destra.length + sinistra.length];
            int i = 0;
            int j = 0;
            while(i< sinistra.length && j< destra.length){
                if(sinistra[i]< destra[j]){
                    array[i+j] = sinistra[i];
                    i++;
                }else{
                    array[i+j] = destra[j];
                    j++;
                }
            }

            while (i< sinistra.length){
                array[i+j] = sinistra[i];
                i++;
            }

            while (j< destra.length){
                array[i+j] = destra[j];
                j++;
            }
            return array;

        }
    }
