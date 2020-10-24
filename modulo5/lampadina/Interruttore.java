package com.delby;

public class Interruttore {
    private boolean in;

    public Interruttore(){
        in = false;
    }

    public void onoff(Lampadina l, Impianto i){
        in = !in;

        if(l.getNumeroClick() == 0){
            l.setStatoNew(Stato.ROTTA);
        }else{
            l.setStatoNew((in && i.check()) ? Stato.ACCESA : Stato.SPENTA);
            l.setNumeroClick(l.getNumeroClick()-1);
        }
        l.setStatoOld(l.getStatoNew());



    }

}
