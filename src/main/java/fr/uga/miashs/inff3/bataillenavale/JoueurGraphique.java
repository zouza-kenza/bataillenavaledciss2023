package fr.uga.miashs.inff3.bataillenavale;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {
	
	private GrilleGraphique grilleTirs;
	Scanner sc = new Scanner(System.in);
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense,
			GrilleGraphique grilleTirs, String nom) {
				super(grilleDefense, nom);
				this.grilleTirs = grilleTirs;
			}

	public Coordonnee choixAttaque() {
		return grilleTirs.getCoordonneeSelectionnee();
	}
	protected void retourDefense(Coordonnee c, int etat) {
		  Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
			grilleTirs.colorie(c, couleur);
			switch (etat) {
			case TOUCHE:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez été touché en " + c);
			break;
			case COULE:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez été coulé en " + c);
			break;
			case GAMEOVER:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez perdu");
		
			}}
	protected void retourAttaque(Coordonnee c, int etat) {
		Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
		grilleTirs.colorie(c, couleur);
		switch (etat) {
		case TOUCHE:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez touchéun navire en " + c);
		break;
		case COULE:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
		break;
		case GAMEOVER:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");
		}
	}
}
