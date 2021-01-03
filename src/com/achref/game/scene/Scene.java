package com.achref.game.scene;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.achref.bins.Bloc;
import com.achref.bins.Objet;
import com.achref.bins.Alphabet;
import com.achref.bins.Obstacle;
import com.achref.liste.chainee.Maillon;
import com.achref.p.Hero;
import com.achref.p.Enemie;
import com.achref.score.CompteARebours;
import com.achref.score.Score;
import com.achref.son.Audio;


//***** Moteur de l'application /La classe Scene est le classe la plus importante de l'application. *****//

@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	
	//**** VARIABLES **//
	private Maillon l;
	private String ch="";
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;  
	private Image imgChateau1;  
	private ImageIcon icoDepart;  
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;   
	private int xPos; // position absolue dans le jeu
	private int ySol; // hauteur courante du sol
	private int hauteurPlafond; // hauteur courante du plafond
	private boolean ok;
	public Hero hero;
	private int terminer = 0 ;
	
	public Obstacle obstacle1;
	public Obstacle obstacle2;
	public Obstacle obstacle3;
	public Obstacle obstacle4;
	public Obstacle obstacle5;
	public Obstacle obstacle6;
	public Obstacle obstacle7;
	public Obstacle obstacle8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	public Alphabet piece1;
	public Alphabet piece2;
	public Alphabet piece3;
	public Alphabet piece4;
	public Alphabet piece5;
	public Alphabet piece6;
	public Alphabet piece7;
	public Alphabet piece8;
	public Alphabet piece9;
	public Alphabet piece10;
	

	
	public Enemie enemie1;
	public Enemie enemie2;
	public Enemie enemie3;
	public Enemie enemie4;
	public Enemie enemie5;
	public Enemie enemie6;
	public Enemie enemie7;
	public Enemie enemie8;
	public Enemie enemie9;
	public Enemie	enemie10; 
	public Enemie enemie11 ;
	public Enemie	enemie12 ;
	public Enemie	enemie13 ;
	public Enemie	enemie14 ;
	public Enemie	enemie15;
	public Enemie	enemie16;
	public Enemie	enemie17;  
	
	
	private ArrayList<Objet> tabObjets; // tableau qui enregistre tous les objets du jeu
	
	private ArrayList<Enemie> enemies; // tableau qui enregistre toutes les enemies du jeu*
	private ArrayList<String> abb;
	//private ArrayList<Champ> tabChamps; // tableau qui enregistre tous les champignons du jeu
	private StringBuffer m,s;
	private Score score;
	private Font police;
	private CompteARebours compteARebours;
	private String map;
	
	//**** CONSTRUCTEUR ****//	
	private boolean Verif(StringBuffer ch)
	{
		String ch1 ="ISMA";
		for (int i = 0; i < ch.length(); i++) {
			if (ch1.indexOf(ch.charAt(i))==-1 )
			{
				return false ;
			}
			
		}
		return true;
	}
	public Scene(){
		
		super();
		abb = new ArrayList<String>();
		do {
			 map = JOptionPane.showInputDialog("choisissez vous map 1 ou 2 (1/2)");
			}
			while(!map.equals("1") && !map.equals("2"));
		
		do {
		 m = new StringBuffer(JOptionPane.showInputDialog("Super Hero est un jeu de plateforme qui met en scène:\r\n" + 
		 		"-un joueur qui doit traverser de nombreux ennemis pour les éliminer\r\n" + 
		 		"-ramasser l'alphabets pour trouver le mot initialement entré au debut du jeu \r\n" + 
		 		"  \r\n" + 
		 		"****************\r\n" + 
		 		"guide de jeu \r\n" + 
		 		"****************\r\n" + 
		 		"1)en premier lieu le jour doit choisir une map pour jouer (deux maps disponible 1 ou 2)\r\n" + 
		 		"2)en deuxième lieu le joueur doit entrer un mot pour le trouvai , le mot\r\n" + 
		 		"  doit etre composé seulement par des léttres appartient a cette intervale (ISAM)\r\n" + 
		 		"3) Le jeu commence, pour gagner il faut trouver le mot qui a été entré au début et éliminer les ennemis tout en respectant le temps"
		 		+ "\n             *********** entrer le mot qui doit etre de longeur <=5********").toUpperCase());
		}
		while(m.isEmpty() || !Verif(m));
		for (int i = 0; i < m.length(); i++) {
			System.out.println(i);
			ch=ch+"-";
			abb.add(m.charAt(i)+"");
		
	
		}
		//String x= abb.toString();
		System.out.println(ch);
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.hauteurPlafond = 0;
		this.ok = true;
		if(map.equals("1"))
		{
			icoFond = new ImageIcon(getClass().getResource("/images/L.jpg"));
		}
		else  
		{
			icoFond = new ImageIcon(getClass().getResource("/images/C.jpg"));
		}
		//icoFond = new ImageIcon(getClass().getResource("/images/L.jpg"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
	
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/panzer.png")); 
		this.imgChateau1 = this.icoChateau1.getImage();  
		
		hero = new Hero(300, 240);
	
		obstacle1 = new Obstacle(600, 230);
		obstacle2 = new Obstacle(1000, 230);
		obstacle3 = new Obstacle(1600, 230);
		obstacle4 = new Obstacle(1900, 230);
		obstacle5 = new Obstacle(2500, 230);
		obstacle6 = new Obstacle(3000, 230);
		obstacle7 = new Obstacle(3800, 230);
		obstacle8 = new Obstacle(4500, 230);
		
		bloc1 = new Bloc(375, 175);
		bloc2 = new Bloc(1880, 180);
		bloc3 = new Bloc(1250, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3500, 160);
		bloc9 = new Bloc(3550, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
		piece1 = new Alphabet(402, 145,"A");
		piece2 = new Alphabet(1202, 140,"I");
		piece3 = new Alphabet(1272, 95,"M");
		piece4 = new Alphabet(1342, 40,"S");
		piece5 = new Alphabet(1650, 145,"S");
		piece6 = new Alphabet(2650, 145,"I");
		piece7 = new Alphabet(3000, 135,"S");
		piece8 = new Alphabet(3400, 125,"A");
		piece9 = new Alphabet(4200, 145,"M");
		piece10 = new Alphabet(4600, 40,"R");
		
		
		
		
		//----------------------------------------------
		//ajouter les alphabets  la liste chainee 
		Maillon.ajouterALaFin(piece1);
		Maillon.ajouterALaFin(piece2);
		Maillon.ajouterALaFin(piece3);
		Maillon.ajouterALaFin(piece4);
		Maillon.ajouterALaFin(piece5);
		Maillon.ajouterALaFin(piece6);
		Maillon.ajouterALaFin(piece7);
		Maillon.ajouterALaFin(piece8);
		Maillon.ajouterALaFin(piece9);
		Maillon.ajouterALaFin(piece10);
		
System.out.println("affichage de la liste des alphabets dans la scene selon l'ordre  \n (affichage de la liste chainee ) ");	
		Maillon.afficheListe();
		
System.out.println("-----------------------------------------------------------------------------------------------------");


		//-----------------------------------------------
		

		enemie11 = new Enemie(1100, 243);
		enemie12 = new Enemie(2100, 243);
		enemie13 = new Enemie(2400, 243);
		enemie14 = new Enemie(3200, 243);
		enemie15= new Enemie(3500, 243);
		enemie16 = new Enemie(3700, 243);
		enemie17 = new Enemie(4500, 243);
		
		enemie1 = new Enemie(950, 243);
		enemie2 = new Enemie(1500, 243);
		enemie3 = new Enemie(1800, 243);
		enemie4 = new Enemie(2400, 243);
		enemie5 = new Enemie(3100, 243);
		enemie6 = new Enemie(3600, 243);
		enemie7 = new Enemie(3900, 243);
		enemie8 = new Enemie(4200, 243);
		enemie9 = new Enemie(4400, 243);
 
		
		tabObjets = new ArrayList<Objet>();			
		this.tabObjets.add(this.obstacle1);
		this.tabObjets.add(this.obstacle2);
		this.tabObjets.add(this.obstacle3);
		this.tabObjets.add(this.obstacle4);
		this.tabObjets.add(this.obstacle5);
		this.tabObjets.add(this.obstacle6);
		this.tabObjets.add(this.obstacle7);
		this.tabObjets.add(this.obstacle8);
		
		this.tabObjets.add(this.bloc1);
		this.tabObjets.add(this.bloc2);
		this.tabObjets.add(this.bloc3);
		this.tabObjets.add(this.bloc4);
		this.tabObjets.add(this.bloc5);
		this.tabObjets.add(this.bloc6);
		this.tabObjets.add(this.bloc7);
		this.tabObjets.add(this.bloc8);
		this.tabObjets.add(this.bloc9);
		this.tabObjets.add(this.bloc10);
		this.tabObjets.add(this.bloc11);
		this.tabObjets.add(this.bloc12);
			
		
		

		
		enemies = new ArrayList<Enemie>();
		this.enemies.add(this.enemie1);
		this.enemies.add(this.enemie2);
		this.enemies.add(this.enemie3);
		this.enemies.add(this.enemie4);
		this.enemies.add(this.enemie5);
		this.enemies.add(this.enemie6);
		this.enemies.add(this.enemie7);
		this.enemies.add(this.enemie8);
		this.enemies.add(this.enemie9);
	
		this.enemies.add(this.enemie11);
		this.enemies.add(this.enemie12);
		this.enemies.add(this.enemie13);
		this.enemies.add(this.enemie14);
		this.enemies.add(this.enemie15);
		this.enemies.add(this.enemie16);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		score = new Score();
		police = new Font("Arial", Font.PLAIN, 18);
		compteARebours = new CompteARebours(m);
				
		Thread chronoEcran = new Thread(new Timeur());
		chronoEcran.start();
	}
	
	
	//**** GETTERS ****//	
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHautPlafond(){return hauteurPlafond;}


	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}


	//**** METHODES ****//
	public void deplacementFond(){ // Déplacement des images "fixes" de l'écran simulant le déplacement de hero 

		if(this.xPos >= 0 && this.xPos <= 4430){
			// Mise à jour des positions des éléments du jeu lors du déplacement de hero
			this.xPos = this.xPos + this.dx;		
		    this.xFond1 = this.xFond1 - this.dx;
		    this.xFond2 = this.xFond2 - this.dx;
		}
		// Permanence du fond d'écran
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
	}

	private boolean partieGagnee(){		
		if(this.compteARebours.getCompteurTemps() > 0 && this.hero.isVivant() == true && this.score.getNbrePieces() ==  m.length()
			){
			if(this.ok == true){
				Audio.playSound("/audio/partieGagnee.wav");
			      System.out.println("g2");
				this.ok = false;
			}
			return true;
		}else{return false;}
	}
	
	private boolean partiePerdue(){
		if(this.hero.isVivant() == false || this.compteARebours.getCompteurTemps() <= 0){return true;}
		else{return false;}
	}
		
	public boolean finDePartie(){
		if(this.partieGagnee() == true || this.partiePerdue() == true){return true;}
		else{return false;}
	}
	
	
	public void paintComponent(Graphics g) { // Dessin de toutes les images visibles à l'écran (appel toutes les 3 ms environ)
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;

		// Détections des contacts avec des objets
		for(int i = 0; i < this.tabObjets.size(); i++){
		    // hero
		    if(this.hero.proche(this.tabObjets.get(i))){this.hero.contact(this.tabObjets.get(i));}
		
 		    // enemies
 		    for(int j = 0; j < this.enemies.size(); j++){
 			  if(this.enemies.get(j).proche(this.tabObjets.get(i))){this.enemies.get(j).contact(this.tabObjets.get(i));} 
 		    }
		}
		
    	// Détection des contacts de hero avec alpha
	     StringBuffer s = new StringBuffer(m);
	     
	     //le variable  l prend le premier element de l liste 
	    l= Maillon.getPremier();
 	 	while(l!=null){
 	 		if(this.hero.proche(l.getValeur())){
 	 			if(this.hero.contactPiece(l.getValeur())){
 	 				Audio.playSound("/audio/piece.wav");
 	 				System.out.println(l.getValeur()+"dsdsd");
 	 				int x = s.indexOf(l.getValeur().getChar());
 	 				if(x>-1)
 	 				{
 	 					System.out.println(s.indexOf(l.getValeur().getChar()));
 	 	 				 s.replace(s.indexOf(l.getValeur().getChar()), s.indexOf(l.getValeur().getChar())+1, "-");
 	 	 				 m=s;
 	 	 				 System.out.println(s);
 	 	 				this.score.setNbrePieces(this.score.getNbrePieces() + 1);
 	 				}
 	 				//supprimer un element de la liste chainee 
 	 				l.setPremier(l.supprimeElement(Maillon.getPremier(), l.getValeur()));
 	 				
 	 				
 	 			}
 	 	    }
 	 		l=l.getSuivant();
 	 	}
		
 	   
 	 	for(int i = 0; i < this.enemies.size(); i++){  
 	 	
 	 	 	for(int j = 1; j < this.enemies.size(); j++){
 	 			if(j != i){
 	 		 		if(this.enemies.get(j).proche(this.enemies.get(i))){this.enemies.get(j).contact(this.enemies.get(i));} 
 	 			}
 	 		}
 	 	}    
 	 	
 	 
 	 	// enemies
 	 	for(int i = 0; i < this.enemies.size(); i++){
 	 	 	if(this.hero.proche(this.enemies.get(i)) && this.enemies.get(i).isVivant() == true){
 	 	 		this.hero.contact(this.enemies.get(i));
 	 	 		if(this.enemies.get(i).isVivant() == false){Audio.playSound("/audio/ecrasePersonnage.wav");}
 	 	 	}
 	 	}
 	 	
		// Déplacement de tous les objets "fixes" du jeu		
		this.deplacementFond();
		if(this.xPos >= 0 && this.xPos <= 4430){
		    for(int i = 0; i < this.tabObjets.size(); i++){this.tabObjets.get(i).deplacement();}
		 //   
		    l= Maillon.getPremier();
	 	 	while(l!=null){
	 	 		
	 	 		l.getValeur().deplacement();
	 	 		l=l.getSuivant();
	 	 	}
	 	 	
		 
	 		for(int i = 0; i < this.enemies.size(); i++){this.enemies.get(i).deplacement();}
		}
		
		// Image de fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		
		// Image de panzer départ
 		g2.drawImage(this.imgChateau1, -50 - this.xPos, 95, null);
    	

     	// Images des objets
 	 	for(int i = 0; i < this.tabObjets.size(); i++){
 	 		g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
 	 	}	
 	 	 
 	 	// Images des alphabeits
 	 	
 	 	 l= Maillon.getPremier();
	 	 	while(l!=null){
	 	 		g2.drawImage(l.getValeur().bouge(), l.getValeur().getX(), l.getValeur().getY(), null);
	 	 		l=l.getSuivant();
	 	 	}
	 	 	
 	 	

 	 	
        // Image de hero
 		if(this.hero.isVivant() == true){
 			if(this.hero.isSaut()){g2.drawImage(this.hero.saute(), this.hero.getX(), this.hero.getY(), null);}
 	 		else{g2.drawImage(this.hero.marche("Ac", 25), this.hero.getX(), this.hero.getY(), null);}
 		}else{g2.drawImage(this.hero.meurt(), this.hero.getX(), this.hero.getY(), null);}
 				
 	   
 	 		
 	 	// Images des enemies
 	    for(int i = 0; i < this.enemies.size(); i++){
 	 		if(this.enemies.get(i).isVivant() == true){
 	 		    g2.drawImage(this.enemies.get(i).marche("Ab", 50), this.enemies.get(i).getX(), this.enemies.get(i).getY(), null);
 	 	    }else{
 	 			g2.drawImage(this.enemies.get(i).meurt(), this.enemies.get(i).getX(), this.enemies.get(i).getY() + 30, null);				
 	 		}
 	 	}
 	    // Mise à jour du score
	    g2.setFont(police);
	   // g2.drawString(this.score.getNbrePieces() + " pièce(s) trouvée(s) sur " + this.score.getNBRE_TOTAL_PIECES(), 460, 25);
	    g2.drawString(s.toString(),460,25);
	    
	    
	    // Mise à jour du temps de jeu restant
	    g2.drawString(this.compteARebours.getStr(), 5, 25);
	    
	    // Fin de partie
	   
	    if(this.finDePartie() == true){
	    	Font policeFin = new Font("Arial", Font.BOLD, 50);
            g2.setFont(policeFin);
	        if(this.partieGagnee() == true){g2.drawString("Vous avez gagné !!", 120, 180);
	        terminer++;
	        if (terminer>20)
	 	   {
	 		 /*  Thread.currentThread().stop();
	 		 //Thread.currentThread().stop();
	 		  Thread.currentThread().suspend();
	 		  System.out.println(Thread.activeCount());
	 		  System.out.println("ds");
	 		  /*try {
				Thread.sleep(1000);
				System.exit(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	        	for (Thread t : Thread.getAllStackTraces().keySet()) 
	        	{  if (t.getState()==Thread.State.RUNNABLE) 
	        	     t.interrupt(); 
	        	} 

	        	for (Thread t : Thread.getAllStackTraces().keySet()) 
	        	{  if (t.getState()==Thread.State.RUNNABLE) 
	        	     t.stop(); 
	        	}
	 	   }
	        }
	      
	        else{g2.drawString("Vous avez perdu...", 120, 180);}
	               
	       
	       
	        
	    }
	    
	  
    }
}