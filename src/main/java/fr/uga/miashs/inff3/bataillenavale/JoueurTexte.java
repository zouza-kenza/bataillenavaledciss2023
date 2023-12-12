package fr.uga.miashs.inff3.bataillenavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {
	private Scanner sc;
	
	public JoueurTexte(GrilleNavale g, String nom) {
		super(GrilleNavale g, String nom);
		this.sc = new Scanner(System.in);
	}
	 public JoueurTexte(GrilleNavale g) {
        	super(g);
		 this.sc = new Scanner(System.in);
    }
	
	protected void retourAttaque(Coordonnee c, int etat) {...}
	protected void retourDefense(Coordonnee c, int etat) {...}
	public Coordonnee choixAttaque() {...}

	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

