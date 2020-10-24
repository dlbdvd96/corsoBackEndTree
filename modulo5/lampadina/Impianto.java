package com.delby;

public class Impianto {
    private boolean corrente;

    public Impianto(){
        this.corrente = true;
    }

    public void staccaLaCorrente(){
        corrente = false;
    }

    public void attaccaLaCorrente(){
        corrente = true;
    }

    protected boolean check(){
        return corrente;
    }
}
