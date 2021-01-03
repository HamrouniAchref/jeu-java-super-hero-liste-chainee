package com.achref.liste.chainee;


import com.achref.bins.Alphabet;
import com.achref.liste.chainee.Maillon;

public class Maillon {
	Alphabet valeur;
	Maillon suivant;
	static Maillon premier = null ;
	
	
	Maillon(Alphabet valeur, Maillon suivant){
	this.valeur = valeur;
	this.suivant = suivant;
}
	

	public Maillon(Alphabet l) {
		this.valeur =l;
		this.suivant = null;
		}
	
		public Alphabet getValeur() {
		return valeur;
		}
		
		
		
		public void setValeur(Alphabet valeur) {
		this.valeur = valeur;
		}
		
		
		
		
		
		public void setPremier(Maillon m)
		{
			premier=m;
		}
		
		
		
		public Maillon getSuivant() {
			return suivant;
			}
		
		
		public void setSuivant(Maillon suivant) {
			this.suivant = suivant;
			}
		
		


		public static Maillon getPremier() {
			return premier;
			}
		
		
		
		public void ajouterAuDebut(Alphabet valeur) {
			Maillon nouveau= new Maillon(valeur,Maillon.premier);
			Maillon.premier=nouveau;
			}
		
		
		public int getLongueur() {
			int longueur= 0;
			Maillon l= Maillon.getPremier();
			while (l != null) {
			longueur++;
			
			l= l.getSuivant();
			}
			return longueur;
			}

            public static boolean estVide() {
            	return premier == null ;
            }
            
            
            
            private static Maillon getDernierElement() {
    			Maillon dernier= premier;
    			while (dernier.getSuivant() != null) {
    			dernier= dernier.getSuivant();
    			}
    			return dernier;
    			}
		public static void ajouterALaFin(Alphabet a) {
			if (estVide()) {
			premier= new Maillon(a);
			} else {
			
			Maillon dernier = getDernierElement();
			
			dernier.setSuivant(new Maillon(a));
			}
			}
			 public static void afficheListe()
			 {
				 Maillon l = premier;
				 while(l!=null) {
					 System.out.println(l.valeur.getChar());
					 l=l.suivant;
				 }
					 
			 }
			 public Maillon supprimeElement(Maillon l,Alphabet a) {
				
				 if (l== null) {
				 return l;
				 } else if (l.getValeur() == a) {
				 return l.getSuivant();
				 } else {
				 l.setSuivant(supprimeElement(l.getSuivant(), a));
				 return l;
				 }
				 }
		 
		
			

}
