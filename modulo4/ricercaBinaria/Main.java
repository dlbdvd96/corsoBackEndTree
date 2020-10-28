package com.delby;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("inserisci la n: ");

        Scanner input = new Scanner (System.in);

        int n = input.nextInt();

        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

        //int [] array = new int [10];

       /* for(int i = 0; i< array.length;i++) {
            System.out.print("inserisci elemento dell'array: ");
            array[i] = input.nextInt();
        }*/
        int fine = array.length;
        int inizio = 0;
        System.out.println("Posizione: "+trova(array,n, inizio, fine));

    }

    static int trova (int []array ,int n, int inizio, int fine) {

        int centro = inizio + (fine-inizio)/2;

        if (centro == inizio || centro == fine) {
            return -1;
        }

        if(array[centro] == n){
            return centro;
        }else{
            if(array[centro]>n){
                return trova(array, n, inizio, centro);
            }else{
                return trova(array, n, centro, fine);
            }
        }

    }


    /*
        if(i >= array.length) {
            return -1;
        }


        if(array[i]==n) {

            return i;
        }

        else {
            i++;
            return trova( array , n, i);

        }


         */

		/*
		for(int i = 0; i < array.length;i++) {
			if(array[i] == n) {
				return i;

		}
		}


				return -1;

		}

	*/


}
