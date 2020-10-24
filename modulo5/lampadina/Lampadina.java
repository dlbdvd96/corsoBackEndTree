package com.delby;

public class Lampadina {
    private Stato statoNew;
    private Stato statoOld;
    private int numeroClick;

    public Lampadina(int nClick){
        statoNew = Stato.SPENTA;
        statoOld = statoNew;
        this.numeroClick = nClick;
    }

    public Stato stato(Impianto i){
        if(i.check()){
            statoNew = statoOld;
        }else{
            if(statoNew == Stato.ACCESA)
                statoOld = statoNew;

            statoNew = (numeroClick == 0) ? Stato.ROTTA : Stato.SPENTA;
        }
        return statoNew;
    }

    protected Stato getStatoNew(){
        return statoNew;
    }

    protected Stato getStatoOld(){
        return statoOld;
    }

    protected void setStatoNew(Stato statoNew){
        this.statoNew = statoNew;
    }

    protected void setStatoOld(Stato statoOld){
        this.statoOld = statoOld;
    }

    protected int getNumeroClick(){
        return numeroClick;
    }

    public void setNumeroClick(int numeroClick){
        this.numeroClick = numeroClick;
    }

}
