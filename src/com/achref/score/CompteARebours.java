package com.achref.score;

public class CompteARebours implements Runnable{

	//**** VARIABLES ****//
	private final int PAUSE = 1000;	
	private int compteurTemps;
	private String str;
	private StringBuffer msg;
	
	
	//**** CONSTRUCTEUR ****//
	public CompteARebours(StringBuffer m){
		this.msg=m;
		this.compteurTemps = 100; 
		this.str = "Temps restant : 100";		
		Thread compteARebours = new Thread(this);
		compteARebours.start();
	}

	
	//**** GETTERS ****//	
	public int getCompteurTemps() {return compteurTemps;}
	
    public String getStr() {return str;}

	
    //**** SETTERS ****//
    
    
    //**** METHODES ****//	
	@Override
	public void run() {				
		while(true){ // boucle infinie											
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			this.compteurTemps--;
			this.str = "Temps restant : " + this.compteurTemps+" mot : "+msg;
		}		
	} 	
}