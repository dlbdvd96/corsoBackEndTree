package com.delby;

public class Classifica {
    private Squadra[] squadre = new Squadra[5];
    private int contatoreSquadre = 0;

    //COSTRUTTORE VUOTO
    public Classifica(){
    }

    //AGGIUNGO UNA SQUADRA ALLA CLASSIFICA
    public void addSquadra(Squadra squadra){
        this.squadre[contatoreSquadre] = squadra;
        contatoreSquadre++;
    }

    //AGGIORNO I PUNTI DELLE SQUADRE IN BASE AL PUNTEGGIO, AGGIORNO GOL FATTI E GOL SUBITI
    public void esitoPartita(Squadra squadraCasa, int golCasa, Squadra squadraOspite, int golOspite){
        if(golCasa > golOspite){
            squadraCasa.addPunti(3);
        }
        if(golOspite > golCasa){
            squadraOspite.addPunti(3);
        }
        if(golCasa == golOspite){
            squadraCasa.addPunti(1);
            squadraOspite.addPunti(1);
        }
        squadraCasa.addGolFatti(golCasa);
        squadraCasa.addGolSubiti(golOspite);
        squadraOspite.addGolFatti(golOspite);
        squadraOspite.addGolSubiti(golCasa);

        squadre = sort(squadre);
    }

    //RITORNA ARRAY DI SQUADRE IN ORDINE DI PUNTEGGIO
    public Squadra[] getClassifica(){
        return squadre;
    }

    //RITORNA LA SQUADRA CON IL MAGGIOR NUMERO DI GOL FATTI
    public Squadra getMigliorAttacco(){
        Squadra maxAttack = squadre[0];
        for(int i=1; i<contatoreSquadre; i++){
            if(squadre[i].getGolFatti() > maxAttack.getGolFatti())
                maxAttack = squadre[i];
        }

        return maxAttack;
    }

    //RITORNA LA SQUADRA CON IL MAGGIOR NUMERO DI GOL SUBITI
    public Squadra getPeggiorDifesa(){
        Squadra minDif = squadre[0];
        for(int i=1; i<contatoreSquadre; i++){
            if(squadre[i].getGolSubiti() > minDif.getGolSubiti())
                minDif = squadre[i];
        }

        return minDif;
    }

    //MERGE SORT ADATTATO PER UN ARRAY DI SQUADRE
    private Squadra[] sort(Squadra[] array) {

        if(array.length == 1)
            return array;

        int centro = array.length/2;

        Squadra[] sinistra = split(array, 0, centro);
        Squadra[] destra = split(array, centro, array.length);
        sinistra = sort(sinistra);
        destra = sort(destra);

        return merge(destra, sinistra);
    }

    private Squadra[] split(Squadra[] arr, int inizio, int fine){
        Squadra[] splittato = new Squadra[fine-inizio];
        int j = 0;
        for(int i=inizio; i<fine; i++){
            splittato[j] = arr[i];
            j++;
        }
        return splittato;
    }

    //BISOGNA FARE ATTENZIONE SE L'ARRAY NON E' COMPLETAMENTE PIENO: IN QUEL CASO ALCUNI ELEMENTI SARANNO null
    private Squadra[] merge(Squadra[] destra, Squadra[] sinistra){
        Squadra[] array = new Squadra[destra.length + sinistra.length];
        int i = 0;
        int j = 0;
        while(i< sinistra.length && j< destra.length){

            //CASO IN CUI SOLO L'ELEMENTO DELL'ARRAY DI DESTRA E' null
            if(sinistra[i] != null && destra[j] == null){
                array[i+j] = sinistra[i];
                i++;
                continue;
            }

            //CASO IN CUI GLI ELEMENTI DELL'ARRAY DI DESTRA E DI SINISTRA SONO null
            if(sinistra[i] == null && destra[j] == null){
                break;
            }

            //CASO IN CUI GLI ELEMENTI DELL'ARRAY DI DESTRA E DI SINISTRA SONO VALIDI
            if(sinistra[i] != null && destra[j] != null) {
                if (sinistra[i].getPunti() > destra[j].getPunti()) {
                    array[i + j] = sinistra[i];
                    i++;
                } else {
                    array[i + j] = destra[j];
                    j++;
                }
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