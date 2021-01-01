package com.achref.bins;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Alphabet extends Objet implements Runnable{
	
	//**** VARIABLES ****//
	private int compteur;
	private final int PAUSE = 15; //temps d'attente entre 2 tours de boucle
	private String A;
	
	//**** CONSTRUCTEUR	****//
    public Alphabet(int x, int y, String a){
    	
	    super(x, y, 30, 30);    
	    this.A=a;
	    super.icoObjet = new ImageIcon(getClass().getResource("/images/"+A+".png"));
	    super.imgObjet = super.icoObjet.getImage();
	   
    }


    //**** GETTERS ****//		

     public String getChar() {
    	 return A;
     }
    //**** SETTERS ****//


    //**** METHODES ****//
    public Image bouge(){ // Mouvement de la pièce       	
    	String str;
    	ImageIcon ico;
		Image img;
			
        this.compteur++;
		if (this.compteur / 100 == 0) {str = "/images/"+A+".png";}
		else{str = "/images/Aa.png";}							    
		if (this.compteur == 200) {this.compteur = 0;}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;   	
	}


	@Override
	public void run() {
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient complètement créés
		catch (InterruptedException e){}					
		while(true){ // boucle infinie											
			this.bouge();
			try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}			
	}
}