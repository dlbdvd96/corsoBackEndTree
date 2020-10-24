package com.delby;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] lab = new char[5][5];
        char[] elem = {'-', 'W'};

        Random rand = new Random();

        int w = rand.nextInt(lab.length);
        int z = rand.nextInt(lab[0].length);
        int m;
        int n;
        lab[w][z] = 'P';
        do{
            m = rand.nextInt(lab.length);
            n = rand.nextInt(lab[0].length);
        }while(w==m && z==n);

        lab[m][n] = 'E';

        for (int i = 0; i<lab.length; i++){
            for (int j = 0; j<lab.length; j++){
                int r = rand.nextInt(elem.length);
                if((i!=w || j!=z) && (i!=m || j!=n))
                    lab[i][j] = elem[r];
            }
        }


        //char[][] lab = {{'-', '-', 'W', 'W', '-'}, {'-', 'W', '-', 'W', '-'}, {'P', 'W', '-', 'W', 'W'}, {'-', '-', 'W', '-', 'E'}, {'W', '-', '-', '-', 'W'}};


	    Scanner muovi = new Scanner(System.in);
        String mossa = "";

        boolean nonVinto = true;

        do{
            lab = stampaLab(lab, mossa);
            nonVinto = checkVinto(lab, nonVinto);
            if(nonVinto == false){
                System.out.print("Hai vinto!");
                break;
            }
            System.out.print("Muovi: ");
            mossa = muovi.nextLine();
        }while (nonVinto);
    }

    public static boolean checkVinto(char[][] lab, boolean nonVinto){
        int count = 0;
        for(int i = 0; i< lab.length; i++){
            for(int j = 0; j<lab[0].length; j++){
                if(lab[i][j] == 'E')
                    count++;
            }
        }
        if(count == 0){
            nonVinto = false;
        }

        return nonVinto;
    }

    public static char[][] stampaLab(char[][] lab, String mossa){

        int[] xy = trovaPosizione(lab);

        char[][] labNew = muoviti(lab, xy, mossa);



        for(int i = 0; i< labNew.length; i++){
            for(int j = 0; j<labNew[0].length; j++){
                System.out.print(labNew[i][j]);
            }
            System.out.println();
        }

        return labNew;

    }

    public static int[] trovaPosizione(char[][] lab){
        int[] xy = new int[2];
        for(int i = 0; i< lab.length; i++){
            for(int j = 0; j<lab[0].length; j++){
                if(lab[i][j] == 'P'){
                    xy[0] = i;
                    xy[1] = j;
                    return xy;
                }
            }
        }
        return xy;
    }

    public static char[][] muoviti(char[][] lab, int[] xy, String mossa){
        if(xy[0]-1 >= 0) {
            if (mossa.equals("W") && (lab[xy[0] - 1][xy[1]] == '-' || lab[xy[0] - 1][xy[1]] == 'E')) {
                lab[xy[0]][xy[1]] = '-';
                lab[xy[0] - 1][xy[1]] = 'P';
            }
        }
        if(xy[0]+1<lab.length) {
            if (mossa.equals("S") && (lab[xy[0] + 1][xy[1]] == '-' || lab[xy[0] + 1][xy[1]] == 'E')) {
                lab[xy[0]][xy[1]] = '-';
                lab[xy[0] + 1][xy[1]] = 'P';
            }
        }

        if(xy[1]-1 >= 0) {
            if (mossa.equals("A") && (lab[xy[0]][xy[1] - 1] == '-' || lab[xy[0]][xy[1] - 1] == 'E')) {
                lab[xy[0]][xy[1]] = '-';
                lab[xy[0]][xy[1] - 1] = 'P';
            }

        }
        if(xy[1]+1<lab[0].length) {
            if (mossa.equals("D") && (lab[xy[0]][xy[1] + 1] == '-' || lab[xy[0]][xy[1] + 1] == 'E')) {
                lab[xy[0]][xy[1]] = '-';
                lab[xy[0]][xy[1] + 1] = 'P';
            }
        }
        return lab;
    }

}
