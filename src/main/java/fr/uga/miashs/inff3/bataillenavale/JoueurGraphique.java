package fr.uga.miashs.inff3.bataillenavale;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {
	
	private Scanner sc;
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
	public Coordonnee choixAttaque() {
        System.out.println("Saisissez la ligne pour l'attaque : ");
        	String ligne = sc.nextLine();
        System.out.println("Saisissez la colonne pour l'attaque : ");
        	String colonne = sc.nextLine();

    		String coordonneeStr = ligne + colonne; 

        return new Coordonnee(coordonneeStr) ;
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
	
	     
	     protected void retourAttaque(Coordonnee c, int etat) {
		Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
		grilleTirs.colorie(c, couleur);
		switch (etat) {
		case TOUCHE:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez touché un navire en " + c);
		break;
		case COULE:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
		break;
		case GAMEOVER:
		JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");
		}
	}
}
