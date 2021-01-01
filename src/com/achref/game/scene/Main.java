package com.achref.game.scene;

import javax.swing.JFrame;


public class Main {
	

	public static Scene scene;
	
	
	
	public static void main(String[] args) {
		
		// Création de la fenetre de l'application
		JFrame fenetre = new JFrame(" Hero game made by Hamrouni Achref 1Ing");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		// Instanciation de l'objet scene
		scene = new Scene();
				
		fenetre.setContentPane(scene); // LANCEMENT DE SCENE 
		fenetre.setVisible(true);		
	}
}