package com.delby;

import java.util.*;

public class Facebook {
    private HashMap<Utente, HashSet<UUID>> utentiConAmici = new HashMap<>();

    public Facebook(){

    }

    public void addUtente(Utente utente){
        if(!utentiConAmici.containsKey(utente)){
            utentiConAmici.put(utente, new HashSet<>());
        }

    }

    public void addAmico(Utente utente, Utente amico){
        if(utentiConAmici.containsKey(utente)){
            utentiConAmici.get(utente).add(amico.getIdUtente());
            utentiConAmici.get(amico).add(utente.getIdUtente());
        }

    }

    public void removeAmico(Utente utente, Utente amico){
        if(utentiConAmici.containsKey(utente)){
            utentiConAmici.get(utente).remove(amico.getIdUtente());
            utentiConAmici.get(amico).remove(utente.getIdUtente());
        }

    }

    public void changeName(Utente utente, String newNome, String newCognome){
            for (Utente u : utentiConAmici.keySet()) {
                if(u.equals(utente)){
                    u.setNome(newNome);
                    u.setCognome(newCognome);
                }
            }
    }

    public void addPost(Utente utente, Post post){
        for (Utente u : utentiConAmici.keySet()) {
            if(u.equals(utente))
                u.addPost(post);
        }
    }

    public HashSet<Post> getPostUtenti(Utente utente) {
        for (Utente u : utentiConAmici.keySet()) {
            if(u.equals(utente))
                return u.getListaPost();
        }
        return null;
    }

    public void addCommento(Post post, Utente utente, String commento){
            post.commentaPost(utente, commento);
    }

    public TreeSet<String> getCommenti(Utente utente){
        for (Utente u : utentiConAmici.keySet()) {
            for (Post p : u.getListaPost()) {
                if(p.getCommentiPost().containsKey(utente.getIdUtente()))
                    return p.getCommentiPost().get(utente.getIdUtente());
            }
        }
        return null;
    }

    public String getUtentiConAmici(Utente utente) {
        StringBuilder s = new StringBuilder();
        for(UUID idUtente: utentiConAmici.get(utente))
            for (Utente u : utentiConAmici.keySet()) {
                if(u.getIdUtente().equals(idUtente))
                    s.append(utente).append(": ").append(u);
            }

            return s.toString();
    }

    public TreeSet<Utente> getUtentiConAmici() {
        TreeSet<Utente> utenti = new TreeSet<>(utentiConAmici.keySet());

        return utenti;
    }
}
