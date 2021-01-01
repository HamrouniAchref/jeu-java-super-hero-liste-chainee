package com.achref.bins;

import javax.swing.ImageIcon;

public class Obstacle extends Objet{
	
	//**** VARIABLES ****//
	
	
	//**** CONSTRUCTEUR	****//	
	public Obstacle(int x, int y) {
		super(x, y, 43, 65);		
		super.icoObjet = new ImageIcon(getClass().getResource("/images/sar.png"));
		super.imgObjet = this.icoObjet.getImage();
	}
	
	
	//**** GETTERS ****//		
		
		
	//**** SETTERS ****//
		

	//**** METHODES ****//

}