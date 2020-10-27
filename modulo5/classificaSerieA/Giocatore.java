package com.delby;

public class Giocatore {
    private final int id;
    private final String nome;
    private final String cognome;

    public Giocatore(int id, String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }
}
