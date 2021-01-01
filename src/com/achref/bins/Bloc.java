package com.achref.bins;

import javax.swing.ImageIcon;

public class Bloc extends Objet{
	//**** VARIABLES ****//
		
		
	//**** CONSTRUCTEUR	****//	
	public Bloc(int x, int y) {
		super(x, y, 30, 30);		
		super.icoObjet = new ImageIcon(getClass().getResource("/images/tab1.png"));
		super.imgObjet = this.icoObjet.getImage();
	}
		

}
