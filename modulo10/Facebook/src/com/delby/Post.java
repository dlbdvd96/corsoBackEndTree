package com.delby;

import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

public class Post {
    private UUID idPost;
    private String content;
    private TreeMap<UUID, TreeSet<String>> commenti = new TreeMap<>();



    public Post(String content){
        idPost = UUID.randomUUID();
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    public void commentaPost(Utente utente, String commento){
        if(!commenti.containsKey(utente.getIdUtente()))
            commenti.put(utente.getIdUtente(), new TreeSet<>());

        commenti.get(utente.getIdUtente()).add(commento);
    }


    public TreeMap<UUID, TreeSet<String>> getCommentiPost() {
        return commenti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(idPost, post.idPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPost);
    }
}
