package com.achref.game.scene;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.achref.son.Audio;

//***** La classe Clavier gère les actions utilisateur au clavier *****//
public class Clavier implements KeyListener {

	// **** METHODES **//
	@Override
	public void keyPressed(KeyEvent e) {
		if (Main.scene.hero.isVivant() == true) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // flèche droite
				if (Main.scene.getxPos() == -1) {
					Main.scene.setxPos(0); // Réinitialisation de setxPos
					Main.scene.setxFond1(-50); // Réinitialisation de xFond1
					Main.scene.setxFond2(750); // Réinitialisation de xFond2
				}
				Main.scene.hero.setMarche(true);
				Main.scene.hero.setVersDroite(true);
				Main.scene.setDx(1); // Déplacement du fond vers la gauche lors de l'appui sur la touche "flèche droite"
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // flèche gauche
				if (Main.scene.getxPos() == 4431) {
					Main.scene.setxPos(4430);
					Main.scene.setxFond1(-50);
					Main.scene.setxFond2(750);
				}
				Main.scene.hero.setMarche(true);
				Main.scene.hero.setVersDroite(false);
				Main.scene.setDx(-1); // Déplacement du fond vers la droite lors de l'appui sur la touche "flèche gauche"
			}
			// hero saute
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				Main.scene.hero.setSaut(true);
				Audio.playSound("/audio/saut.wav");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.hero.setMarche(false);
		Main.scene.setDx(0);// Remise à 0 de la variable dx de la l'objet scene lors du relâchement des touches
	} 

	@Override
	public void keyTyped(KeyEvent e) {}
}