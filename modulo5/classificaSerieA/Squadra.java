package com.delby;

public class Squadra {
    private final int id;
    private final String nome;
    private Giocatore[] rosa;
    private int punti;
    private int golFatti;
    private int golSubiti;

    public Squadra(int id, String nome, Giocatore[] rosa){
        this.id = id;
        this.nome = nome;
        this.rosa = rosa;
        this.punti = 0;
        this.golFatti = 0;
        this.golSubiti = 0;
    }

    public void addPunti(int punti){
        this.punti += punti;
    }

    public int getPunti(){
        return this.punti;
    }

    public void addGolFatti(int golFatti){
        this.golFatti += golFatti;
    }

    public int getGolFatti() {
        return golFatti;
    }

    public void addGolSubiti(int golSubiti){
        this.golSubiti += golSubiti;
    }

    public int getGolSubiti() {
        return golSubiti;
    }

    public String getNome(){
        return this.nome;
    }

}
