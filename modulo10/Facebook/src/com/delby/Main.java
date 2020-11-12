package com.delby;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	Facebook fb = new Facebook();

	Utente u1 = new Utente("Davide1", "dB");
        fb.addUtente(u1);
        System.out.println(fb.getUtentiConAmici());

        Utente u2 = new Utente("Carlo2", "pC");
        fb.addUtente(u2);
        System.out.println(fb.getUtentiConAmici());
        //Thread.sleep(100);
        Utente u3 = new Utente("Marco3", "pD");
        fb.addUtente(u3);
        System.out.println(fb.getUtentiConAmici());

        Utente u4 = new Utente("Sara4", "pE");

    fb.addUtente(u4);

        System.out.println(fb.getUtentiConAmici());


	fb.addAmico(u1, u2);

        //System.out.println(fb.getUtentiConAmici(u2));

	//fb.changeName(u1, "Marco", "Ciav");

        //System.out.println(fb.getUtentiConAmici(u2));

     Post p = new Post("Buongiornissimo");
		Post p2 = new Post("Buona notte");

    fb.addPost(u1, p);
    fb.addPost(u1, p2);

    fb.addCommento(p, u1, "Anche a te");
    fb.addCommento(p, u2, "Vai a lavorare");

		//System.out.println(fb.getPostUtenti(u1));

		//System.out.println(fb.getCommenti(u2));

    }
}
