package com.delby;

public class Main {

    public static void main(String[] args) {
    //CREO GIOCATORI SQUADRA 1
	Giocatore g1 = new Giocatore(1,"mario", "rossi");
	Giocatore g2 = new Giocatore(2,"luig", "bianchi");
    Giocatore g3 = new Giocatore(3,"giovanni", "verdi");
    Giocatore g4 = new Giocatore(4,"davide", "neri");
    Giocatore g5 = new Giocatore(5,"daniele", "gialli");

    //CREO ARRAY DI TIPO GIOCATORE PER LA SQUADRA 1
    Giocatore[] gS1 = new Giocatore[5];

    //RIEMPIO L'ARRAY CON I GIOCATORI
    gS1[0] = g1;
    gS1[1] = g2;
    gS1[2] = g3;
    gS1[3] = g4;
    gS1[4] = g5;

    //CREO GIOCATORI SQUADRA 2
    Giocatore g6 = new Giocatore(6,"riccardo", "grigi");
    Giocatore g7 = new Giocatore(7,"melvin", "arancio");
    Giocatore g8 = new Giocatore(8,"lorenzo", "viola");
    Giocatore g9 = new Giocatore(9,"francesco", "totti");
    Giocatore g10 = new Giocatore(10,"roberto", "baggio");

    //CREO ARRAY DI TIPO GIOCATORE PER LA SQUADRA 2
    Giocatore[] gS2 = new Giocatore[5];

    //RIEMPIO L'ARRAY CON I GIOCATORI
    gS2[0] = g6;
    gS2[1] = g7;
    gS2[2] = g8;
    gS2[3] = g9;
    gS2[4] = g10;

    //CREO GIOCATORI SQUADRA 3
    Giocatore g11 = new Giocatore(11,"riccardo", "grigi");
    Giocatore g12 = new Giocatore(12,"melvin", "arancio");
    Giocatore g13 = new Giocatore(13,"lorenzo", "viola");
    Giocatore g14 = new Giocatore(14,"francesco", "totti");
    Giocatore g15 = new Giocatore(15,"roberto", "baggio");

    //CREO ARRAY DI TIPO GIOCATORE PER LA SQUADRA 3
    Giocatore[] gS3 = new Giocatore[5];

    //RIEMPIO L'ARRAY CON I GIOCATORI
    gS3[0] = g11;
    gS3[1] = g12;
    gS3[2] = g13;
    gS3[3] = g14;
    gS3[4] = g15;

    //CREO LE SQUADRE 1,2,3
    Squadra s1 = new Squadra(1, "Milan", gS1);
    Squadra s2 = new Squadra(2, "Inter", gS2);
    Squadra s3 = new Squadra(3, "Juve", gS3);

    //CREO LA CLASSIFICA (MAX 20 SQUADRE)
    Classifica c = new Classifica();

    //AGGIUNGO LE SQUADRE ALLA CLASSIFICA
    c.addSquadra(s1);
    c.addSquadra(s2);
    c.addSquadra(s3);

    //PARTITE DI ANDATA
    c.esitoPartita(s1, 2, s2, 1);
    c.esitoPartita(s2, 2, s3, 5);
    c.esitoPartita(s3, 3, s1, 2);

    //PARTITE DI RITORNO
    c.esitoPartita(s2, 1, s1, 1);
    c.esitoPartita(s3, 3, s2, 2);
    c.esitoPartita(s1, 5, s3, 4);

    //STAMPO LA CLASSIFICA (DALLA PRIMA POSIZIONE ALL'ULTIMA POSIZIONE)
    System.out.println("Classifica");
    for(int i=0; i<c.getClassifica().length; i++){
        if(c.getClassifica()[i] == null)
            continue;
        System.out.print(c.getClassifica()[i].getNome()+": ");
        System.out.println(c.getClassifica()[i].getPunti()+" punti");
    }

    //STAMPO LA SQUADRA CON IL MIGLIOR ATTACCO E LA SQUADRA CON LA MIGLIOR DIFESA
    System.out.println();
    System.out.println("Miglior squadra in attacco: "+c.getMigliorAttacco().getNome()+" - "+c.getMigliorAttacco().getGolFatti()+" gol fatti");
    System.out.println("Peggior squadra in difesa: "+c.getPeggiorDifesa().getNome()+" - "+c.getPeggiorDifesa().getGolSubiti()+" gol subiti");

    }
}
