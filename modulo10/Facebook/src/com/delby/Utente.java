package com.delby;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

public class Utente implements Comparable<Utente> {
    private UUID idUtente;
    private String nome;
    private String cognome;
    private Instant iscrizione;
    private HashSet<Post> listaPost = new HashSet<>();


    public Utente(String nome, String cognome){
        this.idUtente = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        iscrizione = Instant.now();
    }

    public Instant getIscrizione() {
        return iscrizione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void addPost(Post post){
        listaPost.add(post);
    }

    public HashSet<Post> getListaPost() {
        return listaPost;
    }

    @Override
    public String toString() {
        return nome + " " +cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(idUtente, utente.idUtente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtente);
    }

    public UUID getIdUtente() {
        return idUtente;
    }


    @Override
    public int compareTo(Utente o) {
        return iscrizione.compareTo(o.getIscrizione());
    }
}
