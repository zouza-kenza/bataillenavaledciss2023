package fr.uga.miashs.inff3.bataillenavale;

import java.awt.Color;

import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {
	
	private GrilleGraphique grilleTirs;
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense,
	GrilleGraphique grilleTirs, String nom) {
		super(nom);
		this.grilleDefense = new GrilleNavaleGraphique();
		this.grilleTirs = grilleTirs;
	}
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense,
	GrilleGraphique grilleTirs) {
		this(grilleDefense, nom);
	}
	
	public Coordonnee choixAttaque() {...}
	protected void retourDefense(Coordonnee c, int etat) {...}
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
