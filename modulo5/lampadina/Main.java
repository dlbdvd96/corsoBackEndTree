package com.delby;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Impianto i = new Impianto();
    	Interruttore i1 = new Interruttore();
		Interruttore i2 = new Interruttore();
		Lampadina l1 = new Lampadina(10);
		Lampadina l2 = new Lampadina(10);
		Scanner input = new Scanner(System.in);
		int scelta;
		System.out.println("Stato iniziale Lampadina 1: "+l1.stato(i));
		System.out.println("Stato iniziale Lampadina 2: "+l2.stato(i));
		System.out.println();

		while (true){
			System.out.println("1) ON/OFF INTERRUTTORE 1");
			System.out.println("2) ON/OFF INTERRUTTORE 2");
			System.out.println("3) STACCA IMPIANTO DELLA CORRENTE");
			System.out.println("4) ATTACCA IMPIANTO DELLA CORRENTE");
			System.out.println("5) ESCI");
			System.out.print("Scelta: ");

			scelta = input.nextInt();
			if(scelta == 1) {
				i1.onoff(l1, i);
			}else if(scelta == 2) {
				i2.onoff(l2, i);
			}else if(scelta == 3){
				i.staccaLaCorrente();
			}else if(scelta == 4){
				i.attaccaLaCorrente();
			}else if(scelta == 5){
				break;
			}
			System.out.println("Lampadina 1: "+l1.stato(i));
			System.out.println("Lampadina 2: "+l2.stato(i));
			System.out.println();
		}
    }
}
